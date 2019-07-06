package nrk4220.function.privatesquare;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent;
import nrk4220.function.privatesquare.initialize.InitializeItem;
import nrk4220.function.privatesquare.proxy.CommonProxy;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = PrivateSquare.MODID, name = PrivateSquare.NAME, version = PrivateSquare.VERSION)
public class PrivateSquare
{
    public static final String MODID = "privatesquare";
    public static final String NAME = "Private Square";
    public static final String VERSION = "0.1";

    @SidedProxy(clientSide = "nrk4220.function.privatesquare.proxy.ClientProxy", serverSide = "nrk4220.function.privatesquare.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    private static PrivateSquare privateSquare;
    private static Logger logger;

    public static final CreativeTabs CREATIVE_TABS = new CreativeTabs("Private Square") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(InitializeItem.POCKET_WATCH);
        }
    };

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
        proxy.init(event);
        MinecraftForge.EVENT_BUS.register(StopEntity.class);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}
