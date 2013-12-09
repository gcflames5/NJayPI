package net.njay.njaypi.Player;

import java.util.ArrayList;

import net.njay.njaypi.Team.TeamAttribute;

/**
 * @author Nick
 */
public class PlayerAttributeList {
	
	private ArrayList<PlayerAttribute> attributes = new ArrayList<PlayerAttribute>();
	
	public boolean hasAttribute(String name){
		return getAttribute(name) != null;
	}
	public PlayerAttribute getAttribute(String name){
		for (PlayerAttribute attribute : this.attributes){
			if (attribute.getName().equals(name))
				return attribute;
		}
		return null;
	}
	
	/**
	 * @param attribute
	 * @return will return true if it overrides an exiting PlayerAttribute
	 * otherwise it will return false
	 */
	public boolean addAttribute(PlayerAttribute attribute){
		if (hasAttribute(attribute.getName())){
			for (PlayerAttribute patt: attributes){
				if (patt.getName().equals(attribute)){
					attributes.remove(patt);
					attributes.add(attribute);
					return true;
				}
			}
		}
		attributes.add(attribute);
		return false;
	}
	
	/**
	 * @param attribute to be removed
	 * @return will return true if found object to delete
	 * otherwise, will return false if nothing to remove
	 */
	public boolean removeAttribute(TeamAttribute attribute){
		for (PlayerAttribute patt: attributes){
			if (patt.getName().equals(attribute)){
				attributes.remove(patt);
				return true;
			}
		}
		return false;
	}
}
