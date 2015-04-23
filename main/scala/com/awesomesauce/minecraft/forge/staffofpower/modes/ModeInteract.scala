package com.awesomesauce.minecraft.forge.staffofpower.modes

import com.awesomesauce.minecraft.forge.staffofpower.api.Mode
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.world.World
import net.minecraftforge.common.util.ForgeDirection

/**
 * Created by Sandra on 20/04/2015.
 */
object ModeInteract extends Mode {
  def getName = "Interact"

  def getDescription = "Right click to interact with things."

  override def useOnBlock(stack: ItemStack, world: World, x: Int, y: Int, z: Int, side: ForgeDirection, player: EntityPlayer): Boolean = {
    for
  }
}
