package BedRush.thorben653.activeLogic;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;

import BedRush.thorben653.main.BR;
import me.thorben653.methods.PlayerStatus;
import me.thorben653.methods.ActionBar;
import me.thorben653.methods.GiveItems;
import me.thorben653.methods.Messages;
import me.thorben653.methods.Teleports;

public class JoinEv {
	
	public static void join(PlayerJoinEvent e){
		Player p = e.getPlayer();
	
		
		//Spec?
		if(BR.hasStarted == true){
			PlayerStatus.Spectator(p);
			e.setJoinMessage(null);
			return;
		}
		e.setJoinMessage(Messages.onJoin.replace("%player%", p.getName()));
		p.setGameMode(GameMode.SURVIVAL);
		
		//LobbyTel
		Teleports.Lobby(p);
		
		//LobbyItems
		GiveItems.Lobby(p);
		
		p.setFoodLevel(99999);
		p.setHealth(20);
		
		//Sende werbung
		ActionBar.sendActionBar(p, Messages.selfmade);
		
		
	}

}
