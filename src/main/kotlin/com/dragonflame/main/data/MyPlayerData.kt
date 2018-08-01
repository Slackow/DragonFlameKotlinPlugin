package com.dragonflame.main.data

import org.bukkit.Location
import java.util.*
import kotlin.collections.LinkedHashMap

class MyPlayerData {
    private var tprequest : UUID? = null
    private val homes : Map<String, Location> = LinkedHashMap()
    private var back : Location? = null
}