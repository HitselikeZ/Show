package de.hitselikez.cmd;

import de.hitselikez.main.Main;
import org.bukkit.WeatherType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Sun_cmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p =  (Player) sender;

        if (p.hasPermission("command.sun")) {

            p.getWorld().setClearWeatherDuration(19999);
            p.sendMessage(Main.sys + "Es ist nun §3Sonnig §7!");

        }
        return false;
    }
}
