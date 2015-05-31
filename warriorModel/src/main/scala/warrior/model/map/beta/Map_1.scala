package warrior.model.map.beta

import standard.model.event.HaveEvent
import standard.model.job.SellerJob
import standard.model.perso.Personnage
import warrior.model.fight.technique.Dan
import warrior.model.fight.technique.impl._
import warrior.model.item.weapon.WarriorWeapon
import warrior.model.item.weapon.axe.AxeStandard
import warrior.model.item.weapon.rod.RodStandard
import warrior.model.item.weapon.spear.SpearStandard
import warrior.model.item.weapon.sword.SwordStandard
import warrior.model.map.MapWarrior
import warrior.model.perso.CharacterFighter

/**
 * * Created by rds on 22/05/15.
 */
class Map_1 extends MapWarrior("Map_1_Beta") {
  //TODO Retravailler la class
  val sansNom = new CharacterFighter("chemin") with HaveEvent {
    //TODO refaire les stats
    var str = 50
    var defe = 50
    var agi = 1
    var arme: WarriorWeapon = new AxeStandard
    val pelerin = new FauconPelerin {
      val listAtk = (true, pic) ::(true, rafale) :: Nil
    }
    val death = new DeathStyle {
      val listAtk = (true, lethale) :: Nil
      val maxDan = Dan.un
    }
    var techniquesCombat = pelerin :: death :: Nil
  }

  val characterCamp1 = new CharacterFighter("chemin") {
    var str = 3
    var agi = 3
    var defe = 2
    val arme: WarriorWeapon = new AxeStandard
    val axeMercenary = new AxeMercenary {
      val listAtk = base :: Nil
    }
    var techniquesCombat = axeMercenary :: Nil
  }

  val characterCamp2 = new CharacterFighter("chemin") {
    var str = 3
    var agi = 3
    var defe = 2
    val arme: WarriorWeapon = new SpearStandard
    val spearMercenary = new SpearMercenary {
      val listAtk = base :: Nil
    }
    var techniquesCombat = spearMercenary :: Nil
  }

  val characterCamp3 = new CharacterFighter("chemin") {
    var str = 3
    var agi = 3
    var defe = 2
    val arme: WarriorWeapon = new SwordStandard
    val swordMercenary = new SwordMercenary {
      val listAtk = base :: Nil
    }
    var techniquesCombat = swordMercenary :: Nil
  }

  val characterCamp4 = new Personnage("chemin") {
  }

  val characterCamp5 = new Personnage("chemin") {
  }

  val technicien = new Personnage("chemin") {
  }

  val characterFighter1 = new CharacterFighter("chemin") {
    var str = 3
    var agi = 3
    var defe = 2
    val arme: WarriorWeapon = new SpearStandard
    val spearMercenary = new SpearMercenary {
      val listAtk = base :: Nil
    }
    var techniquesCombat = spearMercenary :: Nil
  }

  val characterFighter2 = new CharacterFighter("chemin") {
    var str = 3
    var agi = 3
    var defe = 2
    val arme: WarriorWeapon = new SwordStandard
    val swordMercenary = new SwordMercenary {
      val listAtk = base :: Nil
    }
    var techniquesCombat = swordMercenary :: Nil
  }

  val compteur = new Personnage("chemin") {
  }

  val romulus = new CharacterFighter("chemin") {
    var str = 3
    var agi = 3
    var defe = 2
    val arme = new RodStandard
    val spearMercenary = new IceMagic {
      val listAtk = base :: Nil
    }
    var techniquesCombat = spearMercenary :: Nil
  }

  val remus = new CharacterFighter("chemin") {
    var str = 3
    var agi = 3
    var defe = 2
    val arme = new RodStandard
    val spearMercenary = new IceMagic {
      val listAtk = base :: Nil
    }
    var techniquesCombat = spearMercenary :: Nil
  }

  val inscripteur = new Personnage("chemin") {
  }

  val characterMerchant = new Personnage("chemin"){}

  val marchandDeplca = new SellerJob(characterMerchant,Nil) {
  }

  val lambda1 = new Personnage("chemin") {
  }

  val lambda2 = new Personnage("chemin") {
  }

  val lambda3 = new Personnage("chemin") {
  }
}
