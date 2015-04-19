package com.awesomesauce.minecraft.forge.staffofpower

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.{ItemStack, Item}
import net.minecraft.util.EnumChatFormatting

class ItemAwesomeiteStaff extends Item {
  override def addInformation(stack:ItemStack, player:EntityPlayer, list:java.util.List[_], bool:Boolean) = {
    super.addInformation(stack, player, list, bool)
    val nlist = list.asInstanceOf[java.util.List[AnyRef]]
    nlist.add(EnumChatFormatting.ITALIC+"Staff of Power.")
    nlist.add(EnumChatFormatting.ITALIC+"Right click to look at.")
  }
}
