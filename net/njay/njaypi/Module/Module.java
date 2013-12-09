package net.njay.njaypi.Module;

/**
 * @author Nick
 */
public abstract class Module {
	
	protected boolean enabled;
	
	public boolean enabled(){
		return enabled;
	}
	
	public void setEnabled(boolean enabled){
		this.enabled = enabled;
	}
}
