package de.dodori.splatoonPlugin;

import java.util.Random;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.util.BlockIterator;
import org.bukkit.util.Vector;

public class BulletBehaviour implements Listener {
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onProjectileHit(ProjectileHitEvent event) {
		Entity ent = event.getEntity();
		BlockIterator iterator = new BlockIterator(event.getEntity().getWorld(), event.getEntity().getLocation().toVector(), event.getEntity().getVelocity().normalize(), 0.0D, 4);
		Block hitBlock = null;

		if (ent.hasMetadata("inkShooter")) {
			while (iterator.hasNext()) {
				hitBlock = iterator.next();

				if (hitBlock.getTypeId() != 0) {
					break;
				}
			}
			if (hitBlock.getType() == Material.CONCRETE_POWDER) {
				if (ent.hasMetadata("ORANGE")) {
					hitBlock.setData(DyeColor.ORANGE.getWoolData());
				}
				if (ent.hasMetadata("BLUE")) {
					hitBlock.setData(DyeColor.BLUE.getWoolData());
				}
				if (ent.hasMetadata("PURPLE")) {
					hitBlock.setData(DyeColor.PURPLE.getWoolData());
				}
				if (ent.hasMetadata("LIME")) {
					hitBlock.setData(DyeColor.LIME.getWoolData());
				}
				if (ent.hasMetadata("YELLOW")) {
					hitBlock.setData(DyeColor.YELLOW.getWoolData());
				}
				if (ent.hasMetadata("LIGHT_BLUE")) {
					hitBlock.setData(DyeColor.LIGHT_BLUE.getWoolData());
				}
				if (ent.hasMetadata("MAGENTA")) {
					hitBlock.setData(DyeColor.MAGENTA.getWoolData());
				}
				if (ent.hasMetadata("CYAN")) {
					hitBlock.setData(DyeColor.CYAN.getWoolData());
				}
				if (ent.hasMetadata("RED")) {
					hitBlock.setData(DyeColor.RED.getWoolData());
				}
				if (ent.hasMetadata("BLACK")) {
					hitBlock.setData(DyeColor.BLACK.getWoolData());
				}
				if (ent.hasMetadata("WHITE")) {
					hitBlock.setData(DyeColor.WHITE.getWoolData());
				}
			}
		}
		if (ent.hasMetadata("inkGrenade")) {
			while (iterator.hasNext()) {
				hitBlock = iterator.next();

				if (hitBlock.getTypeId() != 0) {
					break;
				}
			}
			int hitBlockX = hitBlock.getX();
			int hitBlockY = hitBlock.getY();
			int hitBlockZ = hitBlock.getZ();

			int r = 2;
			Random rn = new Random();
			int max = 4;
			int min = 1;

			for (int x = r * -1; x <= r; x++) {
				for (int y = r * -1; y <= r; y++) {
					for (int z = r * -1; z <= r; z++) {
						int random = rn.nextInt(max - min + 1) + min;
						if (ent.hasMetadata("ORANGE")) {
							Block b = hitBlock.getWorld().getBlockAt(hitBlockX + x, hitBlockY + y, hitBlockZ + z);
							if (b.getType() == Material.CONCRETE_POWDER) {
								if (((random == 1 ? 1 : 0) | (random == 2 ? 1 : 0) | (random == 3 ? 1 : 0)) != 0) {
									b.setData(DyeColor.ORANGE.getWoolData());
								}
								hitBlock.setData(DyeColor.ORANGE.getWoolData());
							}
						}
						if (ent.hasMetadata("BLUE")) {
							Block b = hitBlock.getWorld().getBlockAt(hitBlockX + x, hitBlockY + y, hitBlockZ + z);
							if (b.getType() == Material.CONCRETE_POWDER) {
								if (((random == 1 ? 1 : 0) | (random == 2 ? 1 : 0) | (random == 3 ? 1 : 0)) != 0) {
									b.setData(DyeColor.BLUE.getWoolData());
								}
								hitBlock.setData(DyeColor.BLUE.getWoolData());
							}
						}
						if (ent.hasMetadata("PURPLE")) {
							Block b = hitBlock.getWorld().getBlockAt(hitBlockX + x, hitBlockY + y, hitBlockZ + z);
							if (b.getType() == Material.CONCRETE_POWDER) {
								if (((random == 1 ? 1 : 0) | (random == 2 ? 1 : 0) | (random == 3 ? 1 : 0)) != 0) {
									b.setData(DyeColor.PURPLE.getWoolData());
								}
								hitBlock.setData(DyeColor.PURPLE.getWoolData());
							}
						}
						if (ent.hasMetadata("LIME")) {
							Block b = hitBlock.getWorld().getBlockAt(hitBlockX + x, hitBlockY + y, hitBlockZ + z);
							if (b.getType() == Material.CONCRETE_POWDER) {
								if (((random == 1 ? 1 : 0) | (random == 2 ? 1 : 0) | (random == 3 ? 1 : 0)) != 0) {
									b.setData(DyeColor.LIME.getWoolData());
								}
								hitBlock.setData(DyeColor.LIME.getWoolData());
							}
						}
						if (ent.hasMetadata("YELLOW")) {
							Block b = hitBlock.getWorld().getBlockAt(hitBlockX + x, hitBlockY + y, hitBlockZ + z);
							if (b.getType() == Material.CONCRETE_POWDER) {
								if (((random == 1 ? 1 : 0) | (random == 2 ? 1 : 0) | (random == 3 ? 1 : 0)) != 0) {
									b.setData(DyeColor.YELLOW.getWoolData());
								}
								hitBlock.setData(DyeColor.YELLOW.getWoolData());
							}
						}
						if (ent.hasMetadata("LIGHT_BLUE")) {
							Block b = hitBlock.getWorld().getBlockAt(hitBlockX + x, hitBlockY + y, hitBlockZ + z);
							if (b.getType() == Material.CONCRETE_POWDER) {
								if (((random == 1 ? 1 : 0) | (random == 2 ? 1 : 0) | (random == 3 ? 1 : 0)) != 0) {
									b.setData(DyeColor.LIGHT_BLUE.getWoolData());
								}
								hitBlock.setData(DyeColor.LIGHT_BLUE.getWoolData());
							}
						}
						if (ent.hasMetadata("MAGENTA")) {
							Block b = hitBlock.getWorld().getBlockAt(hitBlockX + x, hitBlockY + y, hitBlockZ + z);
							if (b.getType() == Material.CONCRETE_POWDER) {
								if (((random == 1 ? 1 : 0) | (random == 2 ? 1 : 0) | (random == 3 ? 1 : 0)) != 0) {
									b.setData(DyeColor.MAGENTA.getWoolData());
								}
								hitBlock.setData(DyeColor.MAGENTA.getWoolData());
							}
						}
						if (ent.hasMetadata("CYAN")) {
							Block b = hitBlock.getWorld().getBlockAt(hitBlockX + x, hitBlockY + y, hitBlockZ + z);
							if (b.getType() == Material.CONCRETE_POWDER) {
								if (((random == 1 ? 1 : 0) | (random == 2 ? 1 : 0) | (random == 3 ? 1 : 0)) != 0) {
									b.setData(DyeColor.CYAN.getWoolData());
								}
								hitBlock.setData(DyeColor.CYAN.getWoolData());
							}
						}
						if (ent.hasMetadata("RED")) {
							Block b = hitBlock.getWorld().getBlockAt(hitBlockX + x, hitBlockY + y, hitBlockZ + z);
							if (b.getType() == Material.CONCRETE_POWDER) {
								if (((random == 1 ? 1 : 0) | (random == 2 ? 1 : 0) | (random == 3 ? 1 : 0)) != 0) {
									b.setData(DyeColor.RED.getWoolData());
								}
								hitBlock.setData(DyeColor.RED.getWoolData());
							}
						}
						if (ent.hasMetadata("BLACK")) {
							Block b = hitBlock.getWorld().getBlockAt(hitBlockX + x, hitBlockY + y, hitBlockZ + z);
							if (b.getType() == Material.CONCRETE_POWDER) {
								if (((random == 1 ? 1 : 0) | (random == 2 ? 1 : 0) | (random == 3 ? 1 : 0)) != 0) {
									b.setData(DyeColor.BLACK.getWoolData());
								}
								hitBlock.setData(DyeColor.BLACK.getWoolData());
							}
						}
						if (ent.hasMetadata("WHITE")) {
							Block b = hitBlock.getWorld().getBlockAt(hitBlockX + x, hitBlockY + y, hitBlockZ + z);
							if (b.getType() == Material.CONCRETE_POWDER) {
								if (((random == 1 ? 1 : 0) | (random == 2 ? 1 : 0) | (random == 3 ? 1 : 0)) != 0) {
									b.setData(DyeColor.WHITE.getWoolData());
								}
								hitBlock.setData(DyeColor.WHITE.getWoolData());
							}
						}
					}
				}
			}
		}

		if (ent.hasMetadata("inkShotgun")) {
			while (iterator.hasNext()) {
				hitBlock = iterator.next();

				if (hitBlock.getTypeId() != 0) {
					break;
				}
			}
			int hitBlockX = hitBlock.getX();
			int hitBlockY = hitBlock.getY();
			int hitBlockZ = hitBlock.getZ();

			int r = 1;

			for (int x = r * -1; x <= r; x++)
				for (int y = r * -1; y <= r; y++)
					for (int z = r * -1; z <= r; z++) {
						if (ent.hasMetadata("ORANGE")) {
							Block b = hitBlock.getWorld().getBlockAt(hitBlockX + x, hitBlockY + y, hitBlockZ + z);
							if (b.getType() == Material.CONCRETE_POWDER) {
								b.setData(DyeColor.ORANGE.getWoolData());
							}
						}
						if (ent.hasMetadata("BLUE")) {
							Block b = hitBlock.getWorld().getBlockAt(hitBlockX + x, hitBlockY + y, hitBlockZ + z);
							if (b.getType() == Material.CONCRETE_POWDER) {
								b.setData(DyeColor.BLUE.getWoolData());
							}
						}
						if (ent.hasMetadata("PURPLE")) {
							Block b = hitBlock.getWorld().getBlockAt(hitBlockX + x, hitBlockY + y, hitBlockZ + z);
							if (b.getType() == Material.CONCRETE_POWDER) {
								b.setData(DyeColor.PURPLE.getWoolData());
							}
						}
						if (ent.hasMetadata("LIME")) {
							Block b = hitBlock.getWorld().getBlockAt(hitBlockX + x, hitBlockY + y, hitBlockZ + z);
							if (b.getType() == Material.CONCRETE_POWDER) {
								b.setData(DyeColor.LIME.getWoolData());
							}
						}
						if (ent.hasMetadata("YELLOW")) {
							Block b = hitBlock.getWorld().getBlockAt(hitBlockX + x, hitBlockY + y, hitBlockZ + z);
							if (b.getType() == Material.CONCRETE_POWDER) {
								b.setData(DyeColor.YELLOW.getWoolData());
							}
						}
						if (ent.hasMetadata("LIGHT_BLUE")) {
							Block b = hitBlock.getWorld().getBlockAt(hitBlockX + x, hitBlockY + y, hitBlockZ + z);
							if (b.getType() == Material.CONCRETE_POWDER) {
								b.setData(DyeColor.LIGHT_BLUE.getWoolData());
							}
						}
						if (ent.hasMetadata("MAGENTA")) {
							Block b = hitBlock.getWorld().getBlockAt(hitBlockX + x, hitBlockY + y, hitBlockZ + z);
							if (b.getType() == Material.CONCRETE_POWDER) {
								b.setData(DyeColor.MAGENTA.getWoolData());
							}
						}
						if (ent.hasMetadata("CYAN")) {
							Block b = hitBlock.getWorld().getBlockAt(hitBlockX + x, hitBlockY + y, hitBlockZ + z);
							if (b.getType() == Material.CONCRETE_POWDER) {
								b.setData(DyeColor.CYAN.getWoolData());
							}
						}
						if (ent.hasMetadata("RED")) {
							Block b = hitBlock.getWorld().getBlockAt(hitBlockX + x, hitBlockY + y, hitBlockZ + z);
							if (b.getType() == Material.CONCRETE_POWDER) {
								b.setData(DyeColor.RED.getWoolData());
							}
						}
						if (ent.hasMetadata("BLACK")) {
							Block b = hitBlock.getWorld().getBlockAt(hitBlockX + x, hitBlockY + y, hitBlockZ + z);
							if (b.getType() == Material.CONCRETE_POWDER) {
								b.setData(DyeColor.BLACK.getWoolData());
							}
						}
						if (ent.hasMetadata("WHITE")) {
							Block b = hitBlock.getWorld().getBlockAt(hitBlockX + x, hitBlockY + y, hitBlockZ + z);
							if (b.getType() == Material.CONCRETE_POWDER) {
								b.setData(DyeColor.WHITE.getWoolData());
							}
						}
					}
		}
	}
}