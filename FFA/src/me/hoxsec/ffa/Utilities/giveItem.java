package me.hoxsec.ffa.Utilities;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class giveItem {

	
	public static void giveItems(Player p) {
		
		ItemStack ih = new ItemStack(Material.IRON_HELMET);
		ItemMeta ihmeta = ih.getItemMeta();
		ihmeta.setDisplayName("§8< §6Helmet §8>");
		ih.setItemMeta(ihmeta);
		
		ItemStack ic = new ItemStack(Material.IRON_CHESTPLATE);
		ItemMeta icmeta = ic.getItemMeta();
		icmeta.setDisplayName("§8< §6Chestplate §8>");
		ic.setItemMeta(icmeta);
		
		ItemStack il = new ItemStack(Material.IRON_LEGGINGS);
		ItemMeta ilmeta = il.getItemMeta();
		ilmeta.setDisplayName("§8< §6Leggins §8>");
		il.setItemMeta(ilmeta);
		
		ItemStack ib = new ItemStack(Material.IRON_BOOTS);
		ItemMeta ibmeta = ib.getItemMeta();
		ibmeta.setDisplayName("§8< §6Boots §8>");
		ib.setItemMeta(ibmeta);
		
		ItemStack is = new ItemStack(Material.IRON_SWORD);
		ItemMeta ismeta = is.getItemMeta();
		ismeta.setDisplayName("§8< §6Sword §8>");
		is.setItemMeta(ismeta);
		
		ItemStack fr = new ItemStack(Material.FISHING_ROD);
		ItemMeta frmeta = fr.getItemMeta();
		frmeta.setDisplayName("§8< §6Rod §8>");
		fr.setItemMeta(frmeta);
		
		ItemStack bow = new ItemStack(Material.BOW);
		ItemMeta bowmeta = bow.getItemMeta();
		bowmeta.setDisplayName("§8< §6Bow §8>");
		bow.setItemMeta(bowmeta);
		
		ItemStack arr = new ItemStack(Material.ARROW, 16);
		ItemMeta arrmeta = arr.getItemMeta();
		arrmeta.setDisplayName("§8< §6Arrows §8>");
		arr.setItemMeta(arrmeta);
		
		p.getInventory().setHelmet(ih);
		p.getInventory().setChestplate(ic);
		p.getInventory().setLeggings(il);
		p.getInventory().setBoots(ib);
		
		p.getInventory().setItem(0, is);
		p.getInventory().setItem(1, fr);
		p.getInventory().setItem(2, bow);
		p.getInventory().setItem(9, arr);
		
	}
}
