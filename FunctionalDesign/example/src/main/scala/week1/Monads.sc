

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
list.flatMap(List(_)) == list





val emptyList = List.empty[Int]
val notherEmptyList:List[Int] = Nil
val cheatingList:List[Int] = List()
// associativity law:
// m.flatMap(f).flatMap(g) == m.flatMap(x ⇒ f(x).flatMap(g))

//Monads in Pracitse : Option




