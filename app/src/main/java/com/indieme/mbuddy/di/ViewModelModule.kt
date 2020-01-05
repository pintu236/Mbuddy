package com.indieme.mbuddy.di

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.indieme.mbuddy.viewmodel.SignUpViewModel
import com.indieme.mbuddy.viewmodel.ViewModelFactory
import dagger.MapKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Provider
import javax.inject.Singleton
import kotlin.reflect.KClass

// @Module informs Dagger that this class is a Dagger Module
@Module
class ViewModelModule {
    @Target(AnnotationTarget.FUNCTION)
    @Retention(AnnotationRetention.RUNTIME)
    @MapKey
    annotation class ViewModelKey(val value: KClass<out ViewModel>)

    // @Provides tell Dagger how to create instances of the type that this function
    // returns (i.e. ViewModelFactory).
    // Function parameters are the dependencies of this type.
    @Singleton
    @Provides
    fun viewModelFactory(providerMap: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>): ViewModelFactory? {
        // Whenever Dagger needs to provide an instance of type ViewModelFactory,
        // this code (the one inside the @Provides method) is run.
        return ViewModelFactory(providerMap)
    }

    @Provides
    @IntoMap
    @ViewModelKey(SignUpViewModel::class)
    fun signUpViewModel(firebaseFirestore: FirebaseFirestore?): ViewModel? {
        return SignUpViewModel(firebaseFirestore)
    }
}