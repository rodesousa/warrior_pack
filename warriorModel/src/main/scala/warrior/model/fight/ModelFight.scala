package warrior.model.fight

import warrior.model.fight.menu._
import warrior.model.perso.CharacterFighter

/**
 * * Created by rds on 21/05/15.
 */
class ModelFight(_atacker: CharacterFighter, _defenser: CharacterFighter) {
  val modelMenu = new MenuFight
  var stateEleMenu: Ele = modelMenu.technique

  def atacker = _atacker

  def defenser = _defenser

  //TODO peut être val
  var listTechnique: List[EleTechnique] = atacker.techniquesCombat.map(e => new EleTechnique(e, modelMenu.technique))
  goodNeighbours(listTechnique)

  def goodNeighbours(list: List[Ele]) {
    if (list.size == 1) {
      list.head.next = list.head
      list.head.before = list.head
    }
    else if (list.size == 2) {
      list.head.next = list(1)
      list.head.before = list(1)
      list(1).next = list.head
      list(1).before = list.head
    } else {
      list.head.next = list(1)
      list.head.before = list(2)
      list(1).next = list(2)
      list(1).before = list.head
      list(2).next = list.head
      list(2).before = list(1)
    }
  }

  var listAction: List[EleAction] = Nil

  def addActions(ele: EleTechnique) {
    listAction = ele.tech.listAtk.filter(e => e._1).map(e => new EleAction(e._2, ele))
    goodNeighbours(listAction)
  }

}
