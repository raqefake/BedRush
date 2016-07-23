package BedRush.thorben653.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import me.thorben653.Game.respawn;
import me.thorben653.methods.Messages;

public class DeathManager implements Listener {
	@EventHandler
	public static void onDeath(PlayerDeathEvent e){
		Player p = e.getEntity();
		
		e.setDeathMessage(null);
		
		//Death
		if(e.getEntity().getKiller() instanceof Player){
			Player killer = p.getKiller();
			
			Bukkit.broadcastMessage(Messages.killedBy.replace("%player%", p.getName()).replace("%killer%", killer.getName()));
			
		}else{
			Bukkit.broadcastMessage(Messages.playerDie.replace("%player%", p.getName()));
		}
		
		//Respawn
		respawn.spawnPlayer(p, p);
		
		//Remove Helmet from Drops
		try{for(ItemStack i : e.getDrops()){if(i.getType() == Material.LEATHER_HELMET){e.getDrops().remove(i);}}}catch(Exception ex){}
	
	}
}
