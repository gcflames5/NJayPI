package net.njay.njaypi.Team;


import java.util.ArrayList;

/**
 * @author Nick
 */
public class TeamAttributeList {
	
	private ArrayList<TeamAttribute> attributes = new ArrayList<TeamAttribute>();
	
	public boolean hasAttribute(String name){
		return getAttribute(name) != null;
	}
	public TeamAttribute getAttribute(String name){
		for (TeamAttribute attribute : this.attributes){
			if (attribute.getName().equals(name))
				return attribute;
		}
		return null;
	}
	
	/**
	 * @param attribute to be added
	 * @return will return true if it overrides an exiting TeamAttribute
	 * otherwise it will return false
	 */
	public boolean addAttribute(TeamAttribute attribute){
		if (hasAttribute(attribute.getName())){
			for (TeamAttribute tatt: attributes){
				if (tatt.getName().equals(attribute)){
					attributes.remove(tatt);
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
		for (TeamAttribute tatt: attributes){
			if (tatt.getName().equals(attribute)){
				attributes.remove(tatt);
				return true;
			}
		}
		return false;
	}
}

