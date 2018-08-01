package com.dragonflame.main

import com.dragonflame.main.data.MyPlayerData
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
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

        if (sender !is Player) return false
        val p : Player = sender

        @Suppress("DEPRECATION")
        fun getTarget() = Bukkit.getPlayer(args[0])


        when (lbl) {
            "fly" -> {
                when (args.size) {
                    0 -> {
                        if (p.hasPermission("dragonflame.fly")) {
                            p.allowFlight = !p.allowFlight
                            p.sendMessage("${ChatColor.GOLD}Flight has been ${if (p.allowFlight) "${ChatColor.GREEN}Enabled" else "${ChatColor.RED}Disabled"}!")
                        }
                    }
                    1 -> {
                        if (p.hasPermission("dragonflame.flyothers")) {
                            val target = getTarget()
                            if (target != null) {
                                target.allowFlight = !target.allowFlight
                            }
                        }
                    }
                }
                return true
            }
            "echest" -> {
                when (args.size) {
                    0 -> {
                        if (p.hasPermission("dragonflame.echest")) {
                            p.openInventory(p.enderChest)
                        }
                    }
                    1 -> {
                        if (p.hasPermission("dragonflame.echestothers")) {
                            val target = getTarget()
                            if (target != null) {
                                p.openInventory(target.enderChest)
                            }
                            else {
                                p.sendMessage("${ChatColor.RED}Invalid Player!")
                            }
                        }
                    }
                }
                return true
            }
            else -> {
                p.sendMessage("${ChatColor.RED}Invalid Command!")
            }
        }
        return false
    }
}