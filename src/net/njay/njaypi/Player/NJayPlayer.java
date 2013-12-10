package net.njay.njaypi.Player;

import java.util.ArrayList;

import net.njay.njaypi.Kit.Kit;
import net.njay.njaypi.Team.Team;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * @author Nick
 */
public class NJayPlayer {
	
	private static ArrayList<NJayPlayer> allPlayers = new ArrayList<NJayPlayer>();
	
	private PlayerAttributeList pAttList = new PlayerAttributeList();
	private Player player;
	private Team team;
	private Kit kit;
	 
	private NJayPlayer(String playername){
		this.player = Bukkit.getPlayer(playername);
		allPlayers.add(this);
	}
	
	public PlayerAttributeList getAttributeList(){
		return this.pAttList;
	}

	public Player getPlayer(){
		return this.player;
	}
	
	public void setTeam(Team t){
		this.team = t;
	}
	
	public Team getTeam(){
		return team;
	}
	
	public static NJayPlayer getPlayer(String playername){
		for (NJayPlayer njp : allPlayers){
			if (njp.getPlayer().getName().equals(playername))
				return njp;
		}
		return new NJayPlayer(playername);
		
	}
	
	public void setKit(Kit k){
		this.kit = k;
	}
	public Kit getKit(){
		return this.kit;
	}
}
