package me.zephyr.PrivateMessage;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class PrivateMessage extends JavaPlugin{
	Logger log=Logger.getLogger("Minecraft");
	String name="PMPlus";
	String version="[0.1]";

	@Override
	public void onDisable() {
		log.info(name+version+" is disabled.");
	}

	@Override
	public void onEnable() {
		log.info(name+version+" is enabled.");
		getCommand("pm").setExecutor(new PrivateMessageCMD(this));
		getCommand("privatemessage").setExecutor(new PrivateMessageCMD(this));
	}
	
}
