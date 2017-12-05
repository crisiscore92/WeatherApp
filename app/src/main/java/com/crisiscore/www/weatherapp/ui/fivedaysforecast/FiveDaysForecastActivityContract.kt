package com.crisiscore.www.weatherapp.ui.fivedaysforecast

import com.crisiscore.www.weatherapp.ui.fivedaysforecast.adapters.ViewPagerDaysAdapter

interface FiveDaysForecastActivityContract {

    interface View {

        fun setUpViewPagerDaysAdapter(receivedDateList: ArrayList<String>)
    }

    interface Presenter {

        fun getDataForViewPagerDaysAdapter()
    }
}