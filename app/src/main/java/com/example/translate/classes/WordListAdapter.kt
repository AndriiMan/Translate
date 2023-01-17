package com.example.translate.classes



import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.translate.R
import kotlinx.android.synthetic.main.words_list.view.*

class WordListAdapter(val context: Context, private val wordList: ArrayList<Word>) :
    RecyclerView.Adapter<WordListAdapter.WordListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordListViewHolder {

        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.words_list, parent, false)
        return WordListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WordListViewHolder, position: Int) {
        val currentItem = wordList[position]
        holder.wordTextView.text = currentItem.word
        holder.meaningTextView.text = currentItem.meaning
    }

    override fun getItemCount() = wordList.size

    class WordListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val wordTextView: TextView = itemView.word_textView
        val meaningTextView: TextView = itemView.meaning_textView
    }
}
