package com.indieme.mbuddy.view.ui.signup

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.indieme.mbuddy.MBuddyApplication
import com.indieme.mbuddy.R
import com.indieme.mbuddy.utils.K_EMAIL
import com.indieme.mbuddy.utils.K_PASSWORD
import com.indieme.mbuddy.utils.K_USERNAME
import com.indieme.mbuddy.view.ui.base.BaseActivity
import com.indieme.mbuddy.view.ui.base.MVVMView
import com.indieme.mbuddy.viewmodel.SignUpViewModel
import com.indieme.mbuddy.viewmodel.ViewModelFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.sign_up_layout.*
import javax.inject.Inject

class SignUpActivity : BaseActivity(), MVVMView {
    private val params: HashMap<String, Any> = HashMap()
    // You want Dagger to provide an instance of ViewModelFactory from the graph
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: SignUpViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up_layout)

        initializeViews()

        viewModel = ViewModelProviders.of(this,viewModelFactory).get(SignUpViewModel::class.java)

        btnSignUp.setOnClickListener {
            if (isValidate()) {
                params.put(K_EMAIL, email.text.toString().trim());
                params.put(K_USERNAME, userName.text.toString().trim());
                params.put(K_PASSWORD, password.text.toString().trim());
                viewModel.signUp(params);
            }
        }
    }

    private fun isValidate(): Boolean {
        if (userName.text.toString().isEmpty()) {
            showMessage(R.string.please_enter_username)
            return false;
        } else if (email.text.toString().isEmpty()) {
            showMessage(R.string.please_enter_email)
            return false;
        } else if (password.text.toString().isEmpty()) {
            showMessage(R.string.please_enter_password)
            return false;
        } else if (confirmPassword.text.toString().isEmpty()) {
            showMessage(R.string.please_enter_password)
            return false;
        }
        return true;
    }

    private fun initializeViews() {
        setScreenTitle(R.string.sign_up)
        getBackButton().setOnClickListener { onBackPressed() }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, SignUpActivity::class.java);
            return intent;
        }
    }

    override fun bindViewModel() {
        viewModel.signUpSubject
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { response-> if(response.status==200){

            } }
    }

    override fun unbindViewModel() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

