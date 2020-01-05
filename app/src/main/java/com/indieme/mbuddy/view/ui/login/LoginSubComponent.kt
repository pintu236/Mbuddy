package com.indieme.mbuddy.view.ui.login

import com.indieme.mbuddy.di.ViewModelFactoryModule
import com.indieme.mbuddy.view.ui.signup.SignUpActivity
import dagger.Module
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [ViewModelFactoryModule::class])
interface LoginSubComponent : AndroidInjector<LoginActivity> {
    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<LoginActivity>
}