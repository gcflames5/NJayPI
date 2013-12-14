package net.njay.njaypi.Game;

public enum GameMode {

	TDM("TeamdeathMatch", "TDM"), CTF("CaptureTheFlag", "Capture the Flag", "CTF");
	
	String[] aliases;
	GameMode(String... aliases){
		this.aliases = aliases;
	}
	public String[] getAlisases(){
		return this.aliases;
	}
	public boolean isAlias(String s){
		for (String entry : this.aliases){
			if (entry.equalsIgnoreCase(s))
				return true;
		}
		return false;
	}
	
}
