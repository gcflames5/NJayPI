package net.njay.njaypi.Team;

/**
 * @author Nick
 */
public enum TeamColor {
	RED("Red"), BLUE("Blue"), GREEN("Green"), GOLD("Gold"), PURPLE("Purple");
	
	String name;
	TeamColor(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	
	public static TeamColor parse(String s){
		for (TeamColor color : TeamColor.values()){
			if (color.getName().equalsIgnoreCase(s))
				return color;
		}
		return null;
	}
}
