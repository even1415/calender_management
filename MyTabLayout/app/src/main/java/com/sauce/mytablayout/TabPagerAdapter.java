package com.sauce.mytablayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Junyoung on 2016-06-23.
 */

public class TabPagerAdapter extends FragmentStatePagerAdapter {

    // Count number of tabs
    private int tabCount;

    public TabPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {

        // Returning the current tabs
        switch (position) {
            case 0:
                Tab_Cal tabCal = new Tab_Cal();
                return tabCal;
            case 1:
                Tab_Alarm tabAlarm = new Tab_Alarm();
                return tabAlarm;
            case 2:
                Tab_List tabList = new Tab_List();
                return tabList;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
