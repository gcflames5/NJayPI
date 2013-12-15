package net.njay.njaypi.Team;

import java.util.ArrayList;

import net.njay.njaypi.Kit.Kit;
import net.njay.njaypi.Player.NJayPlayer;

import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 * @author Nick
 */
public class Team {

	private ArrayList<String> players = new ArrayList<String>();
	private TeamAttributeList tAttList = new TeamAttributeList();
	private ArrayList<Kit> availableKits = new ArrayList<Kit>();
	private Location spawn;
	private TeamColor color;
	
	public Team(String... players){
		for (String player : players)
			this.players.add(player);
	}
	
	public Team(Player... players){
		for (Player player : players)
			this.players.add(player.getName());
	}
	
	public void addPlayer(Player p){
		players.add(p.getName());
	}
	public void addPlayer(String playername){
		players.add(playername);
	}
	public void removePlayer(Player p){
		players.remove(p.getName());
	}
	public void removePlayer(String playername){
		players.remove(playername);
	}
	public ArrayList<String> getPlayers(){
		return this.players;
	}
	public TeamAttributeList getAttributeList(){
		return this.tAttList;
	}
	public void setTeamColor(TeamColor color){
		this.color = color;
	}
	public TeamColor getColor(){
		return this.color;
	}
	public void setSpawn(Location l){
		this.spawn = l;
	}
	public Location getSpawn(){
		return this.spawn;
	}
	//public void applyConfig(TeamConfig config){
		
	//}
	
	/**
	 * Sets the local Team variable of each NJayPlayer on
	 * this Team
	 */
	public void synchPlayers(){
		for (String playerName : this.players){
			NJayPlayer.getPlayer(playerName).setTeam(this);
		}
	}

	public ArrayList<Kit> getAvailableKits() {
		return availableKits;
	}

	public void setAvailableKits(ArrayList<Kit> availableKits) {
		this.availableKits = availableKits;
	}
}
