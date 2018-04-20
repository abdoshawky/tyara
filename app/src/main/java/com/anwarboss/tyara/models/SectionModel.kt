package com.anwarboss.tyara.models

import com.anwarboss.tyara.utils.ListItem

class SectionModel : ListItem {

    var id: Int? = null
    lateinit var name: String
    var titleID: Int? = null

    override val itemType: Int
        get() = ListItem.TYPE_HEADER
}