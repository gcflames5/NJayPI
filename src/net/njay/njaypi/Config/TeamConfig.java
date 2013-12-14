package net.njay.njaypi.Config;

import net.njay.njaypi.Game.GameMode;


/**
 * @author Nick
 */
public class TeamConfig extends APIConfig{
	
	GameMode gametype;
	String teamPath;
	
	public TeamConfig(GameMode type, String teamPath){
		this.gametype = type;
		this.teamPath = teamPath;
	}
	
}
