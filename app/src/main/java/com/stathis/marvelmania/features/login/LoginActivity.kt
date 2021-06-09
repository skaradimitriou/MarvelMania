package com.stathis.marvelmania.features.login

import android.content.Intent
import android.content.res.ColorStateList
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.stathis.marvelmania.R
import com.stathis.marvelmania.abstraction.MarvelActivity
import com.stathis.marvelmania.features.dashboard.DashboardActivity
import com.stathis.marvelmania.features.forgotPassword.ForgotPasswordActivity
import com.stathis.marvelmania.features.register.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : MarvelActivity(R.layout.activity_login) {

    private lateinit var viewModel : LoginViewModel

    override fun initLayout() {
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    override fun startOperations() {
        login_btn.setOnClickListener{
            val email = email_input_field.text.toString()
            val pass = pass_input_field.text.toString()

            viewModel.validateUser(email,pass)
        }

        register_btn.setOnClickListener{
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        forgot_password.setOnClickListener{
            startActivity(Intent(this, ForgotPasswordActivity::class.java))
        }

        viewModel.userAuthenticated.observe(this, Observer{
            when(it){
                true -> login()
                false -> throwLoginError()
            }
        })
    }

    private fun login() {
        startActivity(Intent(this, DashboardActivity::class.java))
        finish()
    }

    private fun throwLoginError() {
        /*
        As a user I want to be notified somehow about a failed login attempt
         */

        email_input_field.error = resources.getString(R.string.wrong_email)
        email_input_field.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.yellow))
        pass_input_field.error = resources.getString(R.string.wrong_password)
        pass_input_field.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.yellow))
    }

    override fun stopOperations() {
        viewModel.userAuthenticated.removeObservers(this)
    }
}