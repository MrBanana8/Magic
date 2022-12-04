package me.notbanana8.magic;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Magic extends JavaPlugin{

    @Override
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(new MagicHat(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new MagicBook(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new SpellSelector(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new BlinkSpell(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){
            return true;
        }
        if(label.equalsIgnoreCase("magic")){
            Player player = (Player) sender;
            player.sendMessage("Usage: magic give <item>");
            if(args.length == 2){
                if(args[0].equalsIgnoreCase("give")){
                    if(args[1].equalsIgnoreCase("hat")){
                        if(player.hasPermission("magic.givehat")){
                            player.getInventory().addItem(ItemManager.magichat());
                        }else {
                            player.sendMessage(ChatColor.RED + "You don't have permission to do that!");
                        }
                    }
                    if(args[1].equalsIgnoreCase("book")){
                        if(player.hasPermission("magic.givebook")){
                            player.getInventory().addItem(ItemManager.magicbook());

                        }else {
                            player.sendMessage(ChatColor.RED + "You don't have permission to do that!");
                        }
                    }
                    if(args[1].equalsIgnoreCase("soulfire")){
                        if(player.hasPermission("magic.givesoulfire")){
                            player.getInventory().addItem(ItemManager.soulfire());

                        }else {
                            player.sendMessage(ChatColor.RED + "You don't have permission to do that!");
                        }
                    }
                }
            }
        }
        return false;
    }
}
