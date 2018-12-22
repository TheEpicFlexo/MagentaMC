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
import de.theepicflexo.listener.Damage;
import de.theepicflexo.listener.Drop;
import de.theepicflexo.listener.EPInteract;
import de.theepicflexo.listener.FoodLevelChange;
import de.theepicflexo.listener.Interact;
import de.theepicflexo.listener.InventoryClick;
import de.theepicflexo.listener.Join;
import de.theepicflexo.listener.Quit;
import de.theepicflexo.sql.MySQLconfig;
import net.minecraft.server.v1_8_R3.MinecraftServer;

public class Main extends JavaPlugin {

	public static Plugin plugin;

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
		Bukkit.getPluginCommand("setwarp").setExecutor(new SetWarp());

		PluginManager p = Bukkit.getPluginManager();
		p.registerEvents(new Join(), this);
		p.registerEvents(new Quit(), this);
		p.registerEvents(new BedEnter(), this);
		p.registerEvents(new Achievement(), this);
		p.registerEvents(new InventoryClick(), this);
		p.registerEvents(new Interact(), this);
		p.registerEvents(new FoodLevelChange(), this);
		p.registerEvents(new Damage(), this);
		p.registerEvents(new Drop(), this);
		p.registerEvents(new EPInteract(), this);

		MinecraftServer.getServer().setSpawnAnimals(false);
		MinecraftServer.getServer().setSpawnNPCs(false);
		MinecraftServer.getServer().setPVP(false);
		MinecraftServer.getServer().setMotd("Lobby");

		Bukkit.getConsoleSender().sendMessage("§8[LOBBY] §aPlugin wurde Aktiviert!");

	}

	public void setHeaderAndFooter(Player p) {
		TabAPI.setHeader(p,
				" " + " \n    §aHerzlich Willkommen, §b" + p.getName() + "    \n§aMagentaMC.de §8- §aLobby\n ");
		TabAPI.setFooter(p,
				" \n§bOnline: §7" + Bukkit.getOnlinePlayers().size() + "§8/§7" + Bukkit.getMaxPlayers() + "\n ");
	}

}