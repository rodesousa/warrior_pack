package warrior.model.fight

import standard.resource.Variables._
import warrior.model.ModelWarrior
import warrior.model.fight.technique.action.ActionFight
import warrior.model.perso.CharacterFighter

/**
 * * Created by rds on 11/05/15.
 */
object CombatWarrior {

  def fight(atacker: CharacterFighter, defenser: CharacterFighter,
            model: ModelWarrior, action: ActionFight) {
    if (DEBUG)
      println("FIGHT !")
    //    val maxRange = math.max((atacker.x - defenser.x) / atacker.pas, (atacker.y - defenser.y) / atacker.pas)
    val maxRange = 0
    if (DEBUG)
      println("Range des persos:  " + maxRange)
    if (DEBUG)
      println("Atack touche ?" + (atacker.techniquesCombat.head.listAtk.head._2.range._1 >= maxRange))
    if (DEBUG)
      println("Def touche ?" + (defenser.techniquesCombat.head.listAtk.head._2.range._1 >= maxRange))
    if (atacker.techniquesCombat.head.listAtk.head._2.range._1 >= maxRange) {
      defenser.hpCurrent -= atacker.atack(action)
      if (DEBUG)
        println(s" L'attaque de l'atacker: ${atacker.atack(action)}")
    }
    if (!atacker.die) {
      if (defenser.techniquesCombat.head.listAtk.head._2.range._1 >= maxRange) {
        //TODO resoudre l'attaque du défenseur
        atacker.hpCurrent -= defenser.atack(defenser.techniquesCombat.head.listAtk.head._2)
        if (DEBUG)
          println(s" L'attaque du defenser: ${defenser.atack(action)}")
      }
    }
  }
}
