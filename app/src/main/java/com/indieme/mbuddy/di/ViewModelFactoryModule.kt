package com.indieme.mbuddy.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.indieme.mbuddy.viewmodel.SignUpViewModel
import com.indieme.mbuddy.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelFactoryModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SignUpViewModel::class)
    abstract fun bindSignUpViewModel(userViewModel: SignUpViewModel): ViewModel

}