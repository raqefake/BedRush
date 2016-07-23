package BedRush.ragemc.workspace.map;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;

public class Map {

	public Map(){}
	
	public void unloadMap(String map)
	{
		if(Bukkit.getWorld(map) != null)
		{
			Bukkit.unloadWorld(map, false);
		}
	}
	public void loadMap(String map)
	{
		if(Bukkit.getWorld(map) != null)
		{
			WorldCreator worldCreator = new WorldCreator(map);
			worldCreator.copy(Bukkit.getWorld(map));
			worldCreator.type(WorldType.FLAT);
			worldCreator.generator();
			Bukkit.createWorld(worldCreator);
		}
	}
	public void restoreWorld(String map)
	{
		this.unloadMap(map);
		this.loadMap(map);
	}
	
}
