package de.dodori.splatoonPlugin;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.material.Dye;

public class DyeBlock
  implements Listener
{
  @EventHandler
  public void onPlayerInteractEvent(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();

    if (e.getAction() == Action.RIGHT_CLICK_BLOCK)
    {
      if ((e.getHand().equals(EquipmentSlot.HAND)) && (e.getClickedBlock().getType() == Material.CONCRETE_POWDER))
      {
        if (p.getInventory().getItemInMainHand().getType() == Material.INK_SACK)
        {
          DyeColor dyeInHand = ((Dye)p.getInventory().getItemInMainHand().getData()).getColor();

          e.getClickedBlock().setData(dyeInHand.getWoolData());
          p.playSound(p.getLocation(), Sound.BLOCK_SLIME_PLACE, 0.5F, 1.0F);
        }
      }
    }
  }
}