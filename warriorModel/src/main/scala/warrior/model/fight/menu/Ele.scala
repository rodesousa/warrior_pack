package warrior.model.fight.menu

/**
  * * Created by rds on 19/05/15.
  */
class Ele{
 var next: Ele = null
 var before: Ele = null

 def init(next: Ele, before: Ele) {
  this.next = next
  this.before = before
 }

}