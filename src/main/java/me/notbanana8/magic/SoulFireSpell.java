package me.notbanana8.magic;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class SoulFireSpell {

    public static void soulFire(Player player){
            if (player.getInventory().getItemInMainHand() != null){

                    Location loc = player.getLocation();
                    Vector direction = loc.getDirection();

                    player.getLocation().getWorld().playSound(loc, Sound.BLOCK_FIRE_AMBIENT, 2, 2);
                    outerloop: for(double t = 0; t < 16; t++){

                        loc.add(direction);
                        loc.add(0, 1.5, 0);

                        player.getWorld().spawnParticle(Particle.SOUL_FIRE_FLAME,loc,0,0,0,0);

                        if (loc.getBlock().getType().isSolid()){
                            player.getWorld().spawnParticle(Particle.SOUL_FIRE_FLAME,loc,0,0,0,0);
                            break outerloop;
                        }

                        for (Entity e : loc.getChunk().getEntities()){
                            if (e.getLocation().distance(loc) < 1.5){
                                if (e != (player)){
                                    if(e.getType().isAlive()) {
                                        Damageable d = (Damageable) e;
                                        d.damage(5, player);
                                        player.getWorld().spawnParticle(Particle.SOUL_FIRE_FLAME,loc,0,0,0,0);
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
