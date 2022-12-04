package de.hitselikez.cmd;

import de.hitselikez.main.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TPR_cmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        if (sender instanceof Player) {

            double x = Math.random() * 1000000;
            double y = 0;
            double z = Math.random() * 1000000;

            Location loc = new Location(p.getWorld(), x,y,z);

            while (!loc.getBlock().isEmpty()&&!loc.getBlock().equals(Material.WATER)) {

                y++;

                loc = new Location(p.getWorld(), x,y,z);

            }

            p.teleport(loc);
            p.sendMessage(Main.sys + "Du wurdest teleportiert !");

        }

        return false;
    }
}
