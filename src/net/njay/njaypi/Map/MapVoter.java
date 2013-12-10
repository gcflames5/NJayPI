package net.njay.njaypi.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/**
 * @author Nick
 */
public class MapVoter {

	private List<String> playersWhoVoted = new ArrayList<String>();
	private List<Map> maps;
	private HashMap<Integer,Integer> votes = new HashMap<Integer, Integer>();
	
	public MapVoter(List<Map> maps){
		this.maps = maps;
	}
	
	public boolean submitVote(String playerName, int vote){
		if (playerHasVoted(playerName))
			return false;
		if (maps == null || vote > maps.size())
			throw new RuntimeException("Vote out of bounds!");
		if (votes.get(vote) == null)
			votes.put(vote, 1);
		else
			votes.put(vote, votes.get(vote)+1);
		playersWhoVoted.add(playerName);
		return true;
	}
	
	public void setMapList(List<Map> maps){
		this.maps = maps;
	}
	
	public boolean playerHasVoted(String playerName){
		for (String s : playersWhoVoted){
			if (s.equalsIgnoreCase(playerName))
				return true;
		}
		return false;
	}
	
	public Map getVotedMap(){
		int mapIndex = 0, max = 0;
		for (Entry<Integer,Integer> entry : this.votes.entrySet()){
			if (entry.getValue() != null && entry.getValue() > max){
				mapIndex = entry.getKey();
				max = entry.getValue();
			}
		}
		return this.maps.get((mapIndex-1));
	}
}
