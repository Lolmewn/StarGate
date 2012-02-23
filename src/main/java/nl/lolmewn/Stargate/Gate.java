package nl.lolmewn.Stargate;

import org.bukkit.Location;

public class Gate {
	
	private String name;
	private Location loc;
	
	public Gate(String name, Location loc){
		this.name = name;
		this.loc = loc;
	}
	
	public String getName(){
		return this.name;
	}
	
	public Location getLocation(){
		return this.loc;
	}
	
	public String toString(){
		return name + "=" + loc.getWorld().getName() + "," + loc.getBlockX() + "," + loc.getBlockY() + "," + loc.getBlockZ();
	}

}
