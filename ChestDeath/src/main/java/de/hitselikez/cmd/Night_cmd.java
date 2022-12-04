package de.hitselikez.cmd;

import de.hitselikez.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Night_cmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p =  (Player) sender;

        if (p.hasPermission("command.night")) {

            p.getWorld().setTime(13000);
            p.sendMessage(Main.sys + "Es ist nun §3Nachts §7!");

        
        } else {

            p.sendMessage(Main.sys + "Dazu hast du keine Berechtigung!");

        }
        return false;
    }
}
