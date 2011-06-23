package me.jasper.basic;

import java.io.File;
import java.util.*;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.server.*;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPlaceEvent;
import com.herocraftonline.dthielke.herochat.*;
import com.herocraftonline.dthielke.herochat.channels.*;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.material.MaterialData;
import org.bukkit.plugin.*;
import org.bukkit.plugin.java.JavaPlugin;

public class BasicBlockListener extends BlockListener {
	public static Basic plugin;
	public void server = getServer();
	public BasicBlockListener(Basic instance) {
		plugin = instance;
	}
	
	public void broadcast(String msg) {
		broadcast(msg);
    }
	
	public void onBlockPlace(BlockPlaceEvent event) {
Player player = event.getPlayer();
Block block = event.getBlockPlaced();
if (block.getType() == Material.TORCH) {
	getServer().broadcastMessage("You placed a torch, couldn't you shit rainbows?");
}
		
}
}
