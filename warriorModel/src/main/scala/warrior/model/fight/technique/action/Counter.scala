package warrior.model.fight.technique.action

import standard.model.stat.StatCombat

/**
 * * Created by rds on 12/05/15.
 */
abstract class Counter(_name: String) extends ActionFight(_name) with StatCombat {
  //Bonus de distance ! _1: nbr de case ; _2: additionneur ou multiplicateur
  def range = null
}
