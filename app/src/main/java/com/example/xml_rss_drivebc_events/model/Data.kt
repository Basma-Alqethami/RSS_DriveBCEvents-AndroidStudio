package com.example.xml_rss_drivebc_events.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
import java.io.Serializable

data class Data(
    val title: String,
    val description: String,
    val category: String,
    val pubDate: String,
    val severity: String,
    val route: String
    ): Serializable