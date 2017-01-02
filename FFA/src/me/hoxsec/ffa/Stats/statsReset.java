package me.hoxsec.ffa.Stats;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.hoxsec.ffa.Main;

public class statsReset implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			sender.sendMessage("§4You must be a player to use this command!");
			
			return true;
		}
		if(!(sender.hasPermission("ffa.reset"))) {
			sender.sendMessage("§4No permission!");
			
			return true;
		}
		if(args.length == 0) {
		Player p = (Player) sender;
		Main.getInstance().getConfig().set("Stats." + p.getName() + ".Kills", Integer.valueOf(0));
		Main.getInstance().getConfig().set("Stats." + p.getName() + ".Deaths", Integer.valueOf(0));
		
		p.kickPlayer("§aYour stats have been reset!");
		return true;
		}
		if(args.length == 1) {
			@SuppressWarnings("deprecation")
			Player t = Bukkit.getServer().getPlayer(args[0]);
			Main.getInstance().getConfig().set("Stats." + t.getName() + ".Kills", Integer.valueOf(0));
			Main.getInstance().getConfig().set("Stats." + t.getName() + ".Deaths", Integer.valueOf(0));
			sender.sendMessage("§a You have reset §f" + t.getName() + "§a's statistics!");
			t.kickPlayer("§aYour stats have been reset!");
			
			return true;
		}
		return false;
	}
}
