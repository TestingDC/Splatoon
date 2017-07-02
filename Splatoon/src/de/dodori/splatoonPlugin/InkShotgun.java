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
import org.bukkit.material.Dye;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.java.JavaPlugin;

public class InkShotgun implements Listener {
	List<Player> inkShotgun = new ArrayList<Player>();

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerInteractEvent(PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
			if ((e.getHand().equals(EquipmentSlot.HAND)) && (p.getInventory().getItemInMainHand().getType() == Material.IRON_HOE)) {
				if (!this.inkShotgun.contains(p)) {
					Projectile projectile1 = p.launchProjectile(Snowball.class);
					p.playSound(p.getLocation(), Sound.BLOCK_SLIME_STEP, 1.0F, 1.0F);
					projectile1.setMetadata("inkShotgun", new FixedMetadataValue(JavaPlugin.getPlugin(Main.class), Boolean.valueOf(true)));
					projectile1.setVelocity(projectile1.getVelocity().multiply(0.5D));

					if (p.getInventory().getItemInOffHand().getType() == Material.INK_SACK) {
						DyeColor dyeInHand = ((Dye) p.getInventory().getItemInOffHand().getData()).getColor();
						projectile1.setMetadata(dyeInHand.toString(), new FixedMetadataValue(JavaPlugin.getPlugin(Main.class), Boolean.valueOf(true)));
						this.inkShotgun.add(p);
						Bukkit.getScheduler().scheduleAsyncDelayedTask(JavaPlugin.getPlugin(Main.class),
							new Runnable() {
								public void run() {
									InkShotgun.this.inkShotgun.remove(p);
								}
							}, 40L);
					} else {
						projectile1.setMetadata("BLACK", new FixedMetadataValue(JavaPlugin.getPlugin(Main.class), Boolean.valueOf(true)));
						this.inkShotgun.add(p);
						Bukkit.getScheduler().scheduleAsyncDelayedTask(JavaPlugin.getPlugin(Main.class),
								new Runnable() {
								public void run() {
									InkShotgun.this.inkShotgun.remove(p);
								}
							}, 40L);
					}
				} else {
					p.playSound(p.getLocation(), Sound.BLOCK_NOTE_HAT, 1.0F, 1.0F);
				}
			}
		}
	}
}