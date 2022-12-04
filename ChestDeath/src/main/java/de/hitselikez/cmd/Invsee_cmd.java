package de.hitselikez.cmd;

import de.hitselikez.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.util.io.BukkitObjectInputStream;

public class Invsee_cmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

            Player p = (Player) sender;

            if (sender instanceof Player) {

                if (p.hasPermission("command.invsee")) {

                    if (args.length == 1) {

                        Player t = Bukkit.getPlayer(args[0]);
                        Inventory target_inv = t.getInventory();

                        p.openInventory(target_inv);
                        p.sendMessage(Main.sys + "Du hast das Inventar von §b" + t.getName() + " §7geöffnet !");
                        p.playSound(p.getLocation(), Sound.BLOCK_CHEST_OPEN, 999, 1);

                        for (int i = 0; i != 25; i++) {

                            p.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 999);

                        }


                    } else {

                        p.sendMessage(Main.sys + "Nutze /invsee §3[Player]§7 !");

                    }

                } else {

                    p.sendMessage(Main.noperms);

                }

            }

        return false;
    }
}
