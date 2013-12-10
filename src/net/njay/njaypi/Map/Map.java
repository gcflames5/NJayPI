package net.njay.njaypi.Map;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;

/**
 * @author Nick
 */
public class Map {

	private String worldName;
	private File config;
	
	public Map(File mapDir, File config){
		if (!config.exists())
			throw new RuntimeException("File does not exist!");
		this.config = config;
	}
	
	public String getWorldName(){
		return this.worldName;
	}
	public File getConfig(){
		return this.config;
	}
	
	public void load(){
		if (!isLoaded(this.worldName))
			Bukkit.getServer().createWorld(new WorldCreator(this.worldName));
	}
	
	public void unload(boolean save){
		Bukkit.getServer().unloadWorld(getWorld(this.worldName), save);
	}
	
	private boolean isLoaded(String name){
		for (World w : Bukkit.getServer().getWorlds()){
			if (w.getName().equalsIgnoreCase(name))
				return true;
		}
		return false;
	}
	
	private World getWorld(String name){
		for (World w : Bukkit.getServer().getWorlds()){
			if (w.getName().equalsIgnoreCase(name))
				return w;
		}
		return null;
	}
}
