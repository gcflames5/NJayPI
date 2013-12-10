package net.njay.njaypi.Team;

/**
 * @author Nick
 */
public class TeamAttribute {
	
	private String name;
	private double nData;
	private String sData;
	
	public TeamAttribute(String name, double nData){
		this.name = name;
		this.nData = nData;
	}
	
	public TeamAttribute(String name, String sData){
		this.name = name;
		this.sData = sData;
	}
	
	public TeamAttribute(String name, double nData, String sData){
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
