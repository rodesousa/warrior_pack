package warrior.view.listener

import java.awt.event.{KeyEvent, KeyListener, MouseListener}

import standard.resource.Variables._
import warrior.view.ViewWarrior

/**
 * * Created by rds on 11/05/15.
 */
class KeyboardWarrior(view: ViewWarrior) extends KeyListener with MouseListener {
  def controller = view.controller

  def keyPressed(e: KeyEvent) {
    if (DEBUG)
      println("ControllerWarrior lifeAction: " + controller.lifeAction(e.getKeyCode))
    if (controller.lifeAction(e.getKeyCode)) {
      if (e.getKeyCode == KeyEvent.VK_RIGHT || e.getKeyCode == KeyEvent.VK_LEFT ||
        e.getKeyCode == KeyEvent.VK_UP || e.getKeyCode == KeyEvent.VK_DOWN) {
        controller.move(e.getKeyCode.toString)
      }
      else if (e.getKeyCode == KeyEvent.VK_ENTER) {
        if(controller.isFightDone){
          changePanelFightToWarrior()
        }
        else{
        controller.resolveAll()
        if (controller.model.stateGame == EVENT_BEGIN_FIGHT) {
          changePanelWarriorToFight()
        }
        }
      }
      view.panelCurrent.updateUI()
      if (DEBUG)
        println(s"ClavierListenerWarrior: ${controller.model.stateGame}")
    }
  }

  def changePanelWarriorToFight() {
    view.panContentPane.remove(view.panelCurrent)
    view.panContentPane.removeKeyListener(view.keyboardListener)
    view.panelCurrent = view.panelFight
    view.panelCurrent.setFocusable(true)
    view.panelFight.setFocusable(true)
    view.panContentPane.add(view.panelFight)
    view.panContentPane.addKeyListener(view.keyboardFightListener)
    controller.fightBegin()
  }

  def changePanelFightToWarrior() {
    view.panContentPane.remove(view.panelCurrent)
    view.panContentPane.removeKeyListener(view.keyboardFightListener)
    view.panContentPane.addKeyListener(view.keyboardListener)
    view.panelCurrent = view.panelWarrior
    view.panelCurrent.setFocusable(true)
    view.panelFight.setFocusable(true)
    view.panContentPane.add(view.panelWarrior)
    controller.fightDone()
  }

  def mouseClicked(x$1: java.awt.event.MouseEvent) {}

  def keyReleased(e: KeyEvent) {}

  def keyTyped(e: KeyEvent) {}

  def mouseEntered(x$1: java.awt.event.MouseEvent) {}

  def mouseExited(x$1: java.awt.event.MouseEvent) {}

  def mousePressed(x$1: java.awt.event.MouseEvent) {}

  def mouseReleased(x$1: java.awt.event.MouseEvent) {}

}

