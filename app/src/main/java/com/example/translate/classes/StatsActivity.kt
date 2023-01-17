package com.example.translate.classes

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.translate.R
import com.example.translate.database.StatsActivityViewModel
import com.example.translate.database.Words
import kotlinx.android.synthetic.main.activity_stats.*


class StatsActivity : AppCompatActivity() {

    private lateinit var mStatsViewModel: StatsActivityViewModel
    private lateinit var nStatsViewModel: StatsActivityViewModel
    private lateinit var oStatsViewModel: StatsActivityViewModel
    private var total: Int = 0
    private var idsList: ArrayList<*>? = null
    private lateinit var preference: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stats)

        total = intent.getIntExtra("total", 0)
        onSave()

        idsList = intent.getSerializableExtra("ids") as ArrayList<*>?

        mStatsViewModel = ViewModelProvider(this).get(StatsActivityViewModel::class.java)

        val actionbar = supportActionBar

        actionbar!!.title = "Check Progress"

        actionbar.setDisplayHomeAsUpEnabled(true)

        val adapter = StatsListAdapter()
        recycler_view_stats.layoutManager = LinearLayoutManager(this)
        recycler_view_stats.adapter = adapter


        nStatsViewModel = ViewModelProvider(this).get(StatsActivityViewModel::class.java)



        nStatsViewModel.readAllData.observe(this, { word -> adapter.setData(word) })

        oStatsViewModel = ViewModelProvider(this).get(StatsActivityViewModel::class.java)

        preference = getSharedPreferences("prefs", Context.MODE_PRIVATE)
        val firstStart = preference.getBoolean("firstStart", true)
        if (firstStart) {

            insertDataToDatabase()
        } else {

            updateItem()
        }

    }

    private fun insertDataToDatabase() {
        var word = Words(1, "один", 0, 0)
        mStatsViewModel.addWord(word)
        word = Words(2, "два", 0, 0)
        mStatsViewModel.addWord(word)
        word = Words(3, "три", 0, 0)
        mStatsViewModel.addWord(word)
        word = Words(4, "чотири", 0, 0)
        mStatsViewModel.addWord(word)
        word = Words(5, "п'ять", 0, 0)
        mStatsViewModel.addWord(word)
        word = Words(6, "шість", 0, 0)
        mStatsViewModel.addWord(word)
        word = Words(7, "сім", 0, 0)
        mStatsViewModel.addWord(word)
        word = Words(8, "вісім", 0, 0)
        mStatsViewModel.addWord(word)
        word = Words(9, "дев'ять", 0, 0)
        mStatsViewModel.addWord(word)

        val editor = preference.edit()
        editor.putBoolean("firstStart", false)
        editor.apply()

        Toast.makeText(this, "Data added!", Toast.LENGTH_LONG).show()
    }

    private fun updateItem() {

        val pref = getSharedPreferences("sharedprefs", Context.MODE_PRIVATE)
        var totalQues = pref.getInt("total_questions", 0)
        totalQues += total
        val editor = pref.edit()
        editor.putInt("total_questions", totalQues)
        editor.apply()

        if (idsList != null) {
            val correctAns = 0

            var updateWord = Words(1, "один", correctAns, totalQues)
            oStatsViewModel.updateWord(updateWord)
            updateWord = Words(2, "два", correctAns, totalQues)
            oStatsViewModel.updateWord(updateWord)
            updateWord = Words(3, "три", correctAns, totalQues)
            oStatsViewModel.updateWord(updateWord)
            updateWord = Words(4, "чотири", correctAns, totalQues)
            oStatsViewModel.updateWord(updateWord)
            updateWord = Words(5, "п'ять", correctAns, totalQues)
            oStatsViewModel.updateWord(updateWord)
            updateWord = Words(6, "шість", correctAns, totalQues)
            oStatsViewModel.updateWord(updateWord)
            updateWord = Words(7, "сім", correctAns, totalQues)
            oStatsViewModel.updateWord(updateWord)
            updateWord = Words(8, "вісім", correctAns, totalQues)
            oStatsViewModel.updateWord(updateWord)
            updateWord = Words(9, "дев'ять", correctAns, totalQues)
            oStatsViewModel.updateWord(updateWord)


            for (i in 0 until idsList!!.size) {
                var correctAns = 0
                when {

                    idsList!![i] == 1 -> {
                        correctAns++
                        val updateWord1 = Words(1, "один", correctAns, totalQues)
                        oStatsViewModel.updateWord(updateWord1)

                    }

                    idsList!![i] == 2 -> {
                        correctAns++
                        val updateWord2 = Words(2, "два", correctAns, totalQues)
                        oStatsViewModel.updateWord(updateWord2)
                    }

                    idsList!![i] == 3 -> {
                        correctAns++
                        val updateWord3 = Words(3, "три", correctAns, totalQues)
                        oStatsViewModel.updateWord(updateWord3)
                    }

                    idsList!![i] == 4 -> {
                        correctAns++
                        val updateWord4 = Words(4, "чотири", correctAns, totalQues)
                        oStatsViewModel.updateWord(updateWord4)
                    }

                    idsList!![i] == 5 -> {
                        correctAns++
                        val updateWord5 = Words(5, "п'ять", correctAns, totalQues)
                        oStatsViewModel.updateWord(updateWord5)
                    }

                    idsList!![i] == 6 -> {
                        correctAns++
                        val updateWord6 = Words(6, "шість", correctAns, totalQues)
                        oStatsViewModel.updateWord(updateWord6)
                    }

                    idsList!![i] == 7 -> {
                        correctAns++
                        val updateWord7 = Words(7, "сім", correctAns, totalQues)
                        oStatsViewModel.updateWord(updateWord7)
                    }

                    idsList!![i] == 8 -> {
                        correctAns++
                        val updateWord8 = Words(8, "вісім", correctAns, totalQues)
                        oStatsViewModel.updateWord(updateWord8)
                    }

                    else -> {
                        correctAns++
                        val updateWord9 = Words(9, "дев'ять", correctAns, totalQues)
                        oStatsViewModel.updateWord(updateWord9)
                    }
                }

            }
        }


    }
    //save data in shared preferences,so it remembers the total number of quizzes taken
    private fun onSave() {
        val pref: SharedPreferences = getSharedPreferences("sharedsprefs", Context.MODE_PRIVATE)
        val editor = pref.edit()

        if (total > 0) {
            editor.putInt("total_questions", total)
            editor.apply()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}