package com.example.xml_rss_drivebc_events

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xml_rss_drivebc_events.model.Data
import com.example.xml_rss_drivebc_events.model.Rss
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory


class MainActivity : AppCompatActivity() {

    lateinit var rvAdapter: RVAdapter
    lateinit var recyclerView : RecyclerView

    var list = ArrayList<Data>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rvMain)
        rvAdapter = RVAdapter(list)
        recyclerView.adapter = rvAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        fetchData()
    }

    private fun fetchData(){
        val retrofitVar = Retrofit.Builder()
            .baseUrl("https://www.drivebc.ca/api/events/")
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
        val api = retrofitVar.create(API::class.java)
            api.getAllData!!.enqueue(object : Callback<Rss?> {
            override fun onResponse(call: Call<Rss?>?, response: Response<Rss?>?) {
                Log.d("MAIN","FEED : ${response!!.body()!!.channel?.item}")
                val items = response!!.body()!!.channel!!.item!!
                for(item in items){
                    list.add(Data(
                        item.title!!,
                        item.description!!,
                        item.category!!,
                        item.pubDate!!,
                        item.severity!!,
                        item.route!!))
                }
                rvAdapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<Rss?>?, t: Throwable?) {
                Log.e("Main", "onFailure: Unable to retrieve RSS: " + t!!.message)
                Toast.makeText(this@MainActivity, "An Error Occurred", Toast.LENGTH_SHORT).show()
            }

        })
    }
}