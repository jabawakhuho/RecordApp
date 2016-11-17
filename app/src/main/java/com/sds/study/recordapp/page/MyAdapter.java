package com.sds.study.recordapp.page;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 *ViewPager는 껍데기에 불과하므로, 뷰페이지에 보여질
 *Fragment가 총 몇개고, 어떤 페이지를 보여줘야 할지를 관리해 주는 어댑터를 이용해야 한다..
 * 트랜젝션 - 해당 업무가 모두 성공해야 작업을 성공으로 하는 논리적 업무 단위
 */

public class MyAdapter extends FragmentStatePagerAdapter{
    /*앱에서 사용할 Fragment를 준비하자*/
    Fragment[] fragments  = new Fragment[3];

    public MyAdapter(FragmentManager fm) {
        super(fm);
        fragments[0]= new FragmentA();
        fragments[1]= new FragmentB();
        fragments[2]= new FragmentC();
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }
}
