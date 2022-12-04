package de.hitselikez.cmd;

import de.hitselikez.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;

public class ClearItem_cmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        if (p.hasPermission("command.clearitem")) {

            for (Entity e : p.getWorld().getEntities()) {

                if (e instanceof Item) {

                    e.remove();

                }
            }

        } else {
            
            p.sendMessage(Main.noperms);
            
        }

        return false;
    }
}
