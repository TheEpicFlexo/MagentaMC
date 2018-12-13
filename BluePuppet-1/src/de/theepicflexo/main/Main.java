package de.theepicflexo.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.theepicflexo.listener.Achievement;
import de.theepicflexo.listener.BedEnter;
import de.theepicflexo.listener.Click;
import de.theepicflexo.listener.Damage;
import de.theepicflexo.listener.FoodLevelChange;
import de.theepicflexo.listener.InventoryClick;
import de.theepicflexo.listener.Join;
import de.theepicflexo.listener.Quit;
import de.theepicflexo.sql.MySQL;
import de.theepicflexo.sql.MySQLconfig;

public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		MySQLconfig file = new MySQLconfig();
		file.setStandart();
		file.readData();

		PluginManager p = Bukkit.getPluginManager();
		p.registerEvents(new Join(), this);
		p.registerEvents(new Quit(), this);
		p.registerEvents(new BedEnter(), this);
		p.registerEvents(new Achievement(), this);
		p.registerEvents(new InventoryClick(), this);
		p.registerEvents(new Click(), this);
		p.registerEvents(new FoodLevelChange(), this);
		p.registerEvents(new Damage(), this);
		MySQL.connect();
		// MySQL.update("CREATE TABLE IF NOT EXISTS coins (uuid VARCHAR, coins INT,
		// playername VARCHAR))");

		Bukkit.getConsoleSender().sendMessage("§8[LOBBY] §aPlugin wurde Aktiviert!");

	}

	@Override
	public void onDisable() {
		 MySQL.disconnect();
	}
}