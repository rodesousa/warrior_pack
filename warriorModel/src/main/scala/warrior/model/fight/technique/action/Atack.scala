package warrior.model.fight.technique.action

/**
 * * Created by rds on 12/05/15.
 */
abstract class Atack(_name: String) extends ActionFight(_name) {
  //Bonus de distance ! _1: nbr de case ; _2: additionneur ou multiplicateur
  def range = (0, 0)
}
