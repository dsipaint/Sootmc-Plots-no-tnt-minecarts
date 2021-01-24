import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
	public void onEnable()
	{
		this.getServer().getPluginManager().registerEvents(new TNTCartListener(this), this);
	}
	
	public void onDisable()
	{
		
	}
}
