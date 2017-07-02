package de.dodori.splatoonPlugin;

import java.util.HashSet;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandler implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] Args) {
		if(cmd.getName().equalsIgnoreCase("splatoon") && sender instanceof Player) {
			/*if(Main.permission.has(sender, "headshop.cmds")) {
				switch(Args.length) {
					case 0:
						sender.sendMessage(Lang.getCmdFromKey("enabled"));
						break;
					case 1:
						if(Args[0].equals("add")) {
							sender.sendMessage(Lang.getCmdFromKey("invalid-parameters"));
							sender.sendMessage(Lang.getCmdFromKey("command-legend"));
							sender.sendMessage(Lang.getCmdFromKey("shop-add-usage"));
						} else if(Args[0].equals("remove")) {
							HashSet<Material> mats = new HashSet<Material>();
							mats.add(Material.AIR);
							Block block = sender.getServer().getPlayer(sender.getName()).getTargetBlock(mats, 10);
							if(block.getType().equals(Material.SKULL)) {
								for(int i = 0; i < Main.shopBlocks.size(); i++) {
									if((block.getX() == Main.shopBlocks.get(i).getX()) && (block.getY() == Main.shopBlocks.get(i).getY()) && (block.getZ() == Main.shopBlocks.get(i).getZ())) {
										Shops.removeShop(Main.shopBlocks.get(i).getX(), Main.shopBlocks.get(i).getY(), Main.shopBlocks.get(i).getZ());
										Main.shopBlocks.remove(i);
										sender.sendMessage(Lang.getCmdFromKey("shop-removed"));
									}
								}
							} else {
								sender.sendMessage(Lang.getCmdFromKey("shop-remove-error-invalidblock"));
							}
						} else if(Args[0].equals("set")) {
							sender.sendMessage(Lang.getCmdFromKey("invalid-parameters"));
							sender.sendMessage(Lang.getCmdFromKey("command-legend"));
							sender.sendMessage("Usage: /headshop set selling [true/false]");
							sender.sendMessage("Usage: /headshop set item");
							sender.sendMessage("Usage: /headshop set buyPrice [price]");
							sender.sendMessage("Usage: /headshop set sellPrice [price]");
						} else if(Args[0].equals("list")) {
							sender.sendMessage(Lang.getCmdFromKey("list"));
							for(int i = 0; i < Main.shopBlocks.size(); i++) {
								ShopBlock temp = Main.shopBlocks.get(i);
								sender.sendMessage(temp.getBuyPrice() + " " + temp.getSellPrice() + " " + temp.getX() + " " + temp.getY() + " " + temp.getZ() + " " + temp.getItemStack());
							}
						} else if(Args[0].equals("reload")) {
							Lang.reloadConfig();
							Shops.reloadConfig();
							sender.sendMessage(Lang.getCmdFromKey("reloaded"));
						}
						break;
					case 2:
						if(Args[0].equals("add")) {
							float price = 0.0f;
							try {
								price = Float.parseFloat(Args[1]);
							} catch (Exception e) {
								sender.sendMessage(Lang.getCmdFromKey("shop-add-error-invalidprice"));
								break;
							}
							HashSet<Material> mats = new HashSet<Material>();
							mats.add(Material.AIR);
							Block block = sender.getServer().getPlayer(sender.getName()).getTargetBlock(mats, 10);
							if(block.getType() == Material.SKULL) {
								for(int i = 0; i < Main.shopBlocks.size(); i++) {
									if((block.getX() == Main.shopBlocks.get(i).getX()) && (block.getY() == Main.shopBlocks.get(i).getY()) && (block.getZ() == Main.shopBlocks.get(i).getZ())) {
										sender.sendMessage(Lang.getCmdFromKey("shop-add-error-alreadyshop"));
										break;
									}
								}
								if(sender.getServer().getPlayer(sender.getName()).getInventory().getItemInMainHand().getType() != Material.AIR) {
									ShopBlock temp = new ShopBlock(price, sender.getServer().getPlayer(sender.getName()).getInventory().getItemInMainHand().clone(), block.getX(), block.getY(), block.getZ());
									Main.shopBlocks.add(temp);
									Shops.updateConfig();
									sender.sendMessage(Lang.getCmdFromKey("shop-added"));
								} else {
									sender.sendMessage(Lang.getCmdFromKey("shop-add-error-noitem"));
								}
							} else {
								sender.sendMessage(Lang.getCmdFromKey("shop-add-error-invalidblock"));
							}
						} else if(Args[0].equals("set")) {
							
						}
						break;
					}
				} else {
					sender.sendMessage(Lang.getCmdFromKey("cmd-no-permission"));
				}
			} else {
				sender.sendMessage(Lang.getCmdFromKey("in-game"));
			}
			return true;*/
		}
		return false;
	}
}
