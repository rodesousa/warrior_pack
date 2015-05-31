package warrior.view.aspect.fight.menu

/**
 * * Created by rds on 19/05/15.
 */

class ViewMenuFight {
  var technique, fuite: ViewEleMenu = null
  technique = new ViewEleMenu("Technique", 125, 450)
  fuite = new ViewEleMenu("Fuite", 125, 475)

  technique.init(fuite, fuite)
  fuite.init(technique, technique)
}
