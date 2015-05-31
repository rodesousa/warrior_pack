package warrior.view.aspect.fight.menu

import warrior.model.fight.technique.Technique

/**
 * * Created by rds on 19/05/15.
 */
class ViewEleTechnique(_tech : Technique,_x: Int, _y: Int, _parent: ViewEleMenu) extends ViewEle(_x, _y) {
  val parent = _parent
  val tech = _tech
}
