package de.hitselikez.cmd;

import de.hitselikez.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Day_cmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p =  (Player) sender;

        if (p.hasPermission("command.day")) {

            p.getWorld().setTime(6000);
            p.sendMessage(Main.sys + "Es ist nun §3Mittags §7!");

        } else {

            p.sendMessage(Main.sys + "Dazu hast du keine Berechtigung!");

        }
        return false;
    }
}
