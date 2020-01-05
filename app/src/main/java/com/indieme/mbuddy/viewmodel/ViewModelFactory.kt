package com.indieme.mbuddy.viewmodel

import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.indieme.mbuddy.di.AppScope
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
@Suppress("UNCHECKED_CAST")
class ViewModelFactory @Inject constructor(private val mProviderMap: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>) :
    ViewModelProvider.Factory {
    @NonNull
    override fun <T : ViewModel?> create(@NonNull modelClass: Class<T>): T {
//        return mProviderMap[modelClass]!!.get() as T
        val creator = mProviderMap[modelClass] ?:
        mProviderMap.asIterable().firstOrNull {
            modelClass.isAssignableFrom(it.key)
        }?.value ?: throw IllegalArgumentException("unknown model class $modelClass")
        return try {
            creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

}