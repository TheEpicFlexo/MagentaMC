package de.theepicflexo.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.theepicflexo.listener.Achievement;
import de.theepicflexo.listener.BedEnter;
import de.theepicflexo.listener.Join;
import de.theepicflexo.listener.Quit;
import de.theepicflexo.sql.MySQL;
import de.theepicflexo.sql.MySQLconfig;

public class Main extends JavaPlugin{
	@Override
	public void onEnable() {
		MySQLconfig file = new MySQLconfig();
		file.setStandart();
		file.readData();
		
//		MySQL.connect();
//		MySQL.update("CREATE TABLE IF NOT EXISTS lobby (UUID VARCHAR)");
		
		PluginManager p = Bukkit.getPluginManager();
		p.registerEvents(new Join(), this);
		p.registerEvents(new Quit(), this);
		p.registerEvents(new BedEnter(), this);
		p.registerEvents(new Achievement(), this);
		
		Bukkit.getConsoleSender().sendMessage(">>");
		Bukkit.getConsoleSender().sendMessage("§8[LOBBY] Plugin wurde Aktiviert!");
		Bukkit.getConsoleSender().sendMessage(">>");
	}
	
	@Override
	public void onDisable() {
		MySQL.disconnect();
	}
}