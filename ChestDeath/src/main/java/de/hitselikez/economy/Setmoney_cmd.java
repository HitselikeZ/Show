package de.hitselikez.economy;

import de.hitselikez.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Setmoney_cmd implements TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        String url = "jdbc:mysql://localhost:3306/minecraft";
        String username = "mc";
        String password = "mcisbest555";

        if (args.length == 2 ) {

            Player t = Bukkit.getPlayer(args[0]);

            String sql;
            Statement stmt = null;
            double money = Integer.parseInt(args[1]);


            Connection connection = null;
            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            if (p.hasPermission("command.setmoney")) {

                try {
                    sql = "UPDATE `Players` SET `Money`='"+ money +"' WHERE `Name` = '" + t.getName()+ "'";
                    stmt = connection.createStatement();
                    int i = stmt.executeUpdate(sql);

                } catch (Exception ex) {

                }

                p.sendMessage(Main.eco + "Du hast das Konto von §a" + t.getName() + " §7auf §6" + money + "$ §7gesetzt !");
                t.sendMessage(Main.eco + "Der Spieler §a" + p.getName() + " §7hat dein Konto auf §6" + money + "$ §7gesetzt !");

            }



        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        ArrayList arguments = new ArrayList<>();

        if (args.length == 2) {

            arguments.add("Betrag");
            return arguments;

        }
        return null;
    }
}
