package com.indieme.mbuddy.service.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.indieme.mbuddy.utils.USERS

interface FireBaseService {
    fun signUp(params: Map<String, Any>, instance: FirebaseFirestore?): Task<Void> {
        return instance?.collection(USERS)?.document("1")?.set(params) as Task<Void>;
    }
}