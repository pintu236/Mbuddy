package com.indieme.mbuddy.di

import android.app.Application
import com.indieme.mbuddy.MBuddyApplication
import com.indieme.mbuddy.view.ui.login.LoginActivity
import com.indieme.mbuddy.view.ui.signup.SignUpActivity
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjection
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


/*
* AppComponent is responsible for injecting AppModule.
* */
@Singleton
@Component(
    modules = [AndroidInjectionModule::class, ApplicationModule::class, ViewModelFactoryModule::class
        , ContributeActivityModule::class]
)
interface ApplicationComponent : AndroidInjector<MBuddyApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    override fun inject(app: MBuddyApplication)

    fun inject(activity: SignUpActivity)

}
