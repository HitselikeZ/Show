package de.hitselikez.economy;

import de.hitselikez.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.sql.*;
import java.util.List;

public class Money_cmd implements TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        String url = "jdbc:mysql://localhost:3306/minecraft";
        String username = "mc";
        String password = "mcisbest555";

        if (args.length == 0) {

            Connection connection = null;
            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            String sql;
            Statement stmt = null;
            double money = 0;

            sql = "SELECT `Money` FROM `Players` WHERE `Name` = '" +p.getName() + "'";
            try {
                stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()) {
                    money = rs.getInt("Money");
                }

            } catch (SQLException ex) {
            }

            p.sendMessage(Main.eco + "Dein Kontostand beträgt: §6" + money + "$");

        } else if (args.length == 1) {
            
            Player t = Bukkit.getPlayer(args[0]);

            Connection connection = null;
            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            String sql;
            Statement stmt = null;
            double money = 0;

            sql = "SELECT `Money` FROM `Players` WHERE `Name` = '" +t.getName() + "'";
            try {
                stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()) {
                    money = rs.getInt("Money");
                }

            } catch (SQLException ex) {
            }

            p.sendMessage(Main.eco + "Der Kontostand von §a" + t.getName() + " §7beträgt: §6" + money + "$");
            
        } else {
            
            p.sendMessage(Main.eco + "Bitte nutze /money [Player]");
            
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        return null;
    }
}
