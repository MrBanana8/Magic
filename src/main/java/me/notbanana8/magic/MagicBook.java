package me.notbanana8.magic;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;


public class MagicBook implements Listener {


    @EventHandler
    public void onSoulFire(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack hand = player.getInventory().getItemInMainHand();
        if(event.getAction().equals((Action.LEFT_CLICK_AIR))|| event.getAction().equals(Action.LEFT_CLICK_BLOCK)){
            if (hand.getItemMeta().getDisplayName().contains(ChatColor.GOLD + "[Fire]")) {
                FireSpell.soulFire(player);
            }
        }
        if (!hand.getItemMeta().getDisplayName().contains(ChatColor.LIGHT_PURPLE + "Magic Book")) return;
        if(!player.isSneaking()) return;
        if(!event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;
        player.openInventory(new SpellSelector ().inv);


    }
}