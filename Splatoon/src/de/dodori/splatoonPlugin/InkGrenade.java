package de.dodori.splatoonPlugin;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.SplashPotion;
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

public class InkGrenade implements Listener {
	List<Player> grenadeCooldown = new ArrayList();

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerInteractEvent(PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
			if ((e.getHand().equals(EquipmentSlot.HAND)) && (p.getInventory().getItemInMainHand().getType() == Material.WOOD_HOE)) {
				if (!this.grenadeCooldown.contains(p)) {
					Projectile projectile = p.launchProjectile(SplashPotion.class);
					p.playSound(p.getLocation(), Sound.ENTITY_SPLASH_POTION_THROW, 0.5F, 1.0F);
					p.playSound(p.getLocation(), Sound.ENTITY_PARROT_IMITATE_CREEPER, 1.0F, 1.0F);
					projectile.setMetadata("inkGrenade", new FixedMetadataValue(JavaPlugin.getPlugin(Main.class), Boolean.valueOf(true)));
					if (p.getInventory().getItemInOffHand().getType() == Material.INK_SACK) {
						DyeColor dyeInHand = ((Dye) p.getInventory().getItemInOffHand().getData()).getColor();
						projectile.setMetadata(dyeInHand.toString(), new FixedMetadataValue(JavaPlugin.getPlugin(Main.class), Boolean.valueOf(true)));
						this.grenadeCooldown.add(p);

						Bukkit.getScheduler().scheduleAsyncDelayedTask(JavaPlugin.getPlugin(Main.class),
							new Runnable() {
								public void run() {
									InkGrenade.this.grenadeCooldown.remove(p);
									p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 1.0F);
								}
							}, 200L);
					} else {
						projectile.setMetadata("BLACK", new FixedMetadataValue(JavaPlugin.getPlugin(Main.class), Boolean.valueOf(true)));
						this.grenadeCooldown.add(p);
						Bukkit.getScheduler().scheduleAsyncDelayedTask(JavaPlugin.getPlugin(Main.class),
							new Runnable() {
								public void run() {
									InkGrenade.this.grenadeCooldown.remove(p);
									p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 1.0F);
								}
							}, 200L);
					}
				} else {
					p.playSound(p.getLocation(), Sound.BLOCK_NOTE_HAT, 1.0F, 1.0F);
					p.sendMessage(ChatColor.YELLOW + "You need to wait before you can use that again!");
				}
			}
		}
	}
}