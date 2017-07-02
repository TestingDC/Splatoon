package de.dodori.splatoonPlugin;

import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
  implements Listener
{
  String pluginName = "splatoonPlugin";
  String pluginCoder = "dodori";
  double version = 1.0D;

  public void onEnable()
  {
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

  public void onDisable()
  {
    getLogger().info(this.pluginName + " v. " + this.version + " disabled.");
  }

  @EventHandler
  public void onJoin(PlayerJoinEvent event)
  {
    Player p = event.getPlayer();
    event.setJoinMessage(null);
    p.sendMessage("Welcome back, " + p.getName() + ".");
    Bukkit.broadcastMessage(p.getName() + " has joined the server!");
  }
}