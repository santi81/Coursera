def isEven(i:Int ,j: Int) = if((i+j) % 2 == 0) true else false

for{
  i <- 1 to 10
  j <- 1 to i
  if isEven(i,j)
}yield(i,j)


//Begin of Translation

(1 to 10) flatMap(i =>
  (1 to i) withFilter(j => isEven(i,j))
  map(j => (i,j)))



List(1,2,3).reduce((x:Int,y:Int) => x + y)

List(4,2,3).reduceLeft((x:Int,y:Int) => x * y)


List(4,2,3).foldLeft[String]("Hello")(_ + _)

List(4,2,3).foldRight[String]("Hello")(_ + _)


val f: (Int,Int) => (Int) = (x,y) => x + y

val f2 = (x:Int,y:Int) =>  x + y
f2(2,3)



