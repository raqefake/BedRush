package BedRush.thorben653.ItemDropper;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Item;
import BedRush.thorben653.main.BR;

public class Ticker {
	public static int STier1;
	public static int STier2;
	public static int STier3;

	public static void startItemDropper(){
		//Fill ArrayLists
		Tier1.fill();
		Tier2.fill();
		Tier3.fill();

		STier1 = Bukkit.getScheduler().scheduleSyncRepeatingTask(BR.instance, new Runnable(){
			@Override
			public void run() {
				DropTier1();
			}
		}, 60, 60);
		
		STier2 = Bukkit.getScheduler().scheduleSyncRepeatingTask(BR.instance, new Runnable(){
			@Override
			public void run() {
				DropTier2();
			}
		}, 20 * 20, 20 * 20);
		
		STier3 = Bukkit.getScheduler().scheduleSyncRepeatingTask(BR.instance, new Runnable(){
			@Override
			public void run() {
				DropTier3();
			}
		}, 20 * 40, 20 * 40);
	}

	public static void DropTier1(){
		int tier = 1;
		for(int i = BR.lcfg.getInt("Spawner." + tier + ".Amount"); i>0; i--){
			int amount = i;
			
			Location l;
			World w = Bukkit.getWorld(BR.lcfg.getString("Spawner. " + tier + "." +  amount + ".world"));
			double x = BR.lcfg.getDouble("Spawner. " + tier + "." +  amount + ".x");
			double y = BR.lcfg.getDouble("Spawner. " + tier + "." +  amount + ".y");
			double z = BR.lcfg.getDouble("Spawner. " + tier + "." +  amount + ".z");
			
			l = new Location(w,x,y,z);
			int rnd = (int) (Math.random() * Tier1.items.size());
			final Item it = w.dropItem(l, Tier1.items.get(rnd));
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(BR.instance, new Runnable(){
				@Override
				public void run() {
					it.remove();
				}
			}, 20 * 60);
		}
	}
	
	public static void DropTier2(){
		int tier = 2;
		for(int i = BR.lcfg.getInt("Spawner." + tier + ".Amount"); i>0; i--){
			int amount = i;
			
			Location l;
			World w = Bukkit.getWorld(BR.lcfg.getString("Spawner. " + tier + "." +  amount + ".world"));
			double x = BR.lcfg.getDouble("Spawner. " + tier + "." +  amount + ".x");
			double y = BR.lcfg.getDouble("Spawner. " + tier + "." +  amount + ".y");
			double z = BR.lcfg.getDouble("Spawner. " + tier + "." +  amount + ".z");
			
			l = new Location(w,x,y,z);
			int rnd = (int) (Math.random() * Tier2.items.size());
			final Item it = w.dropItem(l, Tier2.items.get(rnd));
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(BR.instance, new Runnable(){
				@Override
				public void run() {
					it.remove();
				}
			}, 20 * 90);
		}	
	}
	
	
	public static void DropTier3(){
		int tier = 3;
		for(int i = BR.lcfg.getInt("Spawner." + tier + ".Amount"); i>0; i--){
			int amount = i;
			
			Location l;
			World w = Bukkit.getWorld(BR.lcfg.getString("Spawner. " + tier + "." +  amount + ".world"));
			double x = BR.lcfg.getDouble("Spawner. " + tier + "." +  amount + ".x");
			double y = BR.lcfg.getDouble("Spawner. " + tier + "." +  amount + ".y");
			double z = BR.lcfg.getDouble("Spawner. " + tier + "." +  amount + ".z");
			 
			l = new Location(w,x,y,z);
			int rnd = (int) (Math.random() * Tier3.items.size());
			final Item it = w.dropItem(l, Tier3.items.get(rnd));
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(BR.instance, new Runnable(){
				@Override
				public void run() {
					it.remove();
					
				}
			}, 20 * 120);
		}	
	}
	
	
	
	
	
	
	
}
