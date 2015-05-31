package warrior.model

import standard.model.Model
import standard.model.perso.Personnage
import warrior.model.map.MapWarrior
import warrior.resource.Variables._
import warrior.model.example.Persos
import scala.collection.immutable.HashMap

/**
 * * Created by rds on 07/05/15.
 */
class ModelWarrior extends Model {
  var currentMap = new MapWarrior(MAP_NAME)
  var currentPerso = Persos.createPersoPri

  def etatMaps = null

  def etatCompagnons: HashMap[String, Personnage] = null
}
