@file:Suppress("DEPRECATION")

package com.example.translate.classes

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Context
import android.net.ConnectivityManager
import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.translate.R
import kotlinx.android.synthetic.main.activity_words.*
import org.json.JSONArray
import java.net.HttpURLConnection
import java.net.URL


class WordsActivity : AppCompatActivity() {
    lateinit var pDialog: ProgressDialog
    private val url = "" //set the url of the json file
    private val jsonLocal = "[\n" +
            "   {\n" +
            "      \"word\":\"Один\",\n" +
            "      \"meaning\":\"Jeden\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"word\":\"Два\",\n" +
            "      \"meaning\":\"Dwa\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"word\":\"Три\",\n" +
            "      \"meaning\":\"Trzy\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"word\":\"Чотири\",\n" +
            "      \"meaning\":\"Cztery\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"word\":\"Пять\",\n" +
            "      \"meaning\":\"Pięć\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"word\":\"Шість\",\n" +
            "      \"meaning\":\"Sześć\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"word\":\"Сім\",\n" +
            "      \"meaning\":\"Siedem\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"word\":\"Вісім\",\n" +
            "      \"meaning\":\"Ośiem\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"word\":\"Девять\",\n" +
            "      \"meaning\":\"Dziewięć\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"word\":\"Десять\",\n" +
            "      \"meaning\":\"Dziesiąć\"\n" +
            "   }\n" +
            "]"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_words)
        lottieAnimationView_notConnected.visibility = View.GONE //hide the animation
        recycler_view_words.layoutManager = LinearLayoutManager(this)
        recycler_view_words.setHasFixedSize(true)
        internetNotConnected()


        val actionbar = supportActionBar

        actionbar!!.title = "Learn new words daily"

        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    @SuppressLint("StaticFieldLeak")
    inner class AsyncTaskHandler : AsyncTask<String, String, String>() {

        override fun onPreExecute() {
            super.onPreExecute()
            //show a progress dialog when the activity is opened that says please wait
            pDialog = ProgressDialog(this@WordsActivity)
            pDialog.setMessage("please wait")
            pDialog.setCancelable(false)
            pDialog.show()
        }

        override fun doInBackground(vararg url: String?): String {

            val res: String = ""
            /*val connection = URL(url[0]).openConnection() as HttpURLConnection //connect to the url given as an http link


            try {
                connection.connect() //try connecting
                res = connection.inputStream.use { it.reader().use { reader -> reader.readText() } } //read the data from the file
            } finally {
                connection.disconnect() //disconnect from the file if can not connect
            }*/
            return res
        }


        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            if (pDialog.isShowing) {
                pDialog.cancel()
                jsonResult(jsonLocal)
            }

        }


        private fun jsonResult(jsonString: String?) {
            val jsonArray = JSONArray(jsonString)
            val list = ArrayList<Word>()
            var i = 0
            while (i < jsonArray.length()) {
                val jsonObject = jsonArray.getJSONObject(i)
                list.add(
                    Word(

                        jsonObject.getString("word"),
                        jsonObject.getString("meaning")
                    )
                )
                i++
            }

            val adapter = WordListAdapter(this@WordsActivity, list)
            recycler_view_words.adapter = adapter
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    //if the internet is not connected
    private fun isOnline(): Boolean {
        val conMgr =
            applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = conMgr.activeNetworkInfo
        if (netInfo == null || !netInfo.isConnected || !netInfo.isAvailable) {
            lottieAnimationView_notConnected.visibility = View.VISIBLE //show no wifi animation
            Toast.makeText(
                this,
                "No Internet connection! Please connect to internet",
                Toast.LENGTH_LONG
            ).show() //show a toast that say No internet
            return false
        }
        return true
    }

    //check the internet connection
    private fun internetNotConnected() {
        if (!isOnline()) {
            //if internet is not connected, then cancel the AsyncTaskHandler class
            AsyncTaskHandler().cancel(true)
        } else {
            //if internet is connected then run the AsyncTaskHandler class with the given url
            AsyncTaskHandler().execute(url)
        }
    }
}