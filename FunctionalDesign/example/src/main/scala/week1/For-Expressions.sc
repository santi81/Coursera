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

// Rule 1

// for( x <- el ) yield(e2)
// el.map(x => e2)



// Rule 2

// for expression with filters

// for ( x <- el if f;s) yield e2

// for (x <- el.withFilter(x =>f);s) yeild e2

//WithFilter doesnt produce an intermediate list ,but filters the following map or flatMap.


// Rule 3

// for(x <- e1; y <- e2;s) yield e3

// el flatMap(x => for (y <- e2;s) yield e3)


// In case of for-expressions with patterns they act as implicit filters..

//Exercise 1
val exercise_for = for {
  x <- 2 to 10
  y <- 2 to x
  if x % y == 0
} yield(x,y)

// Translates to

val exercise_map = (2 to 10) flatMap(x =>
  2 to x withFilter(y => x % y == 0)
  map(y => (x,y))
)

exercise_for == exercise_map




