package com.crisiscore.www.weatherapp.ui.fivedaysforecast.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.FragmentStatePagerAdapter
import com.crisiscore.www.weatherapp.ui.fivedaysforecast.fragments.DetailedDayFragment
import com.crisiscore.www.weatherapp.ui.fivedaysforecast.fragments.dayfragment.DayFragment


class ViewPagerWeatherElementsAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {

    private val tabsCount = 3

    override fun getItem(position: Int): Fragment? {
        return when(position) {
            0 -> DetailedDayFragment()
            1 -> DetailedDayFragment()
            2 -> DetailedDayFragment()
            else -> DetailedDayFragment()
        }

    }

    override fun getCount(): Int {
        return tabsCount
    }

    override fun getPageTitle(position: Int): CharSequence {
        return "2222"
    }
}