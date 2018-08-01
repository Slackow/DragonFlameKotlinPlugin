package com.dragonflame.main

import com.dragonflame.main.data.MyPlayerData
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin
import java.util.*
import kotlin.collections.LinkedHashMap

class Main : JavaPlugin(), Listener {


    companion object {
        private const val commandNameSpace: String = "mechtech:"
        private val dataMap : Map<UUID, MyPlayerData> = LinkedHashMap()
    }


    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        var lbl = label
        if (lbl.startsWith(commandNameSpace)) {
            lbl = lbl.substring(commandNameSpace.length)
        }
        when (lbl) {
            "fly" -> {

            }
        }
        return false
    }
}