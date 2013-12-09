package net.njay.njaypi.Module;

import org.bukkit.event.Listener;

/**
 * @author Nick
 */
public abstract class ListenerModule extends Module implements Listener{

	public ListenerModule(){
		setEnabled(true);
	}
	
	@Override
	public abstract void setEnabled(boolean enabled);
}
