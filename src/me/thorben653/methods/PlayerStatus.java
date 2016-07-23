package me.thorben653.methods;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

public class PlayerStatus {
	
	public static void Spectator(Player p){
		//Entferne Effects
		for(PotionEffect ef : p.getActivePotionEffects()){
			p.removePotionEffect(ef.getType());
		}
		
		//Setze Standarts
		p.getInventory().clear();
		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		p.getInventory().setChestplate(new ItemStack(Material.AIR));
		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		p.getInventory().setBoots(new ItemStack(Material.AIR));
		
		p.setHealth(20);
		p.setFoodLevel(99999);
		
		p.setGameMode(GameMode.SPECTATOR);
		
		//Teleportiere zu killer, wenn gegeben
		if(p.getKiller() instanceof Player){
			p.teleport(p.getKiller());
		}else{
			for(Player all : Bukkit.getOnlinePlayers()){
				p.teleport(all);
				return;
			}
		}
		
	}

}
