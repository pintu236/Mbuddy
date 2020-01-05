package com.indieme.mbuddy.view.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.indieme.mbuddy.view.ui.base.BaseActivity
import com.indieme.mbuddy.R

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_layout);
        initializeViews();
    }

    private fun initializeViews() {
        setScreenTitle(R.string.sign_in)
        getBackButton().setOnClickListener { onBackPressed() }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, LoginActivity::class.java);
            return intent;
        }
    }
}