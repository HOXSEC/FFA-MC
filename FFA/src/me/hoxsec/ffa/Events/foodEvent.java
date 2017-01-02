package me.hoxsec.ffa.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class foodEvent implements Listener {

	@EventHandler
	public void on(FoodLevelChangeEvent e) {
		e.setCancelled(true);
	}
}
