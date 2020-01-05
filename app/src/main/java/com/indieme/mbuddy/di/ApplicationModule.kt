package com.indieme.mbuddy.di

import android.app.Application
import android.content.Context
import androidx.annotation.Nullable
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/*
* AppModule is a Dagger module responsible for providing singleton services on the application level
* such as Firebase Service and ProjectViewModelFactory.
* */

@Module
class ApplicationModule {

    @Singleton
    @Provides
    open fun provideContext(application: Application): Context? {
        return application.applicationContext
    }

    @Singleton
    @Provides
    open fun provideFirebaseFirestore(): FirebaseFirestore? {
        return FirebaseFirestore.getInstance()
    }

//    @Nullable
//    @Provides
//    open fun provideUser(): FirebaseUser? {
//        return FirebaseAuth.getInstance().getCurrentUser()
//    }
}
