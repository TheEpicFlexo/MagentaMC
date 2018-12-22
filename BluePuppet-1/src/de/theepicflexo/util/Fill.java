package de.theepicflexo.util;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Fill {
	// Fill Compass
	public static void fillCompass(Player p) {
		ArrayList<String> cs = new ArrayList<String>();
		cs.add("§cComing Soon");
		cs.add(" ");
		Inventory teleporter = Bukkit.createInventory(null, 9 * 5, "§8Teleporter");

		// CreateItem
		ItemStack beditem = new ItemStack(Material.BED);
		ItemMeta bedmeta = beditem.getItemMeta();
		bedmeta.setLore(cs);
		bedmeta.setDisplayName("§4§lBed§r§lWars");
		beditem.setItemMeta(bedmeta);

		ItemStack grassitem = new ItemStack(Material.GRASS);
		ItemMeta grassmeta = grassitem.getItemMeta();
		grassmeta.setLore(cs);
		grassmeta.setDisplayName("§a§lCityBuild");
		grassitem.setItemMeta(grassmeta);

		ItemStack spawnitem = new ItemStack(Material.DIAMOND);
		ItemMeta spawnmeta = spawnitem.getItemMeta();
		spawnmeta.setDisplayName("§a§lSpawn");
		spawnitem.setItemMeta(spawnmeta);

		ItemStack stickitem = new ItemStack(Material.STICK);
		ItemMeta stickmeta = stickitem.getItemMeta();
		stickmeta.setLore(null);
		stickmeta.setDisplayName("§7§lKnockIT");
		stickitem.setItemMeta(stickmeta);

		ItemStack comingsoonitem = new ItemStack(Material.BARRIER);
		ItemMeta comingsoonmeta = comingsoonitem.getItemMeta();
		comingsoonmeta.setDisplayName("§cComing Soon");
		comingsoonitem.setItemMeta(comingsoonmeta);

		// SetItem
		teleporter.setItem(22, spawnitem);
		teleporter.setItem(4, beditem);
		teleporter.setItem(10, grassitem);
		teleporter.setItem(16, stickitem);
		teleporter.setItem(28, comingsoonitem);
		teleporter.setItem(34, comingsoonitem);
		teleporter.setItem(40, comingsoonitem);

		for (int i = 0; i < teleporter.getSize(); i++) {
			if (teleporter.getItem(i) == null) {
				ItemStack glassitem = new ItemStack(Material.STAINED_GLASS_PANE);
				ItemMeta glassmeta = glassitem.getItemMeta();
				glassmeta.addEnchant(Enchantment.ARROW_FIRE, 0, false);
				glassmeta.setDisplayName("§8");
				glassitem.setItemMeta(glassmeta);
				teleporter.setItem(i, glassitem);
			}
		}

		// openInventory
		p.openInventory(teleporter);
	}

	// Fill Gadgets
	public static void fillGadgets(Player p) {
		Inventory gadgets = Bukkit.createInventory(null, 9 * 5, "§5§lGadgets");

		ItemStack EPitem = new ItemStack(Material.ENDER_PEARL);
		ItemMeta EPmeta = EPitem.getItemMeta();
		EPmeta.setDisplayName("§5§lEnderPearl");
		EPitem.setItemMeta(EPmeta);

		ItemStack barrieritem = new ItemStack(Material.BARRIER);
		ItemMeta barriermeta = barrieritem.getItemMeta();
		barriermeta.setDisplayName("§c§lGadget entfernen");
		barrieritem.setItemMeta(barriermeta);

		for (int i = 0; i < gadgets.getSize() - 9; i++) {
			if (gadgets.getItem(i) == null) {

				ItemStack glassitem = new ItemStack(Material.STAINED_GLASS_PANE);
				ItemMeta glassmeta = glassitem.getItemMeta();
				glassmeta.addEnchant(Enchantment.ARROW_FIRE, 0, false);
				glassmeta.setDisplayName("§8");
				glassitem.setItemMeta(glassmeta);
				gadgets.setItem(i, glassitem);
			}
		}
		gadgets.setItem(10, EPitem);
		gadgets.setItem(40, barrieritem);
		p.openInventory(gadgets);
	}
}
