package me.notbanana8.magic.commands;

import me.notbanana8.magic.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MagicCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) return true;
        Player player = (Player) sender;
        if(args.length == 2){
            if(args[0].equalsIgnoreCase("give")){

                if(args[1].equalsIgnoreCase("hat")){
                    if(player.hasPermission("magic.givehat")){
                        player.getInventory().addItem(ItemManager.magichat());
                    }else {
                        player.sendMessage(ChatColor.RED + "You don't have permission to do that!");
                    }
                }
                if(args[1].equalsIgnoreCase("spellbook")){
                    if(player.hasPermission("magic.givebook")){
                        player.getInventory().addItem(ItemManager.magicbook());
                    }else {
                        player.sendMessage(ChatColor.RED + "You don't have permission to do that!");
                    }
                }
            }
            } else
                player.sendMessage("Usage: magic give <item>");
        return false;
    }
}
