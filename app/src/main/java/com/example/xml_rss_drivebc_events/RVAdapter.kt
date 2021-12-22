package com.example.xml_rss_drivebc_events

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.xml_rss_drivebc_events.model.Data
import kotlinx.android.synthetic.main.row.view.*


class RVAdapter (private var list: ArrayList<Data>): RecyclerView.Adapter<RVAdapter.ItemViewHolder>() {
    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val data = list[position]

        holder.itemView.apply {
            title_tv.text = data.title
            if(data.severity == "Normal") {
                severity_tv.setTextColor(resources.getColor(R.color.green))
            }else{
                severity_tv.setTextColor(resources.getColor(R.color.red))
            }
            severity_tv.text = data.severity

            holder.itemView.setOnClickListener{
                val data = Data(list[position].title,
                    list[position].description,
                    list[position].category,
                    list[position].pubDate,
                    list[position].severity,
                    list[position].route)
                val intent = Intent(holder.itemView.context, DisplayData::class.java)
                intent.putExtra("displayData",data)
                holder.itemView.context.startActivity(intent)
            }
        }
    }

    override fun getItemCount() = list.size
}