package com.indieme.mbuddy.service.repository

import android.util.Log
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.firestore.FirebaseFirestore
import com.indieme.mbuddy.service.model.StandardReponse
import io.reactivex.Observable

object SignUpRepository : FireBaseService {

    fun signUpUser(params: Map<String, Any>, instance: FirebaseFirestore?): Observable<StandardReponse<String>> {
        var response = StandardReponse("", "Success", 200);

        signUp(params, instance)
            .addOnSuccessListener {
                response.message = "Success";
                response.status = 200;
                response.response = "Successfully Registered";
            }
            .addOnFailureListener {
                response.message = "Success";
                response.status = 400;
                response.response = "Registration Failed";
            }

        return Observable.just(response);

    }

}