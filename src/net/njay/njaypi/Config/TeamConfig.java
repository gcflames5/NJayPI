package net.njay.njaypi.Config;

import org.bukkit.command.defaults.GameModeCommand;


public class TeamConfig extends APIConfig{
	
	GameModeCommand gametype;
	String teamPath;
	
public TeamConfig(GameModeCommand type, String teamPath){
		this.gametype = type;
		this.teamPath = teamPath;
	}
	
}
