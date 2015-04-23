package com.awesomesauce.minecraft.forge.staffofpower.api

import java.util

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack

/**
 * Created by Sandra on 20/04/2015.
 */
object ModeRegistry {
  val modeList = new util.ArrayList[Mode]()

  def registerMode(mode: Mode) = {
    modeList.add(mode)
    mode.number = modeList.indexOf(mode)
  }

  def getNextMode(stack: ItemStack, player: EntityPlayer, mode: Mode): Mode = {
    val i = mode.number
    for (k <- Range(i + 1, modeList.size))
      if (modeList.get(k).canUseOn(stack, player)) {
        return modeList.get(k)
      }
    for (k <- Range(0, modeList.size)) {
      if (modeList.get(k).canUseOn(stack, player)) {
        return modeList.get(k)
      }
    }
    modeList.get(0)
  }
}
