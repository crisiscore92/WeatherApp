package com.crisiscore.www.weatherapp.ui.fivedaysforecast.adapters

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.crisiscore.www.weatherapp.ui.fivedaysforecast.fragments.dayfragment.DayFragment


class ViewPagerDaysAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {

    private val tabsCount = 5

    private val dateList = ArrayList<String>()

    override fun getItem(position: Int): Fragment? {
        val fragment = DayFragment()
        val bundle = Bundle()
        Log.d("myLogs", position.toString())
        bundle.putString("date", dateList[position])
        return when(position) {
            0 -> {
                bundle.putBoolean("firstPage", true)
                fragment.arguments = bundle
                fragment
            }
            1, 2, 3, 4  -> {
                fragment.arguments = bundle
                fragment
            }
            else -> {
                fragment.arguments = bundle
                fragment
            }
        }

    }

    override fun getCount(): Int = tabsCount

    override fun getPageTitle(position: Int): CharSequence = dateList[position]

    fun initList(receivedDateList: ArrayList<String>) {
        dateList.addAll(receivedDateList)
    }
}