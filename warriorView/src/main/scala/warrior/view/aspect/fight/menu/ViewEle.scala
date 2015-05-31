package warrior.view.aspect.fight.menu

/**
 * * Created by rds on 19/05/15.
 */
class ViewEle(_x: Int, _y: Int) {
  var next: ViewEle = null
  var before: ViewEle = null
  var y = _y
  var x = _x

  def init(next: ViewEle, before: ViewEle) {
    this.next = next
    this.before = before
  }

}
