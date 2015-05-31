package warrior.view.aspect.fight.menu

import warrior.model.fight.technique.action.ActionFight

/**
 * * Created by rds on 19/05/15.
 */
class ViewEleAction( _action : ActionFight,_x: Int, _y: Int, _parent : ViewEleTechnique) extends ViewEle(_x, _y) {
  val parent = _parent
  val action = _action
}
