package de.hitselikez.cmd;

import de.hitselikez.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;

public class Nameitem_cmd implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        if (p.hasPermission("command.nameitem")) {

            String name = "";

            for (int i = 0; i != args.length; i++) {


                name = name + " " + args[i].replaceAll("&" , "§");


            }

            ItemMeta imeta = p.getItemInHand().getItemMeta();
            imeta.setDisplayName(name);
            p.getItemInHand().setItemMeta(imeta);

            p.sendMessage(Main.sys + "Dein Item wurde umbenannt !");

        } else {

            p.sendMessage(Main.noperms);

        }


        return false;
    }
}
