package me.jasper.basic;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import org.bukkit.Server;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Basic extends JavaPlugin {
	public static Basic plugin;
	public final Logger logger = Logger.getLogger("Minecraft");
	
	private final BasicBlockListener blockListener = new BasicBlockListener(this);
	//Defined block listener
	public final HashMap<Player, ArrayList<Block>> basicUsers = new HashMap();
	//Creating the hashmap
	private final HashMap<Player, Boolean> debugees = new HashMap<Player, Boolean>();
	//Create hashmap debugger
	

@Override
public void onDisable() {
	this.logger.info("Basic has been disabled by Birdie's big penis");
}

@Override
public void onEnable() {
server = getServer();
PluginManager pm = getServer().getPluginManager();
pm.registerEvent(Event.Type.BLOCK_PLACE, this.blockListener, Event.Priority.Normal, this);
PluginDescriptionFile pdfFile = this.getDescription();
this.logger.info( pdfFile.getName() + " version " + pdfFile.getVersion() + "is enabled, Daan is gay!" );
}


public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (commandLabel.equalsIgnoreCase("basic")
				|| commandLabel.equalsIgnoreCase("b"))
		{
	
	toggleVision((Player) sender);
		
	}

	
	return false;
	
}


public boolean isDebugging(final Player player) {
	if (debugees.containsKey(player))  {
		return debugees.get(player);
		
	} else {
		return false;
				
	}
}

public void setDebugging(final Player player, final boolean value) {
	debugees.put(player, value);
}
// the method enable which checks to see if the player is in the hashmap

public boolean enabled(Player player) {
	return this.basicUsers.containsKey(player);
	}

	

	
	
	public void toggleVision(Player player) {
		if (enabled(player)) {
			this.basicUsers.remove(player);
			player.sendMessage("Basic disabled");
		} else { 
			this.basicUsers.put(player, null);
			player.sendMessage("Basic enabled");
		}
	}

}
