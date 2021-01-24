import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import net.md_5.bungee.api.ChatColor;

public class TNTCartListener implements Listener
{
	private Main plugin;
	
	public TNTCartListener(Main plugin)
	{
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onRightClick(PlayerInteractEvent e)
	{
		//op Altantic_Salmon
		if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)
				&& (e.getClickedBlock().getType().equals(Material.RAIL) || e.getClickedBlock().getType().equals(Material.ACTIVATOR_RAIL) || e.getClickedBlock().getType().equals(Material.DETECTOR_RAIL) || e.getClickedBlock().getType().equals(Material.POWERED_RAIL))
				&& e.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.TNT_MINECART)
				&& !e.getPlayer().hasPermission("tntcart.place"))
		{
			e.getPlayer().sendMessage(format(plugin.getConfig().getString("permission_denied")));
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onDispenser(BlockDispenseEvent e)
	{
		if(e.getItem().getType().equals(Material.TNT_MINECART))
			e.setCancelled(true);
	}
	
	public String format(String message)
	{
		return ChatColor.translateAlternateColorCodes('&', message);
	}
}
