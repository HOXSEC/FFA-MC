package me.hoxsec.ffa;

import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.hoxsec.ffa.Events.arrowEvent;
import me.hoxsec.ffa.Events.deathEvent;
import me.hoxsec.ffa.Events.dropEvent;
import me.hoxsec.ffa.Events.foodEvent;
import me.hoxsec.ffa.Events.joinLeaveEvent;
import me.hoxsec.ffa.Events.killStreakEvent;
import me.hoxsec.ffa.Events.pickupEvent;
import me.hoxsec.ffa.Events.respawnEvent;
import me.hoxsec.ffa.Events.weatherEvent;
import me.hoxsec.ffa.Stats.statsCommand;
import me.hoxsec.ffa.Stats.statsData;
import me.hoxsec.ffa.Stats.statsReset;

public class Main extends JavaPlugin {

	public static Main instance;
	Logger log = Logger.getLogger("Minecraft");
	
	public String prefix = "§3FFA §8> ";
	
	
	public void registerListeners() {
		PluginManager pm = getServer().getPluginManager();
		
		pm.registerEvents(new joinLeaveEvent(), this);
		pm.registerEvents(new respawnEvent(), this);
		pm.registerEvents(new deathEvent(), this);
		pm.registerEvents(new pickupEvent(), this);
		pm.registerEvents(new foodEvent(), this);
		pm.registerEvents(new arrowEvent(), this);
		pm.registerEvents(new weatherEvent(), this);
		pm.registerEvents(new dropEvent(), this);
		pm.registerEvents(new statsData(), this);
		pm.registerEvents(new killStreakEvent(), this);
		
		
		getCommand("stats").setExecutor(new statsCommand());
		getCommand("reset").setExecutor(new statsReset());
	}
	
	public static Main getInstance() {
		return instance;
	}
	
	@Override
	public void onEnable() {
		PluginDescriptionFile pdf = getDescription();
		this.log.info("[" + pdf.getName() + "] Has been enabled!");
		
		instance = this;
		registerListeners();
		saveConfig();
	}
	
	public void onDisable() {
		PluginDescriptionFile pdf = getDescription();
		this.log.info("[" + pdf.getName() + "] Has been disabled!");
		instance = null;
	}
	
	public void loadConfig() {
		FileConfiguration cfg = getConfig();
		cfg.options().copyDefaults(true);
		cfg.options().header(prefix + "§ePlayer stats have been registered successfully!");
		
		saveConfig();
	}
}
