package com.awesomesauce.minecraft.forge.staffofpower.api

import java.util

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack

/**
 * Created by Sandra on 20/04/2015.
 */
object ModeRegistry {
  val list: util.ArrayList[Mode] = new util.ArrayList[Mode]()

  def registerMode(mode: Mode) = {
    list.add(mode)
    mode.number = list.indexOf(mode)
  }

  def getNextMode(stack: ItemStack, player: EntityPlayer, mode: Mode): Mode = {
    val i = mode.number
    for (k <- Range(i + 1, list.size))
      if (list.get(k).canUseOn(stack, player)) {
        return list.get(k)
      }
    for (k <- Range(0, list.size)) {
      if (list.get(k).canUseOn(stack, player)) {
        return list.get(k)
      }
    }
    list.get(0)
  }
}
