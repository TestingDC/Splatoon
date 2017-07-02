package de.dodori.tools;

import de.dodori.tools.Coordinate;

import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class Region {
	
	World world;
	int x, y, z;
	int width, length, height;
	
	public Region(World world, Coordinate m1, Coordinate m2) {
		this.world = world;
		this.width = m2.getX() - m1.getX();
		this.height = m2.getY() - m1.getY();
		this.length = m2.getZ() - m1.getZ();
		
		if(width < 0) {
			this.x = m1.getX() + width;
		} else {
			this.x = m1.getX();
		}
		if(height < 0) {
			this.y = m1.getY() + height;
		} else {
			this.y = m1.getY();
		}
		if(length < 0) {
			this.z = m1.getZ() + length;
		} else {
			this.z = m1.getZ();
		}
		
		this.width = Math.abs(width);
		this.height = Math.abs(height);
		this.length = Math.abs(length);
		this.z = z - 1;
	}

	public boolean isPlayerInRegion(Player player) {
		Location playerLoc = player.getLocation();
		return isPointInRegion(playerLoc.getBlockX(), playerLoc.getBlockY(), playerLoc.getBlockZ());
	}
	
	public boolean isLocationInRegion(Location loc) {
		return isPointInRegion(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
	}
	
	public boolean isPointInRegion(int pointX, int pointY, int pointZ) {
		if((x <= pointX && pointX <= (x + width)) && (y <= pointY && pointY <= (y + height)) && (z <= pointZ && pointZ <= (z + length))) {
			return true;
		}
		return false;
	}
	
	public int getAmountOfBlocks() {
		return getAmountOfBlocks(true, null, null);
	}
	
	public int getAmountOfBlocks(Material material) {
		return getAmountOfBlocks(false, material, null);
	}
	
	public int getAmountOfBlocks(Material material, DyeColor dye) {
		return getAmountOfBlocks(false, material, dye);
	}
	
	public int getAmountOfBlocksExcludeAir() {
		return getAmountOfBlocks(false, null, null);
	}

	@SuppressWarnings("deprecation")
	public int getAmountOfBlocks(boolean includeAir, Material searchMaterial, DyeColor dye) {
		int totalBlocks = 0;
		for(int a = x; a < (x + width); a++) {
			for(int b = y; b < (y + height); b++) {
				for(int c = z; c < (z + length); c++) {
					if(includeAir && (searchMaterial == null)) {
						totalBlocks++;
					} else if (!includeAir && (searchMaterial == null)) {
						totalBlocks++;
					} else if ((searchMaterial != null) && (dye == null)) {
						if(world.getBlockAt(a, b, c).getType() == searchMaterial) {
							totalBlocks++;
						}
					} else if ((searchMaterial != null) && (dye != null)) {
						Block block = world.getBlockAt(a, b, c);
						if(block.getType() == searchMaterial && block.getData() == dye.getWoolData()) {
							totalBlocks++;
						}
					}
				}
			}
		}
		return totalBlocks;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getLength() {
		return length;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getZ() {
		return z;
	}
	
	public World getWorld() {
		return world;
	}
}
