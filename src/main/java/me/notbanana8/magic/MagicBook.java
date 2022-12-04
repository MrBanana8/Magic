package me.notbanana8.magic;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;


public class MagicBook implements Listener {


    @EventHandler(priority = EventPriority.MONITOR)
    public void onShoot(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack hand = player.getInventory().getItemInMainHand();
        if (hand.getItemMeta().getDisplayName().contains(ChatColor.GOLD + "[SoulFire]")) {
            particleBeam(player);
        }
        if (!hand.getItemMeta().getDisplayName().contains(ChatColor.LIGHT_PURPLE + "Magic Book")) return;
        if(!player.isSneaking()) return;
        if(!event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;
        player.openInventory(new SpellSelector ().inv);


    }

    public static void particleBeam(Player player){
        Location startLoc = player.getEyeLocation();
        Location particleLoc = startLoc.clone();

        World world = startLoc.getWorld();

        Vector dir = startLoc.getDirection().normalize();

        Vector vecOffset = dir.clone().multiply(0.5);


        new BukkitRunnable(){
            int maxBeamLength = 30;
            int beamLength = 0;
            public void run(){
                for (Entity entity : world.getNearbyEntities(particleLoc, 5, 5, 5)) {
                    if (entity instanceof LivingEntity) {
                        if (entity == player)
                            continue;


                        Vector particleMinVector = new Vector(particleLoc.getX() - 0.25, particleLoc.getY() - 0.25, particleLoc.getZ() - 0.25);
                        Vector particleMaxVector = new Vector(particleLoc.getX() + 0.25, particleLoc.getY() + 0.25, particleLoc.getZ() + 0.25);

                        if(entity.getBoundingBox().overlaps(particleMinVector,particleMaxVector)){
                            world.playSound(particleLoc,Sound.ENTITY_PLAYER_HURT_ON_FIRE,2,2);
                            entity.setVelocity(entity.getVelocity().add(particleLoc.getDirection().normalize().multiply(1)));
                            ((Damageable) entity).damage(8.5,player);
                            entity.setFireTicks(30);
                            world.spawnParticle(Particle.VILLAGER_ANGRY, particleLoc, 5);
                            this.cancel();
                            return;
                        }
                    }
                }
                beamLength++;
                if(beamLength >= maxBeamLength){
                    world.spawnParticle(Particle.VILLAGER_ANGRY, particleLoc, 5);
                    this.cancel();
                    return;
                }
                particleLoc.add(vecOffset);
                world.spawnParticle(Particle.SOUL_FIRE_FLAME, particleLoc, 0);
            }
        }.runTaskTimer(Magic.getPlugin(Magic.class), 0, 1);
    }
}