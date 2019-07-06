package nrk4220.function.privatesquare.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import nrk4220.function.privatesquare.PrivateSquare;

public class InvisibleBlock extends  Block {

    public InvisibleBlock(Material material, String unlocalizedName, String registryName) {
        this(material, SoundType.STONE, unlocalizedName, registryName);
    }

    public InvisibleBlock(Material material, SoundType sound, String unlocalizedName, String registryName) {
        super(material);
        setUnlocalizedName(PrivateSquare.MODID + "." + unlocalizedName);
        setRegistryName(registryName);
        setCreativeTab(PrivateSquare.CREATIVE_TABS);
        setSoundType(sound);
    }
}
