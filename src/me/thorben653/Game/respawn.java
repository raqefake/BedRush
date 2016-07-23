package me.thorben653.Game;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import BedRush.thorben653.main.BR;
import me.thorben653.methods.BedAPI;
import me.thorben653.methods.Messages;
import me.thorben653.methods.PlayerStatus;
import me.thorben653.methods.StatsAPI;
import me.thorben653.methods.TeamLogic;
import me.thorben653.methods.Teleports;

public class respawn {
	
	
	
	public static void spawnPlayer(final Player p, Player killer){

		p.getInventory().clear();
		//Messages.respawnWithOutBed;
		//Hat Bett?
		if((TeamLogic.Red.contains(p) && BedAPI.existRedBed==false) || (TeamLogic.Blue.contains(p) && BedAPI.existBlueBed==false)){
			//Add Death
			StatsAPI.addDeath(killer);
			
			//Remove from Teams
			TeamLogic.Blue.remove(p);
			TeamLogic.Red.remove(p);
			
			//Messages...
			for(Player all : Bukkit.getOnlinePlayers())all.sendMessage(Messages.isOut.replace("%player%", p.getName()));
			p.sendMessage(Messages.respawnWithOutBed);
			
			//Setting Spectator...
			PlayerStatus.Spectator(p);
			
			//Teleportiere...
			if(killer instanceof Player){
				//Adde Kill
				StatsAPI.addKill(killer);
				
				p.teleport(killer);
				killer.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
				}else{
				for(Player all : Bukkit.getOnlinePlayers()){
					if(!p.equals(all)){
						p.teleport(all);
						break;
					}
				}
			}
			
			//Teste auf win
			winEvent.CheckFor();
			
			return;
		}  //End Ausscheiden
		

		
		Bukkit.getScheduler().runTaskLater(BR.instance, new Runnable() {
			@Override
			public void run() {
				p.setFallDistance(0);
				
			//Respawn
             p.spigot().respawn();
             
     		//Teleportiere
     		Teleports.game(p);
     		
     		//MEssage
    		p.sendMessage(Messages.respawnWithBed);
    		
    		p.getInventory().clear();
    		p.setFoodLevel(99999);
    		
    		TeamLogic.setHelmet(p);
    		

			}}, 30);
	}
	
	
	
	public static void first(final Player p){
		p.setFallDistance(0);
 		//Teleportiere
 		Teleports.game(p);
 		
 		//MEssage
		p.sendMessage(Messages.respawnWithBed);
		
		p.getInventory().clear();
		
		TeamLogic.setHelmet(p);
	}
}
