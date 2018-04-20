package com.anwarboss.tyara.models

import com.anwarboss.tyara.utils.ListItem

class DataModel : ListItem {

    var id: Int? = null
    lateinit var key: String
    lateinit var karatMessage: String
    var titleID: Int? = null
    var categoryID: Int? = null
    lateinit var titleName: String

    override val itemType: Int
        get() = ListItem.TYPE_ITEM

}