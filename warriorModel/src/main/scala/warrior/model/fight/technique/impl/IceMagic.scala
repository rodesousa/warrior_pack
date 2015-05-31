package warrior.model.fight.technique.impl

import warrior.model.fight.technique.action.Atack
import warrior.model.fight.technique.style.{MagicStyle, AxeStyle}
import warrior.model.fight.technique.{Dan, Technique}
import warrior.model.item.weapon.WarriorWeapon
import warrior.model.item.weapon.axe.Axe

/**
 * * Created by rds on 22/05/15.
 */
abstract class IceMagic extends Technique with MagicStyle {
  val name = "hache mercenaire"
  val maxDan = Dan.deux

  //TODO jeu de test
  def bonusMalus(warriorWeapon: WarriorWeapon) = warriorWeapon match {
    case w: Axe => 1
  }

  //TODO Refaire les stats
  val base = new Atack("Ataque base") {
    var str = 10
    var defe = 7
    var agi = 10
    var coef = 1
  }

}
