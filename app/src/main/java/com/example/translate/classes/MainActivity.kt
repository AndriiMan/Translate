package com.example.translate.classes

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.cardview.widget.CardView
import com.example.translate.R
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var spinner: Spinner
    lateinit var locale: Locale
    private var currentLanguage = "en"
    private var currentLang: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<CardView>(R.id.word_card).setOnClickListener {
            onClickWords(it)
        }

        findViewById<CardView>(R.id.quiz_card).setOnClickListener {
            onClickQuiz(it)
        }

        findViewById<CardView>(R.id.stats_card).setOnClickListener {
            onClickStats(it)
        }


        findViewById<Button>(R.id.word_button).setOnClickListener {
            onClickWords(it)
        }


        findViewById<Button>(R.id.quiz_button).setOnClickListener {
            onClickQuiz(it)
        }

        findViewById<Button>(R.id.stats_button).setOnClickListener {
            onClickStats(it)
        }

        currentLanguage = intent.getStringExtra(currentLang).toString()
        spinner = findViewById(R.id.spinner)
        val list = ArrayList<String>()
        list.add("Select Language")
        list.add("English")
        list.add("Ukrainian")

        val adapter = ArrayAdapter(
            this,
            com.airbnb.lottie.R.layout.support_simple_spinner_dropdown_item,
            list
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                when (position) {
                    0 -> {
                    }
                    1 -> setLocale("en")
                    2 -> setLocale("uk")
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }


    }

    //Switch with locale
    private fun setLocale(localeName: String) {
        if (localeName != currentLanguage) {
            locale = Locale(localeName)
            val res = resources
            val dm = res.displayMetrics
            val conf = res.configuration
            conf.locale = locale
            res.updateConfiguration(conf, dm)
            val refresh = Intent(
                this,
                MainActivity::class.java
            )
            refresh.putExtra(currentLang, localeName)
            startActivity(refresh)
        } else {
            Toast.makeText(
                this@MainActivity, "Language, , already, , selected)!", Toast.LENGTH_SHORT
            ).show();
        }
    }

    //Open the Quiz activity
    fun onClickQuiz(view: View) {
        val intent = Intent(this, QuizActivity::class.java)
        startActivity(intent)

    }

    //Open the Stats activity
    fun onClickStats(view: View) {
        val intent = Intent(this, StatsActivity::class.java)
        startActivity(intent)

    }

    //Open the Words activity
    fun onClickWords(view: View) {
        val intent = Intent(this, WordsActivity::class.java)
        startActivity(intent)

    }


}