package BedRush.thorben653.listeners;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

@SuppressWarnings("deprecation")
public class ChatManager implements Listener {
	
	public static String Chat = "§7>> §f";
	
	@EventHandler
	public void OnChat(PlayerChatEvent e){
		Player p = e.getPlayer();
		
		if(p.getGameMode() == GameMode.SPECTATOR){
			for(Player all : Bukkit.getOnlinePlayers()){
				if(all.getGameMode() == GameMode.SPECTATOR)all.sendMessage("§8[§4x§8] §7" + p.getName() + " " + Chat + e.getMessage());
			}
			return;
		}
		
		e.setFormat("§a" + p.getName().replace("_raqe", "§bDev §7| §b_raqe").replace("Thorben653YT", "§bDev §7| §bThorben653YT") + Chat + e.getMessage());

		if(p.getUniqueId().toString().equalsIgnoreCase("0641b6ea-51f0-4723-b867-e4d3a0ec779f")){
			p.setPlayerListName("§bDev §7| §bThorben653YT");
		}
		if(p.getUniqueId().toString().equalsIgnoreCase("721c244f-b0ff-4dc3-b43e-6aadeef9bf7a"))
		{
			p.setPlayerListName("§bDev §7| §b_raqe");
		}
		
		
	}
	
	
	
	
	
	
	

}
