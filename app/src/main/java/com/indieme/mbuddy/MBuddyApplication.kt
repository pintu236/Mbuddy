package com.indieme.mbuddy

import com.indieme.mbuddy.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


class MBuddyApplication : DaggerApplication() {

    private val appComponent: AndroidInjector<MBuddyApplication> by lazy {
        DaggerApplicationComponent.builder().application(this).build();
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return appComponent
    }
}