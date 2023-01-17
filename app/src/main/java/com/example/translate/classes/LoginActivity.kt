package com.example.translate.classes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.translate.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // get reference to all views
        val et_user_name = findViewById<EditText>(R.id.et_user_name)
        val et_password = findViewById<EditText>(R.id.et_password)
        val btn_reset = findViewById<Button>(R.id.btn_reset)
        val btn_submit = findViewById<Button>(R.id.btn_submitt)


        btn_reset.setOnClickListener {
            // clearing user_name and password edit text views on reset button click
            et_user_name.setText("")
            et_password.setText("")
        }

        // set on-click listener
        btn_submit.setOnClickListener {
            val user_name = et_user_name.text;
            val password = et_password.text;
            Toast.makeText(this@LoginActivity, user_name, Toast.LENGTH_LONG).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }
}