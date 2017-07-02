package de.dodori.splatoonPlugin;

import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.material.Dye;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class InkCheck implements Listener {

	PotionEffect inkSpeedUp = new PotionEffect(PotionEffectType.SPEED, 2147483647, 0, false, false);
	PotionEffect inkSlowDown = new PotionEffect(PotionEffectType.SLOW, 2147483647, 3, false, false);
	PotionEffect inkNoJump = new PotionEffect(PotionEffectType.JUMP, 2147483647, -5, false, false);

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent ev) {
		Player p = ev.getPlayer();

		Block block = p.getLocation().getBlock().getRelative(BlockFace.DOWN);

		if ((block.getType() == Material.CONCRETE_POWDER) && (p.getInventory().getItemInOffHand().getType() == Material.INK_SACK)) {
			DyeColor playerColor = ((Dye) p.getInventory().getItemInOffHand().getData()).getColor();
			if (block.getData() == playerColor.getWoolData()) {
				p.removePotionEffect(PotionEffectType.SLOW);
				p.removePotionEffect(PotionEffectType.JUMP);
				p.addPotionEffect(this.inkSpeedUp);
			}
			if ((block.getData() != playerColor.getWoolData()) && (block.getData() != DyeColor.WHITE.getWoolData())) {
				p.removePotionEffect(PotionEffectType.SPEED);
				p.addPotionEffect(this.inkSlowDown);
				p.addPotionEffect(this.inkNoJump);
			}
			if (block.getData() == DyeColor.WHITE.getWoolData()) {
				p.removePotionEffect(PotionEffectType.SLOW);
				p.removePotionEffect(PotionEffectType.SPEED);
				p.removePotionEffect(PotionEffectType.JUMP);
			}

		} else if ((block.getType() != Material.CONCRETE_POWDER) && (p.getInventory().getItemInOffHand().getType() == Material.INK_SACK)) {
			if (block.getType() != Material.AIR) {
				p.removePotionEffect(PotionEffectType.SLOW);
				p.removePotionEffect(PotionEffectType.SPEED);
				p.removePotionEffect(PotionEffectType.JUMP);
			}
		}
	}
}