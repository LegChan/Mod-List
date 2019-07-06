package nrk4220.function.privatesquare.utility;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import nrk4220.function.privatesquare.initialize.InitializeBlock;
import nrk4220.function.privatesquare.initialize.InitializeItem;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ModelRegistryHandler {
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        registerModel(InitializeItem.POCKET_WATCH);
        registerModel(Item.getItemFromBlock(InitializeBlock.INVISIBLE_BLOCK));
    }
    private static void registerModel(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

}
