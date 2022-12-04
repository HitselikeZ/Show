package de.hitselikez.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Hilfe_cmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

            if (args.length == 1) {

                switch (args[0]) {

                    case "ChunkClaim":
                        p.sendMessage("         §2Chunk Claim Hilfe \n §3[Was ist das?] §7ChunkClaim ist ein plugin, womit man sich bis zu 50 Chunks claimen kann, um deine Base vor den anderen Spielern zu schützen. \n §3[Chunk Claimen] §7Gehe zu einem Beliebigen Chunk und gebe den Command: §6/chunk claim §7ein.\n §3[Chunk Unclaimen] §7Gehe zu einem Beliebigen Chunk und gebe den Command: §6/chunk unclaim §7ein.\n §3[Chunk Anzeigen] §7Gehe zu einem Beliebigen Chunk und gebe den Command: §6/chunk show §7ein. \n §3[Chunk Info] §7Gehe zu einem Beliebigen Chunk und gebe den Command: §6/chunk info §7ein.");
                        break;

                    case "Shop":
                        p.sendMessage("         §2Shop Hilfe \n §3[Shop öffnen] §7Gebe den Command: /shop ein.");
                        break;

                    case "Tpa":
                        p.sendMessage("         §3[TPA Senden] §7Gebe den Command: §6/tpa §3[Spieler] §7ein.");
                        break;


                }

            }


        return false;
    }
}
