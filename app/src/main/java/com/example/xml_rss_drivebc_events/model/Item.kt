package com.example.xml_rss_drivebc_events.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
import java.io.Serializable

@Root(name = "item", strict = false)
class Item @JvmOverloads constructor(

    @field:Element(name = "title")
    @param:Element(name = "title")
    var title: String? = null,

    @field:Element(name = "description")
    @param:Element(name = "description")
    var description: String? = null,

    @field:Element(name = "category")
    @param:Element(name = "category")
    var category: String? = null,

    @field:Element(name = "pubDate")
    @param:Element(name = "pubDate")
    var pubDate: String? = null,

    @field:Element(name = "severity")
    @param:Element(name = "severity")
    var severity: String? = null,

    @field:Element(name = "route")
    @param:Element(name = "route")
    var route: String? = null

    ) : Serializable