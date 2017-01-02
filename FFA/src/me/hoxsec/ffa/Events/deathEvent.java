package me.hoxsec.ffa.Events;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class deathEvent implements Listener {

	
	@EventHandler
	public void on(PlayerDeathEvent e) {
		Player p = e.getEntity();
		Player k = p.getKiller();
		double health = k.getHealth();
		String out = String.format("%.1f", health/2);
		ItemStack arr = new ItemStack(Material.ARROW, 6);
		ItemMeta arrmeta = arr.getItemMeta();
		arrmeta.setDisplayName("§8< §6Arrows §8>");
		arr.setItemMeta(arrmeta);
		if(!(k instanceof Player)) {
			e.setDeathMessage(null);
			e.getDrops().clear();
		} else {
			e.setDeathMessage(null);
			p.sendMessage("  ");
			p.sendMessage("§cYou have been killed by §f" + k.getName() + "§c with §8(§6" + out + "hearths§8)§c!");
			p.sendMessage("  ");
			k.sendMessage("  ");
			k.sendMessage("§aYou have been killed by §f" + k.getName() + "§a with §8(§6" + out + "hearths§8)§a!");
			k.sendMessage("  ");
			p.setLevel(0);
			p.playSound(p.getLocation(), Sound.HORSE_SKELETON_DEATH, 10.0F, 10.0F);
			k.setLevel(k.getLevel() + 1);
			k.playSound(p.getLocation(), Sound.ORB_PICKUP, 10.0F, 10.0F);
			k.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 60, 4));
			k.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 60, 1));
			k.getInventory().addItem(arr);
			e.getDrops().clear();
		}
	}
}
