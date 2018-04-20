package com.anwarboss.tyara.utils

interface ListItem {

    val itemType: Int

    companion object {
        const val TYPE_HEADER = 0
        const val TYPE_ITEM = 1
    }
}