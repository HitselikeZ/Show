package de.hitselikez.cmd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.GameMode;
import de.hitselikez.main.Main;

import java.util.ArrayList;
import java.util.List;

public class Gm_cmd implements TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        if (args.length == 1) { // /gm 0

            switch (args[0]) {

                case "0":
                    if (p.hasPermission("command.gm.0")) {
                        p.setGameMode(GameMode.SURVIVAL);
                        p.sendMessage(Main.sys + "Du bist nun im §3Survival §7! ");
                    } else {

                        p.sendMessage(Main.noperms);

                    }
                    break;

                case "1":
                    if (p.hasPermission("command.gm.1")) {
                        p.setGameMode(GameMode.CREATIVE);
                        p.sendMessage(Main.sys + "Du bist nun im §3Kreativ §7! ");
                    }else {

                        p.sendMessage(Main.noperms);

                    }
                    break;
                case "2":
                    if (p.hasPermission("command.gm.2")) {
                        p.setGameMode(GameMode.ADVENTURE);
                        p.sendMessage(Main.sys + "Du bist nun im §3Adventure §7! ");
                    }else {

                        p.sendMessage(Main.noperms);

                    }
                    break;

                case "3":
                    if (p.hasPermission("command.gm.3")) {
                        p.setGameMode(GameMode.SPECTATOR);
                        p.sendMessage(Main.sys + "Du bist nun im §3Spectator §7! ");
                    }else {

                        p.sendMessage(Main.noperms);

                    }
                    break;
                default:
                        p.sendMessage(Main.sys + "Bitte benutze §30,1,2 §7oder §33 §7!");
                    break;

            }

        } else if (args.length == 2) { // /gm 0 [Spieler]

            Player t = Bukkit.getPlayer(args[1]);

            switch (args[0]) {

                case "0":
                    if (p.hasPermission("command.gm.0.other")) {
                        p.sendMessage(Main.sys + "Du hast §9" + t.getName() + " §7in den §3Survival §7gesetzt !");
                        t.setGameMode(GameMode.SURVIVAL);
                        t.sendMessage(Main.sys + "Du bist nun im §3Survival §7! ");
                    } else {

                        p.sendMessage(Main.noperms);

                    }
                    break;

                case "1":
                    if (p.hasPermission("command.gm.1.other")) {
                        t.setGameMode(GameMode.CREATIVE);
                        t.sendMessage(Main.sys + "Du bist nun im §3Kreativ §7! ");
                        p.sendMessage(Main.sys + "Du hast §9" + t.getName() + " §7in den §3Kreativ §7gesetzt !");
                    }else {

                        p.sendMessage(Main.noperms);

                    }
                    break;
                case "2":
                    if (p.hasPermission("command.gm.2.other")) {
                        t.setGameMode(GameMode.ADVENTURE);
                        t.sendMessage(Main.sys + "Du bist nun im §3Adventure §7! ");
                        p.sendMessage(Main.sys + "Du hast §9" + t.getName() + " §7in den §3Kreativ §7gesetzt !");
                    }else {

                        p.sendMessage(Main.noperms);

                    }
                    break;

                case "3":
                    if (p.hasPermission("command.gm.3.other")) {
                        t.setGameMode(GameMode.SPECTATOR);
                        t.sendMessage(Main.sys + "Du bist nun im §3Spectator §7! ");
                        p.sendMessage(Main.sys + "Du hast §9" + t.getName() + " §7in den §3Spectator §7gesetzt !");

                    }else {

                        p.sendMessage(Main.noperms);

                    }
                    break;
                default:
                    p.sendMessage(Main.sys + "Bitte benutze §30,1,2 §7oder §33 §c!");
                    break;

            }

        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        ArrayList arguments = new ArrayList<>();

        if (args.length == 1) {

            arguments.add("0");
            arguments.add("1");
            arguments.add("2");
            arguments.add("3");
            return arguments;

        } 

        return null;
    }
}
