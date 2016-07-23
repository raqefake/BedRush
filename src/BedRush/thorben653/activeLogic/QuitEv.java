package BedRush.thorben653.activeLogic;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerQuitEvent;

import BedRush.thorben653.main.BR;
import me.thorben653.methods.Messages;

public class QuitEv {

	public static void quit(PlayerQuitEvent e){
		
		Player p = e.getPlayer();
		
		if(BR.hasEnded != true){
		e.setQuitMessage(Messages.onQuit.replace("%player%", p.getName()));
		}
		
		if(BR.hasStarted == true && BR.hasEnded == false){
			if(!(p.getGameMode() == GameMode.SPECTATOR)){
				p.setHealth(1);
				p.damage(20);
			}
		}
		if(Bukkit.getOnlinePlayers().size() == BR.cfg.getInt("PlayersToStart"))
		{
			BR.lobbyScoreboard.killBoard();
		}
		
		
	}
}
