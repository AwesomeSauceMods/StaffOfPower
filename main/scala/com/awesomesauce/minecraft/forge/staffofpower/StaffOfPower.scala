package com.awesomesauce.minecraft.forge.staffofpower

import com.awesomesauce.minecraft.forge.core.lib.TAwesomeSauceMod
import com.awesomesauce.minecraft.forge.core.lib.util.ItemUtil
import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.event.{FMLPostInitializationEvent, FMLInitializationEvent, FMLPreInitializationEvent}
import net.minecraft.item.Item

/**
 * Created by Sandra on 19/04/2015.
 */
@Mod(modid = StaffOfPower.MODID, name = StaffOfPower.MODNAME, modLanguage = "scala")
object StaffOfPower extends TAwesomeSauceMod {
  final val MODID = "StaffOfPower"
  final val MODNAME = "Staff Of Power"
  def getModID = MODID
  def getModName = MODNAME
  var awesomeiteStaff : Item = null
  def getTabIconItem = () => awesomeiteStaff
  @EventHandler
  def aspri(e: FMLPreInitializationEvent) = awesomesaucepreinit(e)
  @EventHandler
  def asi(e: FMLInitializationEvent) = awesomesauceinit(e)
  @EventHandler
  def aspoi(e: FMLPostInitializationEvent) = awesomesaucepostinit(e)

  def preInit(): Unit = {
    awesomeiteStaff = ItemUtil.makeItem(this, "awesomeiteStaff", new ItemAwesomeiteStaff)
  }
  def init() = {

  }
  def postInit() = {

  }
}
