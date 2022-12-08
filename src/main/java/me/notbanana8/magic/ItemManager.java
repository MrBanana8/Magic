package me.notbanana8.magic;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {

    //Magic Stuff
    public static ItemStack magichat(){
        ItemStack magichat = new ItemStack(Material.LEATHER_HORSE_ARMOR);
        ItemMeta meta = magichat.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Magic Hat");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setCustomModelData(2);

        lore.add("");
        lore.add("§7Does Nothing");
        lore.add("§7Right click to equip.");
        lore.add("");

        meta.setLore(lore);
        magichat.setItemMeta(meta);
        return magichat;
    }

    public static ItemStack magicbook(){
        ItemStack magicbook = new ItemStack(Material.LEATHER_HORSE_ARMOR);
        ItemMeta meta = magicbook.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Magic Book");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setCustomModelData(1);

        lore.add(ChatColor.GRAY + "");
        lore.add(ChatColor.GRAY + "Selected Spell: " + ChatColor.LIGHT_PURPLE +"NONE");
        lore.add(ChatColor.GRAY + "§7You can cast §aSpells §7by");
        lore.add(ChatColor.GRAY + "§7holding right click while");
        lore.add(ChatColor.GRAY + "you have a spell in you off hand.");
        lore.add(ChatColor.GRAY + "");

        meta.setLore(lore);
        magicbook.setItemMeta(meta);
        return magicbook;
    }

    //Spells
    public static ItemStack soulfire(){
        ItemStack soulfire = new ItemStack(Material.ARROW);
        ItemMeta meta = soulfire.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.BLUE + "Soul Fire Spell");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setCustomModelData(1);
        lore.add(ChatColor.GRAY + "");
        lore.add(ChatColor.GRAY + "Put this §dSpell§7 in your");
        lore.add(ChatColor.GRAY + "off hand to cast it.");
        lore.add(ChatColor.GRAY + "");

        meta.setLore(lore);
        soulfire.setItemMeta(meta);
        return soulfire;
    }

}
