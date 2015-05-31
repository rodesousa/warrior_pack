package warrior.model.fight.technique.impl

import warrior.model.fight.technique.action.Atack
import warrior.model.fight.technique.style.SwordStyle
import warrior.model.fight.technique.{Dan, Technique}
import warrior.model.item.weapon.WarriorWeapon
import warrior.model.item.weapon.sword.Sword

/**
 * * Created by rds on 22/05/15.
 */
abstract class DeathStyle extends Technique with SwordStyle {
  val name = "Death Style"
  val maxDa = Dan.deux

  def bonusMalus(warriorWeapon: WarriorWeapon) = warriorWeapon match {
    case w: Sword => 1
  }

  //TODO Refaire les stats
  val lethale = new Atack("Lethale") {
    var str = 100
    var defe = 75
    var agi = 100
    var coef = 1
  }

}
