package cn.elabosak.rblock;

import cn.elabosak.rblock.commands.RblockCmds;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

import cn.elabosak.rblock.utils.getRandomInt;

/**
 * @author ElaBosak
 * @date 2020/07/11
 */
public final class Main extends JavaPlugin implements Listener {

    public static HashMap<Player, Boolean> onRblock = new HashMap<>();
    public static HashMap<Player, Integer> start = new HashMap<>();
    public static HashMap<Player, Integer> end = new HashMap<>();

    @Override
    public void onEnable() {
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.DARK_GREEN+"§l= RandomBlockPlacement Has Been Launched =");
        Bukkit.getPluginCommand("rblock").setExecutor(new RblockCmds());
        Bukkit.getServer().getPluginManager().registerEvents(this,this);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        onRblock.put(event.getPlayer(),false);
        start.put(event.getPlayer(),0);
        end.put(event.getPlayer(),0);
    }

    @EventHandler
    public void onPlaceBlock(BlockPlaceEvent event) {
        if (onRblock.get(event.getPlayer())) {
            Integer randNum = new getRandomInt().get(start.get(event.getPlayer()), end.get(event.getPlayer()));
            event.getPlayer().getInventory().setHeldItemSlot(randNum);
        }
    }

    @Override
    public void onDisable() {
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.BLUE+"§l= RandomBlockPlacement Has Been Stopped =");
    }

}
