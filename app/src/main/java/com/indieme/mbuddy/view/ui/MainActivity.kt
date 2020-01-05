package com.indieme.mbuddy.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.indieme.mbuddy.R
import com.indieme.mbuddy.view.ui.login.LoginActivity
import com.indieme.mbuddy.view.ui.signup.SignUpActivity
import kotlinx.android.synthetic.main.activity_main.*

public class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSignUp.setOnClickListener { startActivity(SignUpActivity.newIntent(this)) }
        btnSignIn.setOnClickListener { startActivity(LoginActivity.newIntent(this)) }
    }






}
