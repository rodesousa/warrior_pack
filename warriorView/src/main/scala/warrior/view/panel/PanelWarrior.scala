package warrior.view.panel

import java.awt.{Color, Font, Graphics}
import java.io.File
import javax.imageio.ImageIO
import javax.swing.JPanel

import standard.resource.Variables._
import standard.view.swing.perso.ViewPersoEditor
import warrior.model.ModelWarrior

/**
 * * Created by rds on 07/05/15.
 */
class PanelWarrior(model: ModelWarrior) extends JPanel {
  var viewPerso = new ViewPersoEditor(model.currentPerso)

  override def paintComponent(g: Graphics) {
    viewPerso.nextImg(model)

    g.drawImage(ImageIO.read(new File(model.currentMap.img)), 0, 0, this)

    g.drawImage(ImageIO.read(new File(viewPerso.currentDirectionEtape)), viewPerso.perso.x, viewPerso.perso.y,
      this)

    if (model.stateGame eq EVENT_DIALOGUE) {
      println("EVENT_DIALOGUE")
      val font = new Font("Courier", Font.BOLD, 20)
      g.setFont(font)
      g.setColor(Color.red)
      g.drawImage(ImageIO.read(new File("/home/rds/workspace/sbt-workspace/test.jpg")),0, 400,680,150, this)
      g.drawString(model.dialogue.subject, 0, 420)
      g.drawString(model.dialogue.text, 0, 480)
    }
  }
}
