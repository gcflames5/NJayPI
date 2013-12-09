package net.njay.njaypi.Player;

/**
 * @author Nick
 */
public class PlayerAttribute {
	
	private String name;
	private double nData;
	private String sData;
	
	public PlayerAttribute(String name, double nData){
		this.name = name;
		this.nData = nData;
	}
	
	public PlayerAttribute(String name, String sData){
		this.name = name;
		this.sData = sData;
	}
	
	public PlayerAttribute(String name, double nData, String sData){
		this.name = name;
		this.nData = nData;
		this.sData = sData;
	}
	
	public String getName(){
		return name;
	}
	
	public double getNData(){
		return nData;
	}
	
	public String getSData(){
		return sData;
	}
	
}
