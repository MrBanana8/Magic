package me.notbanana8.magic;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SpellSelector implements Listener {
    public Inventory inv;

    public SpellSelector() {
        inv = Bukkit.createInventory(null, 9, ChatColor.LIGHT_PURPLE + "Spell Selector");

        initializeItems();
    }

    public void initializeItems() {
        inv.setItem(0,createGuiItem(Material.SOUL_SOIL, ChatColor.BLUE + "Soul Fire",
                ChatColor.GRAY +"SoulFire Beam.", ""));
        inv.setItem(8,createGuiItem(Material.PAPER, ChatColor.WHITE + "NONE",
                ChatColor.GRAY +"No Spell", ""));

    }

    @EventHandler
    public void clickEvent(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
        List<String> lore = meta.getLore();
        if(!event.getView().getTitle().equals(ChatColor.LIGHT_PURPLE + "Spell Selector") ||
                !event.getView().getTopInventory().equals(event.getClickedInventory())) return;
        event.setCancelled(true);

        switch (event.getCurrentItem().getType()){
            case SOUL_SOIL:
                meta.getLore().set(1,ChatColor.GRAY + "Selected Spell: " + ChatColor.LIGHT_PURPLE +"Soul Fire");
                meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Magic Book " + ChatColor.GOLD + "[SoulFire]");
                player.getInventory().getItemInMainHand().setItemMeta(meta);
                player.updateInventory();
                player.closeInventory();
                break;
            case PAPER:
                meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Magic Book ");
                player.getInventory().getItemInMainHand().setItemMeta(meta);
                player.updateInventory();
                player.closeInventory();
                break;

        }
    }

    protected ItemStack createGuiItem(final Material material, final String name, final String... lore) {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(name);

        meta.setLore(Arrays.asList(lore));

        item.setItemMeta(meta);

        return item;
    }
}
