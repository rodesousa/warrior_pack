package warrior.model.fight.menu

/**
  * * Created by rds on 19/05/15.
  */

class MenuFight {
   var technique, fuite: EleMenu = null
   technique = new EleMenu("Technique")
   fuite = new EleMenu("Fuite")

   technique.init(fuite, fuite)
   fuite.init(technique, technique)
 }
