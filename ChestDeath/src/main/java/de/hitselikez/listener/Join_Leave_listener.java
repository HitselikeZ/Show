package de.hitselikez.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.sql.*;

public class Join_Leave_listener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        Player p = e.getPlayer();

        e.setJoinMessage("Der Spieler §b" + p.getName() + " §7hat das Spiel §abetreten §7!");

        String url = "jdbc:mysql://localhost:3306/minecraft";
        String username = "mc";
        String password = "mcisbest555";

        Bukkit.getServer().getConsoleSender().sendMessage("§a§fDatabase connected !");

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        String sql;
        Statement stmt = null;
        int id = 0;

        sql = "SELECT `Id` FROM `Players` WHERE `Name` = '" +p.getName() + "'";
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                id = rs.getInt("Id");
            }

        } catch (SQLException ex) {
        }

        if (id == 0) {

            try {
                sql = "INSERT INTO `Players`(`Name`, `Uuid`, `Money`) VALUES ('" + p.getName() + "','" + p.getUniqueId() + "','5000')";
                stmt = connection.createStatement();
                int i = stmt.executeUpdate(sql);

            } catch (Exception ex) {

            }

        }


    }


    @EventHandler
    public void onLeave(PlayerQuitEvent e) {

        Player p = e.getPlayer();

        e.setQuitMessage("Der Spieler §b" + p.getName() + " §7hat das Spiel §4verlassen §7!");

    }

}
