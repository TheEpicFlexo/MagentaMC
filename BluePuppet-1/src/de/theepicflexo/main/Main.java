package de.theepicflexo.main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.inventivetalent.tabapi.TabAPI;

import de.theepicflexo.commands.SetWarp;
import de.theepicflexo.commands.TeamSpeak;
import de.theepicflexo.listener.Achievement;
import de.theepicflexo.listener.BedEnter;
import de.theepicflexo.listener.Click;
import de.theepicflexo.listener.Damage;
import de.theepicflexo.listener.FoodLevelChange;
import de.theepicflexo.listener.InventoryClick;
import de.theepicflexo.listener.Join;
import de.theepicflexo.listener.ProjectileLaunch;
import de.theepicflexo.listener.Quit;
import de.theepicflexo.sql.MySQLconfig;
import net.minecraft.server.v1_8_R3.MinecraftServer;

public class Main extends JavaPlugin {

	public static Plugin plugin;
	static int z = 1;

	@Override
	public void onEnable() {
		plugin = this;
		MySQLconfig file = new MySQLconfig();
		file.setStandart();
		file.readData();

		Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin) this, new Runnable() {
			@Override
			public void run() {
				for (Player pps : Bukkit.getOnlinePlayers()) {
					setHeaderAndFooter(pps);
				}
			}
		}, 10, 10);

		Bukkit.getPluginCommand("ts").setExecutor(new TeamSpeak());
		Bukkit.getPluginCommand("teamspeak").setExecutor(new TeamSpeak());
		Bukkit.getPluginCommand("setwarp").setExecutor(new SetWarp());

		PluginManager p = Bukkit.getPluginManager();
		p.registerEvents(new Join(), this);
		p.registerEvents(new Quit(), this);
		p.registerEvents(new BedEnter(), this);
		p.registerEvents(new Achievement(), this);
		p.registerEvents(new InventoryClick(), this);
		p.registerEvents(new Click(), this);
		p.registerEvents(new FoodLevelChange(), this);
		p.registerEvents(new Damage(), this);
		p.registerEvents(new ProjectileLaunch(), this);

		MinecraftServer.getServer().setSpawnAnimals(false);
		MinecraftServer.getServer().setSpawnNPCs(false);
		MinecraftServer.getServer().setPVP(false);
		MinecraftServer.getServer().setMotd("Lobby");
	
		if (z == 1) {
			Bukkit.getConsoleSender().sendMessage("§8[LOBBY] §aPlugin wurde Aktiviert!");
			z = 2;
		} else {
			z = 1;
		}

	}

	public void setHeaderAndFooter(Player p) {
		TabAPI.setHeader(p,
				" " + " \n    §aHerzlich Willkommen, §b" + p.getName() + "    \n§aMagentaMC.de §8- §aLobby\n ");
		TabAPI.setFooter(p,
				" \n§bOnline: §7" + Bukkit.getOnlinePlayers().size() + "§8/§7" + Bukkit.getMaxPlayers() + "\n ");
	}

	public static Integer setInt() {
		z = 2;
		return z;
	}

}