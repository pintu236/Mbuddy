package com.indieme.mbuddy.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.indieme.mbuddy.service.model.StandardReponse
import com.indieme.mbuddy.service.repository.SignUpRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.AsyncSubject
import javax.inject.Inject

class SignUpViewModel @Inject constructor(private val firebaseInstance: FirebaseFirestore?) : ViewModel() {

    public val signUpSubject: AsyncSubject<StandardReponse<String>> = AsyncSubject.create()

    fun signUp(params: Map<String, Any>) {
        SignUpRepository.signUpUser(params, firebaseInstance)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(signUpSubject);
    }



}