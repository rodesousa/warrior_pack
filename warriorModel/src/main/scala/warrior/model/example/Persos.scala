package warrior.model.example

import standard.model.event.action.{EventDialogue, EventFight}
import standard.model.event.{Event, EventAction, HaveEvent}
import standard.model.map.cellule.Cellule
import standard.resource.Variables._
import warrior.model.ModelWarrior
import warrior.model.fight.technique.action.ActionFight
import warrior.model.fight.technique.impl.{HittenMitsurugiRyu, SwordBase}
import warrior.model.item.weapon.sword.SwordStandard
import warrior.model.perso.CharacterFighter
import warrior.resource.Variables._

/**
 * * Created by rds on 21/05/15.
 */
object Persos {

  def createPersoPri = {
    new CharacterFighter(PERSONNAGE_NAME) {
      info.name = "Kenshin"
      var str = 10
      var defe = 10
      var agi = 10
      hpMax = 100
      vit = 10
      val ryu = new HittenMitsurugiRyu {
        val listAtk: List[(Boolean, ActionFight)] = (true, dragonDivin) :: Nil
      }
      val base: SwordBase = new SwordBase {
        val listAtk = (true, atack) :: Nil
      }
      var techniquesCombat = ryu :: base :: Nil
      var arme = new SwordStandard
    }
  }

  def createPersos = {
    val p2 = new CharacterFighter(PERSONNAGE_NAME) {
      info.name = "Pooman"
      var str = 5
      var defe = 5
      var agi = 5
      hpMax = 50
      vit = 5
      val base: SwordBase = new SwordBase {
        val listAtk = (true, atack) :: Nil
      }
      var techniquesCombat = base :: Nil
      var arme = new SwordStandard
    }
    createPersoPri :: p2 :: Nil
  }

  def createPNJ: CharacterFighter with HaveEvent = {
    new CharacterFighter(PERSONNAGE_NAME) with HaveEvent {
      info.name = "Pooman"
      var str = 5
      var defe = 5
      var agi = 5
      hpMax = 50
      vit = 5
      hpCurrent = hpMax
      val base: SwordBase = new SwordBase {
        val listAtk = (true, atack) :: Nil
      }
      var techniquesCombat = base :: Nil
      var arme = new SwordStandard
      current = new EventDialogue {
        var text = "Halte la PD ! Combattons comme de jeune pucelle !"
        var subject = "Bastien la fiotte"
        val list = listDialogue
      }
      next = new Event {
        current = new EventFight {
          var list = listFight
        }
        var current: EventAction = null
        var next: Event = null
      }
    }
  }

  def PnjTOEvent(model: ModelWarrior) {
    val pnj = createPNJ
    val cellule = new Cellule(510, 75) {
      event = pnj
    }
    model.currentMap.cellules = cellule :: model.currentMap.cellules
  }
}