package nrk4220.function.privatesquare;

import net.minecraft.block.BlockFalling;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import nrk4220.function.privatesquare.item.PocketWatch;

import java.util.List;

public class StopEntity {

    public StopEntity(){}

    private static LivingEvent.LivingUpdateEvent mobEvent;
    private static World world;
    private static EntityPlayer player;
    private static boolean onOff = false;

    @SubscribeEvent
    public static LivingEvent.LivingUpdateEvent checkEvent(LivingEvent.LivingUpdateEvent event) {
        mobEvent = event;
        if(onOff) {
            //System.out.println("onOff = true");
            StopEntity.stopUpdating();
        } else {
            if(mobEvent.getEntityLiving().hasNoGravity()){
                mobEvent.getEntityLiving().setNoGravity(false);
            }
            if(!(mobEvent.getEntity() instanceof EntityPlayerMP) && !(mobEvent.getEntity() instanceof EntityPlayerSP)) {
                try {
                    EntityLiving entityLiving = (EntityLiving) mobEvent.getEntity();
                    entityLiving.setNoAI(false);
                } catch (Exception e) {
                    System.out.println("ClassCastException threw");
                }
            }
        }
        if(PocketWatch.getCounter() != 0){
            PocketWatch.counterCountdown();
        }
        return mobEvent;
    }

    private static void stopUpdating() {
        if (!(mobEvent.getEntityLiving() instanceof  EntityPlayer) && !(mobEvent.getEntity() instanceof  EntityPlayer) &&
                !mobEvent.isCanceled())
        {
            /*if(mobEvent.getEntity() instanceof EntityFallingBlock){
                BlockPos blockPos = new BlockPos(mobEvent.getEntity().getPosition().getX(),
                        (mobEvent.getEntity().getPosition().getY()-1),
                        mobEvent.getEntity().getPosition().getZ());
                world.setBlockState(blockPos, )
            }*/
            world.setWorldTime(world.getWorldTime());
            //mobEvent.setCanceled(true);
            mobEvent.getEntityLiving().setLastAttackedEntity(null);
            mobEvent.getEntity().setVelocity(0, 0, 0);
            if(mobEvent.getEntity().posX != mobEvent.getEntity().prevPosX
                    || mobEvent.getEntity().posY != mobEvent.getEntity().prevPosY
                    || mobEvent.getEntity().posZ != mobEvent.getEntity().prevPosZ) {
                mobEvent.getEntity().setPositionAndUpdate(mobEvent.getEntity().prevPosX,
                        mobEvent.getEntity().prevPosY, mobEvent.getEntity().prevPosZ);
            }
            if(mobEvent.getEntity().isAirBorne){
                mobEvent.getEntity().setNoGravity(true);
            }
            EntityLiving entityLiving = (EntityLiving) mobEvent.getEntity();
            entityLiving.setNoAI(true);
            mobEvent.getEntity().setPosition(mobEvent.getEntity().getPosition().getX(),
                    mobEvent.getEntity().getPosition().getY(), mobEvent.getEntity().getPosition().getZ());
        }
    }

    public static void getGameStatistics(World worldIn, EntityPlayer playerIn) {
        world = worldIn;
        player = playerIn;
    }

    public static void setOnOff() {
        if(!onOff){
            onOff = true;
        } else {
            onOff = false;
        }
    }

    public static boolean getOnOff(){
        return onOff;
    }
}
