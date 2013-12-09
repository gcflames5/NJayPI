package net.njay.njaypi.Config;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;

/**
 * @author Nick
 */
public class PlayerLocationConfig extends APIConfig{
	
	private YamlConfiguration config;
	
	public PlayerLocationConfig(YamlConfiguration config){
		this.config = config;
	}
	
	/**
	 * @param path Path to element above x,y,z,yaw,pitch elements
	 */
	public Location readLocation(String path){
		double x,y,z,yaw,pitch;	World world;
		x = config.getDouble(path + ".x");
		y = config.getDouble(path + ".y");
		z = config.getDouble(path + ".z");
		yaw = config.getDouble(path + ".yaw");
		pitch = config.getDouble(path + ".pitch");
		world = Bukkit.getWorld(config.getString(path + ".worldname"));
		return new Location(world, x, y, z, (float)yaw, (float)pitch);
	}
	
}
