val output = for {
  i <- 1 to 10
  j <- 1 to 10

  point = (i,j)
} yield point

println(output.toList)
val newOutput = output.foldLeft[List[Int]](List(0,0))((t,c) => {
List(t.head + c._1, t(1) + c._2)
}).map(x => x/output.size)

println(newOutput)
import scala.collection.mutable
var reduceStarter = mutable.MutableList(0,0)
val f = (x:(Int,Int),y:(Int,Int)) => {
  (x._1 + y._1,x._2 + y._2)
}
val reducedOutput = output.reduceLeft[(Int,Int)](f)
println(reducedOutput)

def customPrintln() : Unit = {

  println("Hello task")
}

val myTask = task(customPrintln())