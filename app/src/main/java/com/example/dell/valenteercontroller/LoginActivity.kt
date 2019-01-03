package com.example.dell.valenteercontroller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        progressBarDisable(login_progress_bar, login_loading_text)
        btn_server_login.setOnClickListener{
            goToHomepage()
        }
    }

    private fun goToHomepage() {
        startActivity(Intent(this.applicationContext, HomepageActivity::class.java))
    }
}
