package me.hoxsec.ffa.Events;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import me.hoxsec.ffa.Utilities.giveItem;

public class respawnEvent implements Listener {

	
	@EventHandler
	public void on(PlayerRespawnEvent e) {
		Player p = e.getPlayer();
		Location loc = p.getWorld().getSpawnLocation();
		p.teleport(loc);
		giveItem.giveItems(p);
	}
}
