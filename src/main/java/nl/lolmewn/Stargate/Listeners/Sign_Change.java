package nl.lolmewn.Stargate.Listeners;

import nl.lolmewn.Stargate.Main;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class Sign_Change implements Listener{
	
	private Main plugin;
	
	public Sign_Change(Main m){
		this.plugin = m;
	}
	
	@EventHandler
	public void onSignChange(SignChangeEvent event){
		if(event.getBlock().getType() != Material.WALL_SIGN){
			return;
		}
		String firstLine = event.getLine(0);
		if(firstLine.equalsIgnoreCase("==Stargate==")){
			if(!event.getPlayer().hasPermission("stargate.creategate")){
				event.getPlayer().sendMessage("You do not have permissions to do this!");
				return;
			}
			//Sign s = (Sign)event.getBlock().getState();
			BlockFace face = event.getBlock().getFace(event.getBlock());
			if(!event.getBlock().getRelative(face).equals(Material.OBSIDIAN)){
				event.getPlayer().sendMessage("You have to place the sign on obsidian!");
				event.setCancelled(true);
				return;
			}
			String name = event.getLine(1);
			if(name.isEmpty()){
				event.getPlayer().sendMessage("Please add a name to the second line!");
				event.setCancelled(true);
				return;
			}
			if(plugin.getGateManager().containsKey(name)){
				event.getPlayer().sendMessage("This name already is in use!");
				event.setCancelled(true);
				return;
			}
			
			plugin.registerGate(event.getPlayer(), event.getBlock());
		}
	}

}
