package BedRush.ragemc.workspace.effects.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class EffectManager
{

    List<Effects> effectList = new ArrayList<>();

    public EffectManager()
    {
        effectList.add(Effects.HEAL);
        effectList.add(Effects.BLINDNESS);
        effectList.add(Effects.NOISEA);
        effectList.add(Effects.POISEN);
        effectList.add(Effects.SPEED);
        effectList.add(Effects.FREEZE);
        effectList.add(Effects.LIGHTNING);
        effectList.add(Effects.DAMAGE);
        effectList.add(Effects.INVENTORY);
        effectList.add(Effects.TELEPORT);
        effectList.add(Effects.JUMP);
        effectList.add(Effects.FLIP);
    }
    public void sendRandomEffect()
    {

        Random rnd = new Random();
        List<Integer> i = new ArrayList<>();
        i.add(0);
        i.add(1);
        i.add(2);
        i.add(3);
        i.add(4);
        i.add(5);
        i.add(6);
        i.add(7);
        i.add(8);
        i.add(9);
        i.add(11);
        Effects e = effectList.get(i.get(rnd.nextInt(i.size())));
        if( e.equals(Effects.FLIP) )
        {
            for( Player all : Bukkit.getOnlinePlayers() )
            {
                all.sendTitle("§dRETARD", "§6Random Event");
            	Location loc = all.getLocation();
            	Location flipped = new Location(loc.getWorld(), loc.getX(), loc.getY(), loc.getZ(), (loc.getYaw() < 180 ? loc.getYaw() - 180 : loc.getYaw() + 180), loc.getPitch());
            	all.teleport(flipped);

            }
        }
        if( e.equals(Effects.SPEED) )
        {
            for( Player all : Bukkit.getOnlinePlayers() )
            {
                all.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20 * 12, 2));
                all.sendTitle("§dSPEED", "§6Random Effekt");
                all.playSound(all.getLocation(), Sound.NOTE_PIANO, 1, 1);

            }
            return;
        }
        if( e.equals(Effects.HEAL) )
        {

            for( Player all: Bukkit.getOnlinePlayers() )
            {
                all.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20 * 12, 1));
                all.sendTitle("§dREGENRATION", "§6Random Effekt");
                all.playSound(all.getLocation(), Sound.NOTE_PIANO, 1, 1);

            }

            return;
        }
        if( e.equals(Effects.NOISEA) )
        {

            for( Player all : Bukkit.getOnlinePlayers() )
            {
                all.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 20 * 12, 1));
                all.sendTitle("§dCONFUSION", "§6Random Effekt");
                all.playSound(all.getLocation(), Sound.NOTE_PIANO, 1, 1);
            }


            return;
        }
        if( e.equals(Effects.BLINDNESS) )
        {

            for( Player all : Bukkit.getOnlinePlayers() )
            {
                all.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20 * 12, 1));
                all.sendTitle("§dBLINDNESS", "§6Random Effekt");
                all.playSound(all.getLocation(), Sound.NOTE_PIANO, 1, 1);

            }

            return;
        }
        if( e.equals(Effects.POISEN) )
        {
            for( Player all : Bukkit.getOnlinePlayers() )
            {
                all.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 20 * 12, 1));
                all.sendTitle("§dPOISON", "§6Random Effekt");         
                all.playSound(all.getLocation(), Sound.NOTE_PIANO, 1, 1);
            }

            return;
        }
        if( e.equals(Effects.FREEZE) )
        {
            for( Player all : Bukkit.getOnlinePlayers() )
            {
                all.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20 * 12, 15));
                all.sendTitle("§dFREEZE", "§6Random Effekt");
                all.playSound(all.getLocation(), Sound.NOTE_PIANO, 1, 1);
            }
        }
        if( e.equals(Effects.LIGHTNING) )
        {
            for( Player all : Bukkit.getOnlinePlayers() )
            {
                all.getWorld().strikeLightning(all.getLocation());
                all.sendTitle("§dLIGHTNING", "§6Random Event");
                all.playSound(all.getLocation(), Sound.NOTE_PIANO, 1, 1);
            }
        }
        if( e.equals(Effects.DAMAGE) )
        {
            for( Player all : Bukkit.getOnlinePlayers() )
            {
                all.damage(4D);
                all.sendTitle("§dDAMAGE", "§6Random Event");
                all.playSound(all.getLocation(), Sound.NOTE_PIANO, 1, 1);
            }
        }
        if( e.equals(Effects.INVENTORY) )
        {
            for( Player all : Bukkit.getOnlinePlayers() )
            {
                all.getInventory().clear();
                all.playSound(all.getLocation(), Sound.ITEM_BREAK, 3, 1);
                all.sendTitle("§dCLEAR INVENTORY", "§6Random Effekt");
            }
        }
        if( e.equals(Effects.TELEPORT) )
        {
            for( Player all : Bukkit.getOnlinePlayers() )
            {
            	all.teleport(all.getLocation().add(0,5,0));
                all.sendTitle("§dTELEPORT", "§6Random Event");
            }
        }
        if( e.equals(Effects.JUMP) )
        {
            for( Player all : Bukkit.getOnlinePlayers() )
            {
            	all.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 20 * 12, 3));
                all.sendTitle("§dJUMP", "§6Random Effekt");
            }
        }
        return;
    }

    public void addEffect(PotionEffectType effect)
    {
        for( Player all : Bukkit.getOnlinePlayers() )
        {
            all.addPotionEffect(new PotionEffect(effect, 20 * 6, 1));
        }
        return;
    }

    public void removeEffect(PotionEffectType effect)
    {
        for( Player all : Bukkit.getOnlinePlayers() )
        {
            all.removePotionEffect(effect);
        }
        return;
    }




}