package de.dodori.splatoonPlugin;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	String pluginName = "splatoonPlugin";
	String pluginCoder = "dodori";
	double version = 1.0;

	public void onEnable() {
		getLogger().info(this.pluginName + " v. " + this.version + " initialized.");
		getLogger().info(this.pluginName + "v. " + this.version + " made by " + this.pluginCoder);

		getServer().getPluginManager().registerEvents(this, this);
		getServer().getPluginManager().registerEvents(new DyeBlock(), this);
		getServer().getPluginManager().registerEvents(new InkShooter(), this);
		getServer().getPluginManager().registerEvents(new BulletBehaviour(), this);
		getServer().getPluginManager().registerEvents(new InkGrenade(), this);
		getServer().getPluginManager().registerEvents(new InkCheck(), this);
		getServer().getPluginManager().registerEvents(new InkShotgun(), this);
		getServer().getPluginManager().registerEvents(new BulletPVPBehaviour(), this);
	}

	public void onDisable() {
		getLogger().info(this.pluginName + " v. " + this.version + " disabled.");
	}
}