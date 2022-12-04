package me.notbanana8.magic;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class MagicHat implements Listener {
    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack playerHelmet = player.getInventory().getHelmet();
        ItemStack item = player.getInventory().getItemInMainHand();
        ItemMeta itemMeta = item.getItemMeta();
        if(!itemMeta.getDisplayName().equalsIgnoreCase(ChatColor.LIGHT_PURPLE + "Magic Hat")) return;
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if(playerHelmet == null){
                item.setAmount(0);
                player.spawnParticle(Particle.SPELL_WITCH, player.getLocation().add(0, 2, 0), 20);
                player.getInventory().setHelmet(ItemManager.magichat());
            }
                player.getWorld().dropItemNaturally(player.getLocation(), playerHelmet);
                playerHelmet.setAmount(0);
                player.getInventory().getItemInMainHand().setAmount(0);
                player.spawnParticle(Particle.SPELL_WITCH, player.getLocation().add(0, 2, 0), 20);
                player.getInventory().setHelmet(ItemManager.magichat());
        }
    }







}