package warrior.model.fight.technique

import warrior.model.fight.technique.Dan.dan
import warrior.model.fight.technique.action.ActionFight
import warrior.model.fight.technique.style.FightStyle
import warrior.model.item.weapon.WarriorWeapon

/**
 * * Created by rds on 09/05/15.
 */

case object Dan extends Enumeration {
  type dan = Value
  val un, deux, trois, quatre, cinq, six, sept, huit, neuf, dix = Value
}

trait Technique extends FightStyle {
  def name: String

  var dan = Dan.un

  def maxDan: dan

  def listAtk: List[(Boolean, ActionFight)]

  def bonusMalus(warriorWeapon: WarriorWeapon): Int
}
