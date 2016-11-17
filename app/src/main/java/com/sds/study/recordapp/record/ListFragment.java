package com.sds.study.recordapp.record;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.sds.study.recordapp.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 파일 목록을 보여줄 Fragment
 */

public class ListFragment extends Fragment implements AdapterView.OnItemClickListener{
    String TAG;
    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<String> list;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_list,null);
        TAG=getClass().getName();
        listView = (ListView) view.findViewById(R.id.listView);
        list=(ArrayList) getFiles();

        adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);//껍데기와 연결
        //리스트뷰와 리스너 연결
        listView.setOnItemClickListener(this);
        return view;
    }
    /*외부 저장소인 iot_record 디렉토리의 모든 파일을 가져오자*/
    public List getFiles(){
        File dir = new File(Environment.getExternalStorageDirectory(),"iot_record");
        File[] files=dir.listFiles();
        ArrayList list = new ArrayList();
        for(int i=0; i<files.length;i++){
            list.add(files[i].getName());
        }

        return list;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int index, long id) {
        TextView txt=(TextView)view;
        String filename=txt.getText().toString();
        Toast.makeText(getContext(),"파일명은"+filename,Toast.LENGTH_SHORT ).show();

        /*뷰페이저 중  index1(2번째 페이지)에 해당하는 DetailFragment 보여주기*/
        FileListActivity fileListActivity =(FileListActivity)getContext();
        Log.d(TAG,"파일리스트액티비티"+fileListActivity);
        fileListActivity.viewPager.setCurrentItem(1);
    }
}
