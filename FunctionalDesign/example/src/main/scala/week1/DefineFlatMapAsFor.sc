def mapFun[T,U](xs: List[T],f : T => U): List[U] = {
  for(elem <- xs) yield f(elem)
}

def flatMapFun[T,U](xs: List[T],f: T => List[U]): List[U] = {
  for{
    x <-xs
    y <- f(x)
  }yield y
}

mapFun(List(1,2,3),{(x:Int) => x * 2})

val myList = List(1,List(2,3,4),List(5,6,7))

flatMapFun[Any,Any](myList,{
case x:List[Any] => x
case x: Int => List(x)
case Nil => Nil
})

def filter[T](xs: List[T],f:T => Boolean): List[T] ={
  for( x <- xs if f(x)) yield x

}