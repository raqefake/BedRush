package BedRush.ragemc.workspace.effects.random;

import org.bukkit.Bukkit;

import BedRush.thorben653.main.BR;

public class EffectSheduler {
	
	public static int i;
	
	public EffectSheduler(){}
	
	public static void Start(){
		i = Bukkit.getScheduler().scheduleSyncRepeatingTask(BR.instance, new Runnable(){
			@Override
			public void run() {
				BR.effectManager.sendRandomEffect();
			}
		}, 20 * 120 * 1, 20 * 120 * 1);
		
	}
	
	public static void Stop(){
		Bukkit.getScheduler().cancelTask(i);
	}

}
