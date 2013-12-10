package net.njay.njaypi.Config;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

/**
 * @author Nick
 */ 
public class APIConfig {

	private File config = new File("APIConfig.yml");
	private YamlConfiguration yml;
	//test
	
	public APIConfig(){
		if (!config.exists())
			try {config.createNewFile();} catch(Exception e) {e.printStackTrace();}
		yml = YamlConfiguration.loadConfiguration(config);
	}
	
	public YamlConfiguration getYMLConfig(){
		return this.yml;
	}

}
