package me.notbanana8.magic;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class FireSpell {

    public static void soulFire(Player player){
        if (player.getInventory().getItemInMainHand() != null){
            Location loc = player.getLocation();
            Vector direction = loc.getDirection();
            player.getLocation().getWorld().playSound(loc, Sound.BLOCK_FIRE_AMBIENT, 2, 2);
            outerloop: for(double t = 0; t < 16; t++){
                loc.add(direction);
                loc.add(0, 1.5, 0);
                player.getWorld().spawnParticle(Particle.FLAME,loc,0,0,0,0);
                if (loc.getBlock().getType().isSolid()){
                    player.getWorld().spawnParticle(Particle.FLAME,loc,0,0,0,0);
                    break outerloop;
                }
                for (Entity e : loc.getChunk().getEntities()){
                    if (e.getLocation().distance(loc) < 1.5){
                        if (e != (player)){
                            if(e.getType().isAlive()) {
                                Damageable d = (Damageable) e;
                                d.damage(5, player);
                                player.getWorld().spawnParticle(Particle.FLAME,loc,0,0,0,0);
                                e.setFireTicks(35);
                                break outerloop;
                            }
                        }
                    }
                }
                loc.subtract(0, 1.5, 0);
            }
        }

        //Old Spell
        //public static void particleBeam(Player player){
        //    Location startLoc = player.getEyeLocation();
        //    Location particleLoc = startLoc.clone();

        //    World world = startLoc.getWorld();

        //    Vector dir = startLoc.getDirection().normalize();

        //    Vector vecOffset = dir.clone().multiply(0.5);

        //    new BukkitRunnable(){
        //        int maxBeamLength = 30;
        //        int beamLength = 0;
        //        public void run(){
        //            for (Entity entity : world.getNearbyEntities(particleLoc, 5, 5, 5)) {
        //                if (entity instanceof LivingEntity) {
        //                    if (entity == player)
        //                        continue;


        //                    Vector particleMinVector = new Vector(particleLoc.getX() - 0.25, particleLoc.getY() - 0.25, particleLoc.getZ() - 0.25);
        //                    Vector particleMaxVector = new Vector(particleLoc.getX() + 0.25, particleLoc.getY() + 0.25, particleLoc.getZ() + 0.25);

        //                    if(entity.getBoundingBox().overlaps(particleMinVector,particleMaxVector)){
        //                        world.playSound(particleLoc,Sound.ENTITY_PLAYER_HURT_ON_FIRE,2,2);
        //                        entity.setVelocity(entity.getVelocity().add(particleLoc.getDirection().normalize().multiply(1)));
        //                        ((Damageable) entity).damage(8.5,player);
        //                        entity.setFireTicks(30);
        //                        world.spawnParticle(Particle.VILLAGER_ANGRY, particleLoc, 5);
        //                        this.cancel();
        //                        return;
        //                    }
        //                }
        //            }
        //            beamLength++;
        //            if(beamLength >= maxBeamLength){
        //                world.spawnParticle(Particle.VILLAGER_ANGRY, particleLoc, 5);
        //                this.cancel();
        //                return;
        //            }
        //            particleLoc.add(vecOffset);
        //            world.spawnParticle(Particle.SOUL_FIRE_FLAME, particleLoc, 0);
        //        }
        //    }.runTaskTimer(Magic.getPlugin(Magic.class), 0, 1);
        //}
            }
        }
