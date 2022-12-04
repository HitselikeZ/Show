package de.hitselikez.cmd;

import de.hitselikez.main.Main;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Timeban_cmd implements TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        if (sender instanceof Player) {

            if (p.hasPermission("command.timeban")) {

                if (args.length == 5) {

                    Player t = Bukkit.getPlayer(args[0]);

                    String reason = args[1];
                    int years = Integer.parseInt(args[4] + 123);
                    int months = Integer.parseInt(args[3]) -1;
                    int days = Integer.parseInt(args[2]) -7;

                    Date date = new Date(years,months,days);

                    Bukkit.getServer().getBanList(BanList.Type.NAME).addBan(t.getName(), reason, date, null);

                    p.sendMessage(Main.sys + "Du hast §c" + t.getName() + "§c für §a" + date + "§7 gebannt !");
                    p.sendMessage(LocalDateTime.now().getHour() + "" + LocalDateTime.now().getMinute() +"" + LocalDateTime.now().getSecond() + "");

                    if (t.isOnline()) t.kickPlayer(Main.sys + "Du wurdest von §6" + p.getName() + " §7gebannt !");



                } else if (args.length == 4) {

                    Player t = Bukkit.getPlayer(args[0]);
                    String reason = args[1];
                    int years = 0 + 123;
                    int months = Integer.parseInt(args[3]) -1;
                    int days = Integer.parseInt(args[2]) -7;

                    Date date = new Date(years,months,days);

                    Bukkit.getServer().getBanList(BanList.Type.NAME).addBan(t.getName(), reason, date, null);

                    p.sendMessage(Main.sys + "Du hast §c" + t.getName() + "§c für §a" + date + "§7 gebannt !");
                    p.sendMessage(LocalDateTime.now().getHour() + "" + LocalDateTime.now().getMinute() +"" + LocalDateTime.now().getSecond() + "");

                    if (t.isOnline()) t.kickPlayer(Main.sys + "Du wurdest von §6" + p.getName() + " §7gebannt !");

                }  else if (args.length == 3) {

                    Player t = Bukkit.getPlayer(args[0]);
                    String reason = args[1];
                    int years = 0 + 123 ;
                    int months = 0 -1 ;
                    int days = Integer.parseInt(args[2]) -7;

                    Date date = new Date(years,months,days);

                    Bukkit.getServer().getBanList(BanList.Type.NAME).addBan(t.getName(), reason, date, null);

                    p.sendMessage(Main.sys + "Du hast §c" + t.getName() + "§c für §a" + date + "§7 gebannt !");
                    p.sendMessage(LocalDateTime.now().getHour() + "" + LocalDateTime.now().getMinute() +"" + LocalDateTime.now().getSecond() + "");

                    if (t.isOnline()) t.kickPlayer(Main.sys + "Du wurdest von §6" + p.getName() + " §7gebannt !");

                }else {

                    p.sendMessage(Main.sys + "Nutze /timeban §3[Player] [Reason] [Days] [Months] [Years] §7!");

                }

            } else {

                p.sendMessage(Main.noperms);

            }

        }


        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        ArrayList arguments = new ArrayList<>();

        if (args.length == 2) {

            arguments.add("Griefing");
            arguments.add("Hacking");
            arguments.add("X-Ray");
            arguments.add("Beleidigung");
            arguments.add("Sonstiges");
            return arguments;

        } else if (args.length == 3) {

            arguments.add("Days");
            return arguments;

        }else if (args.length == 4) {

            arguments.add("Months");
            return arguments;

        }else if (args.length == 5) {

            arguments.add("Years");
            return arguments;

        }

        return null;
    }
}
