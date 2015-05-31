package warrior.model.perso

import standard.model.perso.Personnage
import warrior.model.fight.FighterWarrior
import warrior.model.fight.technique.action.ActionFight

/**
 * *  Created by rds on 07/05/15.
 */
abstract class CharacterFighter(_nomFichier: String) extends Personnage(_nomFichier) with FighterWarrior {
  def atack(actionFight: ActionFight): Int = {
    //TODO Satisfaisant pour l'instant
    str + actionFight.str + arme.str
  }

  def defenseBody: Int = {
    //TODO a refaire
    defe
  }

  def defense(actionFight: ActionFight): Int = {
    //TODO Satisfaisant pour l'instant
    defe + actionFight.defe + arme.defe
  }
}
