package com.example.translate.classes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.translate.R
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    var count: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        count++


        val correctAns = intent.getIntExtra("correctAnswers", 0)

        val totalQues = intent.getIntExtra("totalQuestion", 9)

        val idsList = intent.getSerializableExtra("ids") as ArrayList<*>?


        show_result.text = "$correctAns / $totalQues"


        findViewById<TextView>(R.id.goto_home).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }


        findViewById<Button>(R.id.open_progress_button).setOnClickListener {
            val intent = Intent(this, StatsActivity::class.java)
            intent.putExtra("total", count)
            intent.putExtra("ids", idsList)
            startActivity(intent)
            finish()

        }

    }

}