package warrior.model.fight

import standard.model.fight.Fighter
import warrior.model.fight.technique.Technique
import warrior.model.item.weapon.WarriorWeapon

/**
 * * Created by rds on 20/05/15.
 */
trait FighterWarrior extends Fighter {
  def techniquesCombat: List[Technique]
  def arme: WarriorWeapon
}
