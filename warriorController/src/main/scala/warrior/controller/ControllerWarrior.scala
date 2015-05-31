package warrior.controller

import standard.controller.Controller
import standard.model.event.action.{EventDialogue, EventFight}
import standard.model.event.{HaveEvent, StructEvent}
import standard.model.map.cellule.Cellule
import standard.resource.Variables._
import warrior.controller.fight.ControllerFight
import warrior.model.ModelWarrior
import warrior.model.fight.ModelFight
import warrior.model.perso.CharacterFighter

import scala.annotation.tailrec
import scala.collection.mutable

/**
 * * Created by rds on 07/05/15.
 */

class ControllerWarrior(_modelWarrior: ModelWarrior) extends Controller(_modelWarrior) {
  val pipeEvent = new StructEvent
  var controllerFight: ControllerFight = null
  val arrayResolveEvent = new mutable.HashMap[HaveEvent, Int]

  def isFightDone: Boolean = modelWarrior.stateGame == EVENT_FIGHT_DONE

  def modelWarrior: ModelWarrior = _modelWarrior

  def initControllerFight() {
    val defenser = pipeEvent.haveEvent match {
      case e: CharacterFighter => e
    }
    controllerFight = new ControllerFight(this, new ModelFight(modelWarrior.currentPerso, defenser))
  }

  def removeControllerFight() {
    controllerFight = null
  }

  override def move(indication: String) {
    if (_modelWarrior.stateGame != EVENT_FIGHT)
      _modelWarrior.stateGame = EVENT_DEPLACEMENT
    _modelWarrior.currentPerso canDo(_modelWarrior, indication)
  }

  def lifeAction(key: Int): Boolean = _modelWarrior.stateGame match {
    case EVENT_DEPLACEMENT => listDeplacement.filter(_ == key).nonEmpty
    case EVENT_DIALOGUE => listDialogue.filter(_ == key).nonEmpty
    case EVENT_NONE => true
    case EVENT_FIGHT | EVENT_FIGHT_DONE => listFight.filter(_ == key).nonEmpty
    case _ => false
  }

  //On regarde si dans la case en face du celle du perso current, il y a un event. Si oui on l'ajoute
  private def addEvent(): Cellule = {
    @tailrec
    def itrZoneWalking(list: List[Cellule], firstCondition: Int, secondCondition: Int): Cellule = {
      list match {
        case head :: tail =>
          if (firstCondition >= head.x &&
            secondCondition >= head.y) head
          else itrZoneWalking(tail, firstCondition, secondCondition)
        case _ => null
      }
    }
    //On regarde si le prochain move (qui depent de directionCurrent) à dans la cellule un event
    val cellules = _modelWarrior.currentMap.cellules
    _modelWarrior.currentPerso.directionCurrent match {
      case DIRECTION_LEFT => itrZoneWalking(cellules, _modelWarrior.currentPerso.x + (_modelWarrior.currentPerso.pas * -1),
        _modelWarrior.currentPerso.y)
      case DIRECTION_RIGHT => itrZoneWalking(cellules, _modelWarrior.currentPerso.x + (_modelWarrior.currentPerso.pas * 1),
        _modelWarrior.currentPerso.y)
      case DIRECTION_UP => itrZoneWalking(cellules, _modelWarrior.currentPerso.x,
        _modelWarrior.currentPerso.y + (_modelWarrior.currentPerso.pas * -1))
      case DIRECTION_DOWN => itrZoneWalking(cellules, _modelWarrior.currentPerso.x,
        _modelWarrior.currentPerso.y + (_modelWarrior.currentPerso.pas * 1))
    }
  }

  //resouds les fights
  private def resolveFight(e: EventFight): String = {
    val defenser = pipeEvent.haveEvent match {
      case e: CharacterFighter => e
    }
    controllerFight = new ControllerFight(this, new ModelFight(modelWarrior.currentPerso, defenser))
    EVENT_BEGIN_FIGHT
  }

  //resoud les dialogues
  private def resolveDialogue(e: EventDialogue): String = {
    _modelWarrior.dialogue.subject = e.subject
    _modelWarrior.dialogue.text = e.text
    EVENT_DIALOGUE
  }

  private def resolveEvent(): String = pipeEvent.haveEvent.current match {
    case e: EventDialogue => resolveDialogue(e)
    case e: EventFight => resolveFight(e)
  }

  //On regarde si il y a un next, si il y a il prend la place du current
  def nextEvent() = {
    if (pipeEvent != null)
      if (pipeEvent.haveEvent.next != null) {
        pipeEvent.haveEvent.current = pipeEvent.haveEvent.next.current
        if (pipeEvent.haveEvent.next.next != null)
          pipeEvent.haveEvent.next = pipeEvent.haveEvent.next.next
      }
      else
        pipeEvent.haveEvent = null
  }

  //RESOLUTION ENTIERE DES EVENTS
  def resolveAll() = {
    if (_modelWarrior.stateGame == EVENT_FIGHT_DONE)
      _modelWarrior.stateGame = EVENT_NONE
    //Partie pour tout event autre que le combat
    if (_modelWarrior.stateGame == EVENT_NONE || _modelWarrior.stateGame == EVENT_DEPLACEMENT) {
      if (DEBUG)
        println("ControllerWarrior: ADD EVENT")
      val cel = addEvent()
      //Ajout d'un event
      if (cel != null && cel.event != null)
        pipeEvent.haveEvent = cel.event
    }
    if (pipeEvent.haveEvent != null) {
      if (DEBUG) {
        println("ControllerWarrior: RESOLVE EVENT")
        println(s"haveEvent: ${pipeEvent.haveEvent} current: ${pipeEvent.haveEvent.current}")
      }
      //resolution de l'event current
      _modelWarrior.stateGame = resolveEvent()
      //on met en place l'event suivant... si il y en a
      nextEvent()
    }
    else
      _modelWarrior.stateGame = EVENT_NONE
  }
}
