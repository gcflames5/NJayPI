package net.njay.njaypi.Plugin;

import net.njay.njaypi.Config.APIConfig;
import net.njay.njaypi.Logger.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Nick
 */
public class NJayPI extends JavaPlugin{

	private static Plugin plugin;
	private static APIConfig config;
	
	public static void init(Plugin plugin){
		NJayPI.plugin = plugin;
	}
	
	public static Plugin getPlugin(){
		if (plugin == null) {
			Bukkit.getLogger().warning("NJayPi has not been initialized!");
			for (StackTraceElement l : Thread.currentThread().getStackTrace()) {System.out.println(l);};
		}
		return plugin;			
	}
	
	public static APIConfig getAPIConfig(){
		return config;
	}
	
}
