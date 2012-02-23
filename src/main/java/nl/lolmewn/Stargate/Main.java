package nl.lolmewn.Stargate;

import nl.lolmewn.Stargate.Listeners.Sign_Change;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	private Settings settings = new Settings();
	private GateManager gateManager = new GateManager();
	
	@Override
	public void onDisable() {
		
	}

	@Override
	public void onEnable() {
		
		this.getServer().getPluginManager().registerEvents(new Sign_Change(this), this);
	}
	
	public Settings getSettings(){
		return this.settings;
	}
	
	public GateManager getGateManager(){
		return this.gateManager;
	}

	public void registerGate(Player player, Block block) {
		
	}

}
