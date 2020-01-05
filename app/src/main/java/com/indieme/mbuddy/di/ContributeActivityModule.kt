package com.indieme.mbuddy.di

import com.indieme.mbuddy.view.ui.login.LoginActivity
import com.indieme.mbuddy.view.ui.login.LoginSubComponent
import com.indieme.mbuddy.view.ui.signup.SignUpActivity
import com.indieme.mbuddy.view.ui.signup.SignUpSubComponent
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap


@Module(subcomponents = [SignUpSubComponent::class, LoginSubComponent::class])
internal abstract class ContributeActivityModule {
    @Binds
    @IntoMap
    @ClassKey(SignUpActivity::class)
    abstract fun bindSignUpInjectorFactory(factory: SignUpSubComponent.Factory?): AndroidInjector.Factory<*>?

    @Binds
    @IntoMap
    @ClassKey(LoginActivity::class)
    abstract fun bindLoginInjectorFactory(factory: LoginSubComponent.Factory?): AndroidInjector.Factory<*>?

}
