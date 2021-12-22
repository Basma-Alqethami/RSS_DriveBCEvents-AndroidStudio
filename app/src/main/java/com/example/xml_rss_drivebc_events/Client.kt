package com.example.xml_rss_drivebc_events

import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

class Client {

    private var retrofit: Retrofit? = null

    fun getClient(): Retrofit? {
        retrofit = Retrofit.Builder()
            .baseUrl("https://dojo-recipes.herokuapp.com/")
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
        return retrofit
    }
}