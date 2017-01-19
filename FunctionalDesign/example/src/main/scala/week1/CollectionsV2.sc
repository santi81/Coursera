// Core Methods


// map
//flatMap
//filter
//foldLeft
//foldRight

//map

abstract class List[T]
{

  def map[U](f:T =>U):List[U]/*= this match {

    case head :: tail => f(head) :: tail.map(f)
    case Nil => Nil

  } */

  def flatMap[U](f: T => List[U]):List[U] /*= this match {

    case head :: tail => f(head) ++ tail.flatMap(f)
    case Nil => Nil

  } */

  def filter(p: T => Boolean): List[T] /* = this match {

  case head :: tail => if(p(head)) head :: tail.filter(p) else tail.filter(p)
  case Nil => Nil
  }
  */

}