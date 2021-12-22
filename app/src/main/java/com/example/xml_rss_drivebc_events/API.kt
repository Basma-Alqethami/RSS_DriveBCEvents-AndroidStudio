package com.example.xml_rss_drivebc_events

import com.example.xml_rss_drivebc_events.model.Rss
import retrofit2.Call
import retrofit2.http.GET

interface API {

    @get:GET("district/mainland?format=rss")
    val getAllData: Call<Rss?>?

    companion object {
        const val BASE_URL = "https://www.drivebc.ca/api/events/"
    }

}