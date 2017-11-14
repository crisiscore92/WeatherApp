package com.crisiscore.www.weatherapp.ui.settings

import android.app.FragmentManager
import com.crisiscore.www.weatherapp.R

class SettingsActivityPresenter(private val fragmentManager: FragmentManager,
                                private val settingsFragment: SettingsActivity.PrefsFragment):
        SettingsActivityContract.Presenter {


    override fun replaceContentWithSettingsFragment() {
        fragmentManager.beginTransaction().replace(R.id.settings_fragment_container, settingsFragment).commit()
    }
}