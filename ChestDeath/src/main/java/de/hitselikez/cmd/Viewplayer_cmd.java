package de.hitselikez.cmd;

import de.hitselikez.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class Viewplayer_cmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        if (sender instanceof Player) {

            if (p.hasPermission("command.viewplayer")) {

                if (p.getGameMode().equals(GameMode.SPECTATOR)) {

                    if (args.length == 0) {

                        p.setGameMode(GameMode.SURVIVAL);


                        for (Player allplayer : Bukkit.getOnlinePlayers()) {

                            allplayer.sendMessage("Der Spieler §b" + p.getName() + " §7hat das Spiel §abetreten §7!");
                            allplayer.showPlayer(p);

                        }

                        p.teleport(Main.backtp.get(p));
                        Main.backtp.remove(p);

                    } else {

                        p.sendMessage(Main.sys + "Nutze /viewplayer um den Modus zu verlassen !");

                    }


                } else {

                    if (args.length == 1) {

                        Player t = Bukkit.getPlayer(args[0]);

                        Main.backtp = new HashMap<>();

                        Main.backtp.put(p, p.getLocation());

                        p.setGameMode(GameMode.SPECTATOR);
                        p.teleport(t.getLocation());

                        for (Player allplayer : Bukkit.getOnlinePlayers()) {

                            allplayer.sendMessage("Der Spieler §b" + p.getName() + " §7hat das Spiel §4verlassen §7!");
                            allplayer.hidePlayer(p);

                        }

                    } else {

                        p.sendMessage(Main.sys + "Nutze /viewplayer §3[Player] §7!");

                    }

                }

            } else {

                p.sendMessage(Main.noperms);

            }

        }

        return false;
    }
}
