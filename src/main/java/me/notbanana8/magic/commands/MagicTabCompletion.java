package me.notbanana8.magic.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class MagicTabCompletion implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        if(args.length == 1){
            List<String> firstArg = new ArrayList<>();
            firstArg.add("give");

            return firstArg;
        } else if (args.length == 2){
            List<String> secondArg = new ArrayList<>();
            secondArg.add("spellbook");
            secondArg.add("hat");

            return secondArg;
        }

        return null;
    }
}
