package me.notbanana8.magic;
import me.notbanana8.magic.commands.MagicCommand;
import me.notbanana8.magic.commands.MagicTabCompletion;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Magic extends JavaPlugin{

    @Override
    public void onEnable() {
        getCommand("magic").setExecutor(new MagicCommand());
        getCommand("magic").setTabCompleter(new MagicTabCompletion());
        Bukkit.getServer().getPluginManager().registerEvents(new MagicHat(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new MagicBook(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new SpellSelector(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new BlinkSpell(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
