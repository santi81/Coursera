

trait M[A] {
  def flatMap[B](f: A => M[B]): M[B]

  def unit[A](x: A): M[A]

}



val f = (i: Int) => List(i - 1, i, i + 1)
val list = List(5, 6, 7)
list map f
list flatMap f
//map using flatMap

list.flatMap(x => List(f(x)))
//Left Identity Law

// left-identity law:
// unit(x).flatMap(f) == f(x)

List(5).flatMap(f) == f(5)
// right-identity law:
// m.flatMap(unit) == m

list.flatMap(x => List(x)) == list
list.flatMap(List(_))




val emptyList = List.empty[Int]
val notherEmptyList:List[Int] = Nil
val cheatingList:List[Int] = List()
// associativity law:
// m.flatMap(f).flatMap(g) == m.flatMap(x ⇒ f(x).flatMap(g))

//Monads in Pracitse : Option

/*
trait M[T] {
  def map(f: T => S): M[S]
  def flatMap(f: T => M[S]): M[S]
}

*/

val three = Option(3)
val twelve = three map (_ * 4)
val four = Option(4)
// four: Option[Int] = Some(4)
val twelveB = three map (i => four map (i * _))
val twelveA = three flatMap(i => four map (i * _))
val twelveD = for {
  i <- three
  j <- four
} yield (i * j)



val oops: Option[Int] = None
// oops: Option[Int] = None
val oopsB = for {
  i <- three
  j <- oops
} yield (i * j)
// oopsB: Option[Int] = None
val oopsC = for {
  i <- oops
  j <- four
} yield (i * j)
// oopsC: Option[Int] = None


//Future Monad


import scala.concurrent.duration._
import scala.concurrent.{Future,ExecutionContext,Await}
import ExecutionContext.Implicits.global
val f1=Future{
  Thread.sleep(10000)
  1 }
val f2=Future{
  Thread.sleep(10000)
  2 }
val f3=for {
  v1 <- f1
  v2 <- f2
} yield (v1+v2)
println(Await.result(f3,30.second))







