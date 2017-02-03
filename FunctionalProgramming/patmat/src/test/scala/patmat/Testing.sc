

val chars = List('a','a','b','b','a','c','a','d','a','f')


//val counts = chars.map(x => (x,1)).groupBy(_._1).map(x => (x._1,x._2.size)).toList.sortWith(_._2 <= _._2)

val counts = chars.map(x => (x,1)).groupBy(_._1).map(x => (x._1,x._2.size)).toList.sortWith(sortFunc)


def sortFunc(x1:(Char,Int),x2:(Char,Int)) : Boolean = {

  if (x1._2 <= x2._2) true else false

}

