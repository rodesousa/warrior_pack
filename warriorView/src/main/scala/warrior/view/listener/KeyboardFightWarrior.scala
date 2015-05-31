package warrior.view.listener

import java.awt.event.{KeyEvent, KeyListener, MouseEvent, MouseListener}

import warrior.controller.fight.ControllerFight
import warrior.view.ViewWarrior

/**
 * * Created by rds on 22/05/15.
 */
class KeyboardFightWarrior(view: ViewWarrior, controllerFight: ControllerFight) extends KeyListener with MouseListener {
  def controller = view.controller

  def keyPressed(keyEvent: KeyEvent) {
    if (controller.lifeAction(keyEvent.getKeyCode)) {
      if (keyEvent.getKeyCode == KeyEvent.VK_RIGHT || keyEvent.getKeyCode == KeyEvent.VK_LEFT ||
        keyEvent.getKeyCode == KeyEvent.VK_UP || keyEvent.getKeyCode == KeyEvent.VK_DOWN) {
        controller.move(keyEvent.getKeyCode.toString)
      }
    } else if (keyEvent.getKeyCode == KeyEvent.VK_ENTER) {
      controller.resolveAll()
      if (controller.isFightDone) {
        view.panContentPane.removeKeyListener(view.keyboardFightListener)
        view.panContentPane.addKeyListener(view.keyboardListener)
      }
    }
  }

  def keyTyped(keyEvent: KeyEvent) {}

  def keyReleased(keyEvent: KeyEvent) {}

  def mouseExited(mouseEvent: MouseEvent) {}

  def mouseClicked(mouseEvent: MouseEvent) {}

  def mouseEntered(mouseEvent: MouseEvent) {}

  def mousePressed(mouseEvent: MouseEvent) {}

  def mouseReleased(mouseEvent: MouseEvent) {}


}
