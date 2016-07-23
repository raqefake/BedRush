package BedRush.thorben653.activeLogic;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import BedRush.thorben653.main.BR;
import me.thorben653.methods.Messages;
import me.thorben653.methods.TeamLogic;

public class DamageEv {
	
	public static void damage(EntityDamageEvent e){
		if(BR.hasEnded == true || BR.hasStarted == false){
			e.setCancelled(true);
			return;
		}
		

		
		
	}

	public static void damagebyEntity(EntityDamageByEntityEvent e){
		if(!(e.getEntity() instanceof Player))return;
		if(!(e.getDamager() instanceof Player))return;
		Player p = (Player) e.getEntity();
		Player k = (Player) e.getDamager();
		
		//Sind in gleichen Team?
		if(TeamLogic.Blue.contains(k) && TeamLogic.Blue.contains(p))
		{
			e.setCancelled(true);
			k.sendMessage(Messages.damageByTeam);
		}
		if(TeamLogic.Red.contains(k) && TeamLogic.Red.contains(p))
		{
			e.setCancelled(true);
			k.sendMessage(Messages.damageByTeam);
		}
		
		
	}
}
