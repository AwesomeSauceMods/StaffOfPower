package com.awesomesauce.minecraft.forge.staffofpower.api

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.world.World
import net.minecraftforge.common.util.ForgeDirection

trait Mode {
  var number = 0

  def getName: String

  def getDescription: String

  def useInMidair(stack: ItemStack, world: World, player: EntityPlayer): Boolean = false

  def useOnBlock(stack: ItemStack, world: World, x: Int, y: Int, z: Int, side: ForgeDirection, player: EntityPlayer): Boolean = false

  def canUseOn(stack: ItemStack, player: EntityPlayer): Boolean = true
}
