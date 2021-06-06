package com.stathis.marvelmania.features.register

import android.content.Intent
import android.content.res.ColorStateList
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.stathis.marvelmania.R
import com.stathis.marvelmania.abstraction.MarvelActivity
import com.stathis.marvelmania.features.dashboard.DashboardActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.email_input_field
import kotlinx.android.synthetic.main.activity_register.pass_input_field
import kotlinx.android.synthetic.main.activity_register.register_btn

class RegisterActivity : MarvelActivity(R.layout.activity_register) {

    private lateinit var viewModel: RegisterViewModel

    override fun initLayout() {
        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
    }

    override fun startOperations() {
        register_btn.setOnClickListener {
            val email = email_input_field.text.toString()
            val pass = pass_input_field.text.toString()
            val passConf = pass_conf_input_field.text.toString()

            viewModel.validateUserInput(email, pass, passConf)
        }

        viewModel.userCreated.observe(this, Observer {
            when (it) {
                true -> loginUser()
                false -> throwRegisterErrors()
            }
        })

        viewModel.passwordsMatch.observe(this,Observer{
            when (it){
                true -> Unit
                false -> throwRegisterErrors()
            }
        })
    }

    private fun loginUser() {
        startActivity(Intent(this, DashboardActivity::class.java))
    }

    private fun throwRegisterErrors() {
        /*
        As a user I want to be notified about the fact that my passwords might not match
         */
        pass_input_field.error = resources.getString(R.string.wrong_password)
        pass_conf_input_field.error = resources.getString(R.string.wrong_password)
    }

    override fun stopOperations() {
        viewModel.userCreated.removeObservers(this)
    }
}