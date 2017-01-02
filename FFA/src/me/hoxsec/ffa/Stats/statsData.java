package me.hoxsec.ffa.Stats;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import me.hoxsec.ffa.Main;

public class statsData implements Listener {

	@EventHandler
	public void on(PlayerDeathEvent e) {
		Player p = (Player) e.getEntity();
		Player k = p.getKiller();
		int kills = Main.getInstance().getConfig().getInt("Stats." + p.getName() + ".Kills");
		int deaths = Main.getInstance().getConfig().getInt("Stats." + p.getName() + ".Deaths");
		
		Main.getInstance().getConfig().set("Stats." + p.getName() + ".Deaths", deaths + 1);
		Main.getInstance().getConfig().set("Stats." + k.getName() + ".Kills", + kills + 1);
	}
	
	
	
	@EventHandler
	public void onFirstJoinEvent(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if(!(p.hasPlayedBefore())) {
			Main.getInstance().getConfig().addDefault("Stats." + p.getName() + ".Kills", Integer.valueOf(0));
			Main.getInstance().getConfig().addDefault("Stats." + p.getName() + ".Deaths", Integer.valueOf(0));
		}
	}
	
}
