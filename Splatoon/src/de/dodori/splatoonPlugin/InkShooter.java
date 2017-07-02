package de.dodori.splatoonPlugin;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.material.Dye;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

public class InkShooter
  implements Listener
{
  List<Player> inkShooter = new ArrayList();

  @EventHandler
  public void onPlayerInteractEvent(PlayerInteractEvent e)
  {
    final Player p = e.getPlayer();
    if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))
    {
      if ((e.getHand().equals(EquipmentSlot.HAND)) && (p.getInventory().getItemInMainHand().getType() == Material.GOLD_HOE))
      {
        if (!this.inkShooter.contains(p))
        {
          Projectile projectile = p.launchProjectile(Snowball.class);
          p.playSound(p.getLocation(), Sound.BLOCK_SLIME_STEP, 0.5F, 1.0F);
          projectile.setMetadata("inkShooter", new FixedMetadataValue(JavaPlugin.getPlugin(Main.class), Boolean.valueOf(true)));
          projectile.setVelocity(projectile.getVelocity().multiply(2));
          if (p.getInventory().getItemInOffHand().getType() == Material.INK_SACK)
          {
            DyeColor dyeInHand = ((Dye)p.getInventory().getItemInOffHand().getData()).getColor();
            projectile.setMetadata(dyeInHand.toString(), new FixedMetadataValue(JavaPlugin.getPlugin(Main.class), Boolean.valueOf(true)));
            this.inkShooter.add(p);

            Bukkit.getScheduler().scheduleAsyncDelayedTask(JavaPlugin.getPlugin(Main.class), new Runnable()
            {
              public void run()
              {
                InkShooter.this.inkShooter.remove(p);
              }
            }
            , 3L);
          }
          else {
            projectile.setMetadata("BLACK", new FixedMetadataValue(JavaPlugin.getPlugin(Main.class), Boolean.valueOf(true)));
            this.inkShooter.add(p);

            Bukkit.getScheduler().scheduleAsyncDelayedTask(JavaPlugin.getPlugin(Main.class), new Runnable()
            {
              public void run()
              {
                InkShooter.this.inkShooter.remove(p);
              }
            }
            , 3L);
          }
        }
      }
    }
  }
}