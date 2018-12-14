package de.theepicflexo.main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.inventivetalent.tabapi.TabAPI;

import de.theepicflexo.listener.Achievement;
import de.theepicflexo.listener.BedEnter;
import de.theepicflexo.listener.Click;
import de.theepicflexo.listener.Damage;
import de.theepicflexo.listener.FoodLevelChange;
import de.theepicflexo.listener.InventoryClick;
import de.theepicflexo.listener.Join;
import de.theepicflexo.listener.ProjectileLaunch;
import de.theepicflexo.listener.Quit;
import de.theepicflexo.sql.MySQL;
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

		motd();
		Bukkit.getConsoleSender().sendMessage("§8[LOBBY] §aPlugin wurde Aktiviert!");

	}

	@Override
	public void onDisable() {

	}

	private void motd() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {

			@Override
			public void run() {
				MinecraftServer.getServer()
						.setMotd("§d§lMagenta§5§lMC §8× §7Dein Servernetzwerk §8× §e1.8.x §8× §bMinigames Server");
			}
		}, 20 * 3, 20 * 3);
	}

	public void setHeaderAndFooter(Player p) {
		TabAPI.setHeader(p,
				" " + " \n    §aHerzlich Willkommen, §b" + p.getName() + "    \n§aMagentaMC.de §8- §aLobby\n ");
		TabAPI.setFooter(p,
				" \n§bOnline: §7" + Bukkit.getOnlinePlayers().size() + "§8/§7" + Bukkit.getMaxPlayers() + "\n ");
	}

}