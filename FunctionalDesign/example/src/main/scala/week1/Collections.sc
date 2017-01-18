val myList = 1 :: 2 :: 3 :: Nil
for (e <- myList) yield e * 2
myList.map(e => e * 2)
val newList = List(List(1,2,3),4,List(5,6))
newList



val result = newList.flatMap(
  {
    case (head :: tail ) => List(head) ++ tail
    case elem: Integer => List(elem)
    case Nil => Nil
  })



val anotherResult = newList.flatMap(
{
  case a:List[Any] => a.iterator
  case b => List(b)
}
)


anotherResult


val mistake = newList.flatMap({
  case a:List[Any] => a.iterator
  case b => List(b).iterator
  case _ => Nil
})
mistake

val mistake2 = newList.flatMap({

  case a:List[Any] => a.iterator
  case b => List(b).iterator
  case _ => Nil
})
mistake2


val myPartFunc : PartialFunction[Any,Iterator[Any]] = {

  case a:List[Any] => a.iterator
  case b => List(b).iterator

}

val testing = newList.flatMap(myPartFunc)


val matchStatement:PartialFunction[Any,Iterator[Any]] = {
  case a:List[Any] => a.iterator
  case b => List(b).iterator

}


/*val testingBase = {
  case i:Int => i * 5
}*/

val hehe = List(1,2,3).map({
  case i:Int => i * 5
  case _ => 2
})

hehe
