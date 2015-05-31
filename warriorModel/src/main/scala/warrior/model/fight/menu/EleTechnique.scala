package warrior.model.fight.menu

import warrior.model.fight.technique.Technique

/**
 * * Created by rds on 19/05/15.
 */
class EleTechnique(_tech: Technique, _parent: EleMenu) extends Ele {
  def tech = _tech

  def parent: EleMenu = _parent
}
