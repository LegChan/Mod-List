package nrk4220.function.privatesquare.item;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import nrk4220.function.privatesquare.PrivateSquare;
import nrk4220.function.privatesquare.StopEntity;


public class PocketWatch extends Item {

    private static int counter = 0;

    public PocketWatch(){}

    public PocketWatch (String unlocalizedName, String registryName) {
        setUnlocalizedName(PrivateSquare.MODID + "." + unlocalizedName);
        setRegistryName(registryName);
        setCreativeTab(PrivateSquare.CREATIVE_TABS);
    }

    /*public void initTexture() {
        ModelLoader.setCustomModelResourceLocation(Item.getByNameOrId("pocket_watch"), 0,
                new ModelResourceLocation(getRegistryName(), "inventory"));
    }*/

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        //Minecraft.getMinecraft().player.sendChatMessage("hello");
        StopEntity.getGameStatistics(worldIn, playerIn);
        if(PocketWatch.getCounter() == 0) {
            StopEntity.setOnOff();
            PocketWatch.setCounter();
        }
        if(StopEntity.getOnOff()){
            Minecraft.getMinecraft().player.sendChatMessage("Time is stopped");
        } else {
            Minecraft.getMinecraft().player.sendChatMessage("Time will move once again");
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    public static int getCounter(){
        return counter;
    }


    private static int setCounter(){
        counter = 360;
        return counter;
    }


    public static int counterCountdown() {
        if (counter > 0) {
            counter = counter - 1;
        }
        return counter;
    }
}
