package com.awesomesauce.minecraft.forge.staffofpower

import com.awesomesauce.minecraft.forge.core.lib.util.PlayerUtil
import com.awesomesauce.minecraft.forge.staffofpower.api.{Mode, ModeRegistry}
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.util.EnumChatFormatting
import net.minecraft.world.World

class ItemAwesomeiteStaff extends Item {
  override def addInformation(stack:ItemStack, player:EntityPlayer, list:java.util.List[_], bool:Boolean) = {
    super.addInformation(stack, player, list, bool)
    initializeStack(stack)
    val nlist = list.asInstanceOf[java.util.List[AnyRef]]
    nlist.add(EnumChatFormatting.ITALIC+"Staff of Power.")
    nlist.add(EnumChatFormatting.ITALIC+"Right click to look at.")
  }

  def initializeStack(stack: ItemStack) = {
    if (!stack.hasTagCompound)
      stack.setTagCompound(new NBTTagCompound)
    if (!stack.getTagCompound.hasKey("mode")) {
      stack.getTagCompound.setInteger("mode", 0)
    }
  }

  override def onItemRightClick(stack: ItemStack, world: World, player: EntityPlayer): ItemStack = {
    initializeStack(stack)
    if (player.isSneaking) {
      cycleMode(stack, player)
      return stack
    }
    getMode(stack).useInMidair(stack, world, player)
    stack
  }

  def cycleMode(stack: ItemStack, player: EntityPlayer) = {
    val mode: Mode = ModeRegistry.getNextMode(stack, player, getMode(stack))
    stack.getTagCompound.setInteger("mode", mode.number)
    PlayerUtil.sendChatMessage(player, "Mode set to: " + mode.getName)
    PlayerUtil.sendChatMessage(player, mode.getDescription)
  }

  def getMode(stack: ItemStack): Mode = {
    ModeRegistry.list.get(stack.getTagCompound.getInteger("mode"))
  }

}
