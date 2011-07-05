package me.zephyr.PrivateMessage;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class PrivateMessageCMD implements CommandExecutor{
	private final PrivateMessage plugin;
	public PrivateMessageCMD(PrivateMessage plugin){
		this.plugin=plugin;
	}
	ChatColor red=ChatColor.RED,black=ChatColor.BLACK,green=ChatColor.GREEN;
	String sign=red+"["+black+"PM"+red+"]"+ChatColor.WHITE;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLayout,
			String[] args) {
		if(cmdLayout.equalsIgnoreCase("pm")
				|| cmdLayout.equalsIgnoreCase("privatemessage")){
			if(0<args.length){
				Player to=sender.getServer().getPlayer(args[0]);
				if(to==null){
					sender.sendMessage(sign+red+"Cant find player!");
					return true;
				}else{
					String message = null;
					for(int x=1;x<args.length;x++){
						message+=" ";
						message+=args[x];
					}
					message=message.replaceAll("&red", ChatColor.RED+"");
					message=message.replaceAll("&blue", ChatColor.BLUE+"");
					message=message.replaceAll("&green", ChatColor.GREEN+"");
					message=message.replaceAll("&black", ChatColor.BLACK+"");
					message=message.replaceAll("&white", ChatColor.WHITE+"");
					message=message.replaceAll("&yellow", ChatColor.YELLOW+"");
					message=message.replaceAll("&purple", ChatColor.DARK_PURPLE+"");
					message=message.replaceAll("&pink", ChatColor.LIGHT_PURPLE+"");
					message=message.replaceAll("&aqua", ChatColor.AQUA+"");
					message=message.replaceAll(null+"", "");
					if(sender instanceof Player){
						Player from=(Player) sender;
						to.sendMessage(sign+"By "+from.getDisplayName()+":"+message);
						from.sendMessage(sign+green+"Private message is successfully delivered!");
						return true;
					}
					else if(sender instanceof ConsoleCommandSender){
						to.sendMessage(sign+"By [CONSOLE]:"+message);
						sender.sendMessage(sign+green+"Private message is successfully delivered!");
						return true;
					}else{
						to.sendMessage(sign+"By [UnknownType]:"+message);
						sender.sendMessage(sign+green+"Private message is successfully delivered!");
						return true;
					}
				}
			}else{
				sender.sendMessage(sign+red+"You need to define player and the message!");
				sender.sendMessage(sign+"The commands should look like this: /pm <to> Your Message");
				return true;
			}
		}
		return false;
	}

}
