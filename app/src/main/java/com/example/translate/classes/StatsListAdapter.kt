package com.example.translate.classes



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.translate.R
import com.example.translate.database.Words
import kotlinx.android.synthetic.main.stats_list.view.*

class StatsListAdapter : RecyclerView.Adapter<StatsListAdapter.MyViewHolder>() {

    private var itemList = emptyList<Words>()


    override fun onCreateViewHolder(
        parent: ViewGroup,

        viewType: Int
    ): MyViewHolder {
        val inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.stats_list, parent, false)
        return MyViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.itemView.word_stats_textView.text = currentItem.word
        holder.itemView.totalScore_stats_textView.text = currentItem.total.toString()
        holder.itemView.rightAns_stats_textView.text = currentItem.correctAns.toString()
    }


    override fun getItemCount(): Int {
        return itemList.size
    }

    fun setData(word: List<Words>) {
        this.itemList = word
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}