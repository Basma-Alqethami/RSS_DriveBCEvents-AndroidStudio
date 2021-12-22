package com.example.xml_rss_drivebc_events

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.xml_rss_drivebc_events.model.Data
import kotlinx.android.synthetic.main.row.view.*

class DisplayData : AppCompatActivity() {

    lateinit var tv_title: TextView
    lateinit var tv_severity: TextView
    lateinit var tv_route: TextView
    lateinit var tv_category: TextView
    lateinit var tv_pubDate: TextView
    lateinit var tv_description: TextView
    lateinit var btCancel: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_data)

        tv_title = findViewById(R.id.tv_title)
        tv_severity = findViewById(R.id.tv_severity)
        tv_route = findViewById(R.id.tv_route)
        tv_category = findViewById(R.id.tv_category)
        tv_pubDate = findViewById(R.id.tv_pubDate)
        tv_description = findViewById(R.id.tv_description)
        btCancel = findViewById(R.id.btCancel)

        val disData = intent.getSerializableExtra("displayData") as Data


        tv_title.setText(disData.title)
        tv_severity.setText(disData.severity)
        if(disData.severity == "Normal") {
            tv_severity.setTextColor(resources.getColor(R.color.green))
        }else{
            tv_severity.setTextColor(resources.getColor(R.color.red))
        }
        tv_route.setText(disData.route)
        tv_category.setText(disData.category)
        tv_pubDate.setText(disData.pubDate)
        tv_description.setText(disData.description)

        btCancel.setOnClickListener{
            val intent = Intent(this@DisplayData, MainActivity::class.java)
            startActivity(intent)
        }
    }
}