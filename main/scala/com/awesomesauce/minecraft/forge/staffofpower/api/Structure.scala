package com.awesomesauce.minecraft.forge.staffofpower.api

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.world.World
import net.minecraftforge.common.util.ForgeDirection


trait Structure {
  def isUsableOn(stack: ItemStack, player: EntityPlayer): Boolean = true

  def useOnStructure(stack: ItemStack, world: World, x: Int, y: Int, z: Int, side: ForgeDirection, player: EntityPlayer)
}
