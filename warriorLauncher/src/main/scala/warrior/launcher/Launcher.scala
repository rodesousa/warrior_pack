package warrior.launcher

import warrior.controller.ControllerWarrior
import warrior.model.ModelWarrior
import warrior.model.example.Persos
import warrior.view.ViewWarrior

/**
 * * Created by rds on 07/05/15.
 */
object Launcher {
  def main(args: Array[String]) {
    val model = new ModelWarrior
    Persos.PnjTOEvent(model)
    val controller = new ControllerWarrior(model)
    val view = new ViewWarrior(controller)
  }

}
