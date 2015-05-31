package warrior.view.panel

import java.awt.{Color, Font, Graphics}
import java.io.File
import javax.imageio.ImageIO
import javax.swing.JPanel

import warrior.model.ModelWarrior
import warrior.view.aspect.fight.ViewModelFight

/**
 * * Created by rds on 18/05/15.
 */
class PanelFightWarrior(viewModelFight: ViewModelFight, modelWarrior: ModelWarrior) extends JPanel {
  def modelFight = viewModelFight.modelFight

  override def paintComponent(g: Graphics) {
    g.drawImage(ImageIO.read(new File("/home/rds/workspace/sbt-workspace/test.jpg")), 0, 0, this)
    g.drawImage(ImageIO.read(new File(viewModelFight.mapfight)), 120, 200, this)

    val font = new Font("Courier", Font.BOLD, 20)
    g.setFont(font)
    g.setColor(Color.red)

    g.drawString(modelFight.atacker.info.name, 130, 230)
    g.drawString(s"${modelFight.atacker.hpCurrent} / ${modelFight.atacker.hpMax}", 130, 255)

    g.drawString(modelFight.defenser.info.name, 500, 230)
    g.drawString(s"${modelFight.defenser.hpCurrent} / ${modelFight.defenser.hpMax}", 500, 255)

    g.drawImage(ImageIO.read(new File(viewModelFight.curseurMenu.path)), viewModelFight.curseurMenu.ele.x,
      viewModelFight.curseurMenu.ele.y - viewModelFight.curseurMenu.difToPlace, this)
    g.drawString(viewModelFight.menu.technique.name, viewModelFight.menu.technique.x, viewModelFight.menu.technique.y)
    g.drawString(viewModelFight.menu.fuite.name, viewModelFight.menu.fuite.x, viewModelFight.menu.fuite.y)

    if ((viewModelFight.curseurCurrent eq viewModelFight.curseurTechnique) || (viewModelFight.curseurCurrent eq viewModelFight.curseurAction)) {
      g.drawImage(ImageIO.read(new File(viewModelFight.curseurTechnique.path)), viewModelFight.curseurTechnique.ele.x,
        viewModelFight.curseurTechnique.ele.y - viewModelFight.curseurTechnique.difToPlace, this)
      viewModelFight.listTechnique.foreach(e => g.drawString(e.tech.name, e.x, e.y))
    }

    if (viewModelFight.curseurCurrent eq viewModelFight.curseurAction) {
      g.drawImage(ImageIO.read(new File(viewModelFight.curseurAction.path)), viewModelFight.curseurAction.ele.x, viewModelFight.curseurAction.ele.y - viewModelFight.curseurAction.difToPlace, this)
      viewModelFight.listAction.foreach(e => g.drawString(e.action.name, e.x, e.y))
    }
  }
}
