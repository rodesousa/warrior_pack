package warrior.launcher

/**
 * * Created by rds on 16/05/15.
 */
object Test {

  class Event()
  class EventUn() extends Event
  class EventDeux() extends Event
  class EventTrois() extends Event
//
//  def main(args: Array[String]) {
//
//    define(new EventUn)
//
//
//  }


  def define(t : Event): Unit ={
    t match {
      case e:EventUn => println("un")
      case e:EventDeux => println("deux")
      case e:EventTrois => println("trois")
      case e:Event => println("zero")
    }
  }

}
