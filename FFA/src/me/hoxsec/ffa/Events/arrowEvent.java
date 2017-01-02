package me.hoxsec.ffa.Events;

import org.bukkit.entity.Arrow;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class arrowEvent implements Listener {

	@EventHandler
	public void on(ProjectileHitEvent e) {
		if(e.getEntity() instanceof Arrow) {
			Arrow a = (Arrow) e.getEntity();
			a.remove();
		}
	}
}
