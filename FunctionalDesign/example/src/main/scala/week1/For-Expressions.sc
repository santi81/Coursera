def isEven(i:Int ,j: Int) = if((i+j) % 2 == 0) true else false

val forExression = for {
  i <- 1 until 10
  j <- 1 until i
  if isEven(i, j)
} yield(i,j)

forExression.foreach(println)


val mappedExpression = (1 until 10) flatMap(
  i =>
    (1 until i) filter(j => isEven(i, j))
    map(j => (i,j))
  )


mappedExpression.foreach(println)


// Transformation Rules

// for( x <- el ) yield(e2)
// el.map(x => e2)






