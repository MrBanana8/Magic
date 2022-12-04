package me.notbanana8.magic;

import de.slikey.effectlib.util.ParticleEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.event.player.PlayerAnimationType;
import org.bukkit.util.Vector;

public class ExampleSpell implements Listener {
    @EventHandler
    public void beam (PlayerAnimationEvent event){


        if (event.getAnimationType() == PlayerAnimationType.ARM_SWING) {
            Player player = event.getPlayer();
            if (player.getInventory().getItemInMainHand() != null){
                if (player.getInventory().getItemInMainHand().getType() == Material.STICK){

                    Location loc = player.getLocation();
                    Vector direction = loc.getDirection();

                    player.getLocation().getWorld().playSound(loc, Sound.ENTITY_PLAYER_ATTACK_SWEEP, 1, 2);
                    outerloop: for(double t = 0; t < 16; t+=1){


                        loc.add(direction);
                        loc.add(0, 1.5, 0);

                        ParticleEffect.CLOUD.display(0, 0, 0, 0.05F, 2, loc, 30);

                        if (loc.getBlock().getType().isSolid()){
                            ParticleEffect.CLOUD.display(0, 0, 0, 0.13F, 50, loc, 30);
                            break outerloop;
                        }

                        for (Entity e : loc.getChunk().getEntities()){
                            if (e.getLocation().distance(loc) < 1.5){
                                if (e != (player)){
                                    if(e.getType().isAlive()) {
                                        Damageable d = (Damageable) e;
                                        d.damage(5, player);
                                        ParticleEffect.CLOUD.display(0, 0, 0, 0.13F, 50, loc, 30);
                                        break outerloop;
                                    }
                                }
                            }
                        }
                        loc.subtract(0, 1.5, 0);

                    }
                }
            }
        }
    }
}
