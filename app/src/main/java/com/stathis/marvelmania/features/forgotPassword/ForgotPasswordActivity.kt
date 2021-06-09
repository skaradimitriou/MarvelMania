package com.stathis.marvelmania.features.forgotPassword

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.stathis.marvelmania.R
import com.stathis.marvelmania.abstraction.MarvelActivity
import com.stathis.marvelmania.features.login.LoginActivity
import kotlinx.android.synthetic.main.activity_forgot_password.*

class ForgotPasswordActivity : MarvelActivity(R.layout.activity_forgot_password) {

    private lateinit var viewModel : ForgotPasswordViewModel

    override fun initLayout() {
        viewModel = ViewModelProvider(this).get(ForgotPasswordViewModel::class.java)
    }

    override fun startOperations() {
        forgot_pass_btn.setOnClickListener{
            val email = forgot_pass_btn.text.toString()
            viewModel.verifyEmail(email)
        }

        viewModel.userVerified.observe(this, Observer{
            when (it) {
                true -> {
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                }
                false -> Toast.makeText(this,"User does not exist", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun stopOperations() {
        viewModel.userVerified.removeObservers(this)
    }
}