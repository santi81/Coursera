/*val output = for {
  i <- 1 to 10
  j <- 1 to 10
  point = (i,j)
} yield point
println(output.toList)
val newOutput = output.foldLeft[List[Int]](List(0,0))((t,c) => {
List(t.head + c._1, t(1) + c._2)
}).map(x => x/output.size)
println(newOutput)*/



/*var reduceStarter = mutable.MutableList(0,0)
val f = (x:(Int,Int),y:(Int,Int)) => {
  (x._1 + y._1,x._2 + y._2)
}
val reducedOutput = output.reduceLeft[(Int,Int)](f)
println(reducedOutput)

println((0 to 100).sliding(4,3).toList)*/
import common._
//val myTask = task(customPrintln())
//myTask.join()
//import scala.collection.mutable

import java.util.concurrent.ForkJoinPool
import java.util.concurrent._
def customPrintln1() : Unit = {
  println("Hello My Own Task1")
}

def customPrintln2() : Unit = {
  println("Hello My Own Task2")
}
val forkJoinPool = new ForkJoinPool
def getTask[T](body : =>T) : ForkJoinTask[T] = {
  val t = new RecursiveTask[T] {
    def compute = body
  }
  Thread.currentThread match {
    case wt: ForkJoinWorkerThread =>
      println("Forking")
      t.fork()
    case others =>
      println(others.getName)
      println("Not Forkings")
      forkJoinPool.execute(t)
  }
  t
}


val myOwnTask = getTask(customPrintln1())
val anotherTask = getTask(customPrintln2())
myOwnTask.join()
anotherTask.join()
println("Hello")
