package warrior.model.fight.menu

import warrior.model.fight.technique.action.ActionFight

/**
 * * Created by rds on 19/05/15.
 */
class EleAction(_action: ActionFight, _parent: EleTechnique) extends Ele {
  def parent = _parent

  def action = _action
}
