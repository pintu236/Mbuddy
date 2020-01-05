package com.indieme.mbuddy.view.ui.signup

import com.indieme.mbuddy.di.ActivityScope
import com.indieme.mbuddy.di.ViewModelFactoryModule
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.AndroidInjector


@Subcomponent(modules = [ViewModelFactoryModule::class])
interface SignUpSubComponent : AndroidInjector<SignUpActivity> {
    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<SignUpActivity>
}


