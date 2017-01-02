package me.hoxsec.ffa.Stats;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.hoxsec.ffa.Main;
public class statsCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			sender.sendMessage("§4You must be a player to use this command!");
			
			return true;
		}
		if (args.length == 0) {			
			Player p = (Player) sender;
			int kills = Main.getInstance().getConfig().getInt("Stats." + p.getName() + ".Kills");
			int deaths = Main.getInstance().getConfig().getInt("Stats." + p.getName() + ".Kills");
			if((kills == 0) && (deaths == 0)) {
				sender.sendMessage("§8§m--- §6 Stats §8§m---");
				sender.sendMessage("§ePlayer: §f" + p.getDisplayName());
				sender.sendMessage("§eKills: §f0");
				sender.sendMessage("§eDeaths: §f0");
				sender.sendMessage("§eStreak: §f" + p.getLevel());
				sender.sendMessage("§eKDR: §f");
				sender.sendMessage("§8§m----------");
				sender.sendMessage("  ");
				return true;
			} else if(deaths == 0) {
				sender.sendMessage("§8§m--- §6 Stats §8§m---");
				sender.sendMessage("§ePlayer: §f" + p.getDisplayName());
				sender.sendMessage("§eKills: §f" + kills);
				sender.sendMessage("§eDeaths: §f0");
				sender.sendMessage("§eStreak: §f" + p.getLevel());
				sender.sendMessage("§eKDR: §f" + kills);
				sender.sendMessage("§8§m----------");
				sender.sendMessage("  ");
				return true;
			} else {
				double kdr = kills/deaths;
				String out = String.format("%.1f", Double.valueOf(kdr));
				sender.sendMessage("§8§m--- §6 Stats §8§m---");
				sender.sendMessage("§ePlayer: §f" + p.getDisplayName());
				sender.sendMessage("§eKills: §f" + kills);
				sender.sendMessage("§eDeaths: §f" + deaths);
				sender.sendMessage("§eStreak: §f" + p.getLevel());
				sender.sendMessage("§eKDR: §f0" + out);
				sender.sendMessage("§8§m----------");
				sender.sendMessage("  ");
				return true;
			}
		}
		if (args.length == 1) {			
			@SuppressWarnings("deprecation")
			Player t = Bukkit.getServer().getPlayer(args[0]);
			int kills = Main.getInstance().getConfig().getInt("Stats." + t.getName() + ".Kills");
			int deaths = Main.getInstance().getConfig().getInt("Stats." + t.getName() + ".Kills");
			if(!t.isOnline() || t.hasPlayedBefore() || t == null) {
				sender.sendMessage("§4That player is not online or has never played before!");
				return true;
			}
			if((kills == 0) && (deaths == 0)) {
				sender.sendMessage("§8§m--- §6 Stats §8§m---");
				sender.sendMessage("§ePlayer: §f" + t.getDisplayName());
				sender.sendMessage("§eKills: §f0");
				sender.sendMessage("§eDeaths: §f0");
				sender.sendMessage("§eStreak: §f" + t.getLevel());
				sender.sendMessage("§eKDR: §f0");
				sender.sendMessage("§8§m----------");
				sender.sendMessage("  ");
				return true;
			} else if(deaths == 0) {
				sender.sendMessage("§8§m--- §6 Stats §8§m---");
				sender.sendMessage("§ePlayer: §f" + t.getDisplayName());
				sender.sendMessage("§eKills: §f" + kills);
				sender.sendMessage("§eDeaths: §f0");
				sender.sendMessage("§eStreak: §f" + t.getLevel());
				sender.sendMessage("§eKDR: §f" + kills);
				sender.sendMessage("§8§m----------");
				sender.sendMessage("  ");
				return true;
			} else {
				double kdr = kills/deaths;
				String out = String.format("%.1f", Double.valueOf(kdr));
				sender.sendMessage("§8§m--- §6 Stats §8§m---");
				sender.sendMessage("§ePlayer: §f" + t.getDisplayName());
				sender.sendMessage("§eKills: §f" + kills);
				sender.sendMessage("§eDeaths: §f" + deaths);
				sender.sendMessage("§eStreak: §f" + t.getLevel());
				sender.sendMessage("§eKDR: §f" + out);
				sender.sendMessage("§8§m----------");
				sender.sendMessage("  ");
				return true;
			
			}
		
		}
		
		return false;
	}
}
