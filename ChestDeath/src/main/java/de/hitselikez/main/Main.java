package de.hitselikez.main;

import de.hitselikez.cmd.*;
import de.hitselikez.economy.Money_cmd;
import de.hitselikez.economy.Pay_cmd;
import de.hitselikez.economy.Setmoney_cmd;
import de.hitselikez.listener.Join_Leave_listener;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class Main extends JavaPlugin {

    public static String sys = "§6[System] §7";
    public static String eco = "§9[Bank] §7";
    public static String noperms = Main.sys + "Dazu hast du keine Berechtigung !";
    public static HashMap<Player, Location> backtp = new HashMap<>();

    @Override
    public void onEnable() {

        Bukkit.getServer().getConsoleSender().sendMessage("§a--------------------------------------------");
        Bukkit.getServer().getConsoleSender().sendMessage("");
        Bukkit.getServer().getConsoleSender().sendMessage("§aDas Plugin wurde gestartet !");
        Bukkit.getServer().getConsoleSender().sendMessage("");
        Bukkit.getServer().getConsoleSender().sendMessage("§a--------------------------------------------");
        
        //Normal Commands
        getCommand("clearitem").setExecutor(new ClearItem_cmd());
        getCommand("invsee").setExecutor(new Invsee_cmd());
        getCommand("viewplayer").setExecutor(new Viewplayer_cmd());
        getCommand("timeban").setExecutor(new Timeban_cmd());
        getCommand("day").setExecutor(new Day_cmd());
        getCommand("night").setExecutor(new Night_cmd());
        getCommand("sun").setExecutor(new Sun_cmd());
        getCommand("gm").setExecutor(new Gm_cmd());
        getCommand("hilfe").setExecutor(new Hilfe_cmd());
        getCommand("tpr").setExecutor(new TPR_cmd());
        getCommand("nameitem").setExecutor(new Nameitem_cmd());

        //Shop





        //Economys
        getCommand("money").setExecutor(new Money_cmd());
        getCommand("pay").setExecutor(new Pay_cmd());
        getCommand("setmoney").setExecutor(new Setmoney_cmd());

        Bukkit.getServer().getPluginManager().registerEvents(new Join_Leave_listener(), this);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
