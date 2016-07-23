package BedRush.thorben653.activeLogic;

import javax.swing.text.AbstractDocument.BranchElement;

import org.bukkit.Bukkit;
import org.bukkit.event.server.ServerListPingEvent;

import BedRush.thorben653.main.BR;

public class PingEv {

	
	public static void Pingev(ServerListPingEvent e)
	{
		if(BR.inSarting = true)
		{
			e.setMotd(Bukkit.getOnlinePlayers().size() + "/"+Bukkit.getMaxPlayers());
		}
		else
		{
			e.setMotd("§cINGAME");
		}
	}
	
	
}
