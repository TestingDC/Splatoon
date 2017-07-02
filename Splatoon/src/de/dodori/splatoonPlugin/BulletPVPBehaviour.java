package de.dodori.splatoonPlugin;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class BulletPVPBehaviour
  implements Listener
{
  @EventHandler
  public void onProjectileHit(ProjectileHitEvent event)
  {
    Entity ent = event.getEntity();
    Entity hent = event.getHitEntity();

    if (ent.hasMetadata("inkShooter"))
    {
      if (hent.getType().equals(EntityType.PLAYER))
      {
        Player player = (Player)hent;
        player.setCollidable(false);
      }
    }
  }
}