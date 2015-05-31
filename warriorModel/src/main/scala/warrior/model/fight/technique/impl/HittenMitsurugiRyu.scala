package warrior.model.fight.technique.impl

import warrior.model.fight.technique.action.Atack
import warrior.model.fight.technique.style.SwordStyle
import warrior.model.fight.technique.{Dan, Technique}
import warrior.model.item.weapon.WarriorWeapon
import warrior.model.item.weapon.sword.Sword

/**
 * * Created by rds on 11/05/15.
 */

abstract class HittenMitsurugiRyu extends Technique with SwordStyle {
  val name = "Hitten Mitsurugi Ryu"
  val maxDan = Dan.dix

  def bonusMalus(warriorWeapon: WarriorWeapon) = warriorWeapon match {
    case w: Sword => 1
  }

  val dragonDivin = new Atack("Dragon divin") {
    var str = 10
    var defe = 10
    var coef = 1
    var agi = 10
  }

}