package me.hoxsec.ffa.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class weatherEvent implements Listener {

	@EventHandler
	public void on(WeatherChangeEvent e) {
		e.setCancelled(true);
	}
}
