package warrior.view

import java.awt.GridLayout
import javax.swing.{JFrame, JPanel}

import standard.view.swing.View
import warrior.controller.ControllerWarrior
import warrior.model.ModelWarrior
import warrior.view.listener.KeyboardWarrior
import warrior.view.panel.{PanelFightWarrior, PanelWarrior}

/**
 * * Created by rds on 07/05/15.
 */
class ViewWarrior(_controller: ControllerWarrior) extends View(_controller) {
  def controller: ControllerWarrior = _controller

  def model: ModelWarrior = _controller.modelWarrior

  val panelWarrior = new PanelWarrior(model)
  var panelFight: PanelFightWarrior = null
  var panelCurrent: JPanel = panelWarrior
  val keyboardListener = new KeyboardWarrior(this)
  val keyboardFightListener = new KeyboardWarrior(this)
  val panContentPane = new JPanel() {
    this.add(panelWarrior)
    this.addKeyListener(keyboardListener)
    this.addMouseListener(keyboardListener)
    this.setFocusable(true)
    this.setLayout(new GridLayout(1, 1))
    this.addKeyListener(keyboardListener)
    this.addMouseListener(keyboardListener)
    this.setFocusable(true)
  }
  this.setTitle("TestJeux")
  this.setSize(800, 600)
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
  this.setContentPane(panContentPane)
  this.setVisible(true)
}
