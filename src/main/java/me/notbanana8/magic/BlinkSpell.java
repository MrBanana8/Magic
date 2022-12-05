package me.notbanana8.magic;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class BlinkSpell implements Listener {

    @EventHandler
    public void onRightClick(PlayerInteractEvent event){
        Player player = event.getPlayer();
        Location location = player.getLocation();
        ItemStack hand = player.getInventory().getItemInMainHand();
        float playeryaw = player.getEyeLocation().getYaw();
        float playerpitch = player.getEyeLocation().getPitch();
        Location blockTarget = player.getTargetBlock(null, 8).getLocation();
        Location blockTargetHighest = player.getWorld().getHighestBlockAt(blockTarget.getBlockX(), blockTarget.getBlockZ()).getLocation();
        if(!event.getAction().equals((Action.LEFT_CLICK_AIR))) return;
        if(!hand.getItemMeta().getDisplayName().contains(ChatColor.GOLD + "[Blink]")) return;
        location.add(0,1,0);
        blockTarget.setYaw(playeryaw);
        blockTarget.setPitch(playerpitch);
        player.teleport(blockTarget);
        player.playSound(location, Sound.ENTITY_ENDERMAN_TELEPORT,5,5);

    }

}
