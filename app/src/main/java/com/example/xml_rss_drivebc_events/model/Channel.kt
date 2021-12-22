package com.example.xml_rss_drivebc_events.model

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import java.io.Serializable

@Root(name = "channel", strict = false)
class Channel @JvmOverloads constructor(

    @field:ElementList( name = "item",inline = true)
    var item: List<Item>? = null,

) : Serializable