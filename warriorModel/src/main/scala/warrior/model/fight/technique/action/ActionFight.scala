package warrior.model.fight.technique.action

import standard.model.stat.StatCombat

/**
 * * Created by rds on 12/05/15.
 */

abstract class ActionFight(_name: String) extends StatCombat {
  //Bonus de distance ! _1: nbr de case ; _2: additionneur ou multiplicateur
  def range: (Int, Int)

  def name = _name
  //les stats sont a val mais du coup!; les atack ou les maitrisse pas du coup on frappe moins fort. Le coef sera la pour ça
  def coef : Int
}
