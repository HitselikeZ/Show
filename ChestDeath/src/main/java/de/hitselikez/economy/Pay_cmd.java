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

public class Pay_cmd implements TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        String url = "jdbc:mysql://localhost:3306/minecraft";
        String username = "mc";
        String password = "mcisbest555";

        if (args.length == 2) {

            Connection connection = null;
            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            String sql;
            Statement stmt = null;
            double money_sender = 0;
            double money_getter = 0;
            double pay = Integer.parseInt(args[1]);
            Player t = Bukkit.getPlayer(args[0]);

            sql = "SELECT `Money` FROM `Players` WHERE `Name` = '" +p.getName() + "'";
            try {
                stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()) {
                    money_sender = rs.getInt("Money");
                }

            } catch (SQLException ex) {
            }

            sql = "SELECT `Money` FROM `Players` WHERE `Name` = '" +t.getName() + "'";
            try {
                stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()) {
                    money_getter = rs.getInt("Money");
                }

            } catch (SQLException ex) {
            }

            if (money_sender > pay) {

                double leftmoney = money_sender - pay;
                double newmoney = money_getter + pay;

                try {
                    sql = "UPDATE `Players` SET `Money`='"+ leftmoney +"' WHERE `Name` = '" + p.getName()+ "'";
                    stmt = connection.createStatement();
                    int i = stmt.executeUpdate(sql);

                } catch (Exception ex) {

                }

                try {
                    sql = "UPDATE `Players` SET `Money`='"+ newmoney +"' WHERE `Name` = '" + t.getName()+ "'";
                    stmt = connection.createStatement();
                    int i = stmt.executeUpdate(sql);

                } catch (Exception ex) {

                }

                p.sendMessage(Main.eco + "Du hast §a" + t.getName() + "§6 " + pay + "$ §7gesendet!");
                t.sendMessage(Main.eco + "Der Spieler §a" + p.getName() + " hat dir §6" + pay + "$ §7gesendet!");

            } else {

                p.sendMessage(Main.eco + "Dazu hast du nicht genug Geld auf deinem Konto !");

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
