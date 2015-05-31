package warrior.view.aspect.perso

import standard.model.Model
import standard.resource.Variables._
import warrior.model.perso.CharacterFighter

/**
 * * Created by rds on 07/05/15.
 */
class ViewPersoWarrior(_perso: CharacterFighter) {
  val faceImg1 = _perso.info.folder + "face1.jpg"
  val faceImg2 = _perso.info.folder + "face2.jpg"
  val faceImg3 = _perso.info.folder + "face3.jpg"

  val dosImg1 = _perso.info.folder + "dos1.jpg"
  val dosImg2 = _perso.info.folder + "dos2.jpg"
  val dosImg3 = _perso.info.folder + "dos3.jpg"

  val droiteImg1 = _perso.info.folder + "droite1.jpg"
  val droiteImg2 = _perso.info.folder + "droite2.jpg"
  val droiteImg3 = _perso.info.folder + "droite3.jpg"

  val gaucheImg1 = _perso.info.folder + "gauche1.jpg"
  val gaucheImg2 = _perso.info.folder + "gauche2.jpg"
  val gaucheImg3 = _perso.info.folder + "gauche3.jpg"

  var currentDirection = DIRECTION_UP
  var currentDirectionEtape = faceImg1

  def nextImg(model: Model) = {
    if (currentDirection == _perso.directionCurrent)
      nextEtape()
    else {
      currentDirection = _perso.directionCurrent
      initialDirection()
    }
  }

  private def nextEtape() = currentDirectionEtape match {
    case `faceImg1` => currentDirectionEtape = faceImg2
    case `faceImg2` => currentDirectionEtape = faceImg3
    case `faceImg3` => currentDirectionEtape = faceImg2

    case `dosImg1` => currentDirectionEtape = dosImg2
    case `dosImg2` => currentDirectionEtape = dosImg3
    case `dosImg3` => currentDirectionEtape = dosImg2

    case `droiteImg1` => currentDirectionEtape = droiteImg2
    case `droiteImg2` => currentDirectionEtape = droiteImg3
    case `droiteImg3` => currentDirectionEtape = droiteImg2

    case `gaucheImg1` => currentDirectionEtape = gaucheImg2
    case `gaucheImg2` => currentDirectionEtape = gaucheImg3
    case `gaucheImg3` => currentDirectionEtape = gaucheImg2
  }

  private def initialDirection() = perso.directionCurrent match {
    case `DIRECTION_UP` => currentDirectionEtape = dosImg1
    case `DIRECTION_DOWN` => currentDirectionEtape = faceImg1
    case `DIRECTION_RIGHT` => currentDirectionEtape = droiteImg1
    case `DIRECTION_LEFT` => currentDirectionEtape = gaucheImg1
  }

  def perso = _perso
}
