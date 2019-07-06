package nrk4220.function.privatesquare.utility;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import nrk4220.function.privatesquare.block.InvisibleBlock;
import nrk4220.function.privatesquare.initialize.InitializeBlock;
import nrk4220.function.privatesquare.item.PocketWatch;

@Mod.EventBusSubscriber
public class RegistryHandler {

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        final Block[] blocks = {
                new InvisibleBlock(Material.ROCK, "InvisibleBlock", "invisible_block")
        };
        event.getRegistry().registerAll(blocks);
    }

     @SubscribeEvent
     public static void registerItems(RegistryEvent.Register<Item> event) {
         final Item[] items = {
                 new PocketWatch("PocketWatch", "pocket_watch").setMaxStackSize(1)
         };
         final Item[] itemBlocks = {
                 new ItemBlock(InitializeBlock.INVISIBLE_BLOCK).setRegistryName(InitializeBlock.INVISIBLE_BLOCK.getRegistryName())
         };

         event.getRegistry().registerAll(items);
         event.getRegistry().registerAll(itemBlocks);
        }
 }
