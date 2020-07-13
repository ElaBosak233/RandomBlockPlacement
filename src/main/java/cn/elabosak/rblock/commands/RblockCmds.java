package cn.elabosak.rblock.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import cn.elabosak.rblock.Main;

/**
 * @author ElaBosak
 */
public class RblockCmds implements TabExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String lable, String[] args) {
        if (args.length == 0) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (p.hasPermission("rblock.general")) {
                    p.sendMessage(ChatColor.RED+"§lPlease Enter Two Integer From 1 To 9 As The Starting And Ending number");
                    return true;
                } else {
                    p.sendMessage(ChatColor.RED+"§lYou Don't Have The Permission");
                    return true;
                }
            } else {
                sender.sendMessage(ChatColor.RED+"§lYou Must Do It As A Player");
                return true;
            }
        }
        if (args.length == 1 && !Objects.equals(args[0], "off") && !Objects.equals(args[0], "help")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (p.hasPermission("rblock.general")) {
                    p.sendMessage(ChatColor.RED+"§lPlease Enter Two Integer From 1 To 9 As The Starting And Ending number");
                    return true;
                } else {
                    p.sendMessage(ChatColor.RED+"§lYou Don't Have The Permission");
                    return true;
                }
            } else {
                sender.sendMessage(ChatColor.RED+"§lYou Must Do It As A Player");
                return true;
            }
        }
        if (args[0].equalsIgnoreCase("off")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (p.hasPermission("rblock.general")) {
                    if (Main.onRblock.get(p)) {
                        Main.onRblock.put(p, false);
                        p.sendMessage(ChatColor.GREEN+"§lRandomBlockPlacement Off");
                        return true;
                    } else {
                        p.sendMessage(ChatColor.RED+"§lYou Don't Need To Use This Command");
                        return true;
                    }
                } else {
                    p.sendMessage(ChatColor.RED+"§lYou Don't Have The Permission");
                    return true;
                }
            } else {
                sender.sendMessage(ChatColor.RED+"§lYou Must Do It As A Player");
                return true;
            }
        }
        if (args[0].equalsIgnoreCase("help")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (p.hasPermission("rblock.general")) {
                    p.sendMessage(ChatColor.DARK_GREEN+"§l====== RandomBlockPlacement ======"+"\n"+ChatColor.GOLD+"/rblock <Start> <End> -- Enable random block placement mode"+"\n"+"/rblock off -- Turn off random block placement mode"+"\n"+"/rblock help -- Show help manual"+"\n"+ChatColor.DARK_GREEN+"§l==================================");
                } else {
                    p.sendMessage(ChatColor.RED+"§lYou Don't Have The Permission");
                    return true;
                }
            } else {
                sender.sendMessage(ChatColor.RED+"§lYou Must Do It As A Player");
                return true;
            }
        }
        if (args.length == 2) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (p.hasPermission("rblock.general")) {
                    int a = 0;
                    int b = 0;
                    try {
                        a = Integer.parseInt(args[0]);
                        b = Integer.parseInt(args[1]);
                    } catch (NumberFormatException e) {
                        e.getMessage();
                    }
                    if (a >= 1 && a < b && b <= 9) {
                        Integer start = a - 1;
                        Integer end = b - 1;
                        Main.start.put(p, start);
                        Main.end.put(p, end);
                        Main.onRblock.put(p, true);
                        p.sendMessage(ChatColor.GREEN+"§lRandomBlockPlacement On");
                        return true;
                    } else {
                        p.sendMessage(ChatColor.RED+"§lThe Input Content Is Not A Valid Number, Please Choose Between 1~9");
                        return true;
                    }
                } else {
                    p.sendMessage(ChatColor.RED+"§lYou Don't Have The Permission");
                    return true;
                }
            }

        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            List<String> subCommands = new ArrayList<>();
            subCommands.add("Start End");
            subCommands.add("off");
            return subCommands;
        }
        return null;
    }

}
