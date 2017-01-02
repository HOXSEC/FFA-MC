package me.hoxsec.ffa.Events;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.hoxsec.ffa.Utilities.giveItem;

public class joinLeaveEvent implements Listener {

	
	@EventHandler
	public void on(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		Location loc = p.getLocation();
		p.setLevel(0);
		p.teleport(loc);
		giveItem.giveItems(p);
		e.setJoinMessage(" §f" + p.getName() + " §c>> " +"§7has joined the game.");
	}
	
	@EventHandler
	public void on(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		p.getInventory().clear();
		e.setQuitMessage(" §f" + p.getName() + " §c>> " + "§7has left the game.");
	}
	
	
	
}

