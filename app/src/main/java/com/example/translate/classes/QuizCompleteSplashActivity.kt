package com.example.translate.classes

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.translate.R


@Suppress("DEPRECATION")
class QuizCompleteSplashActivity : AppCompatActivity() {
    //time for activity to be open for
    private val splashTIME: Long = 3300

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_complete_splash)

        val correct = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        val total = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)

        val idsList = intent.getSerializableExtra("ids") as ArrayList<*>?


        Handler().postDelayed({
            val intent = Intent(this, ResultActivity::class.java)

            intent.putExtra("totalQuestion", total)

            intent.putExtra("correctAnswers", correct)

            intent.putExtra("ids", idsList)

            startActivity(intent)
            finish()
        }, splashTIME)
    }


}