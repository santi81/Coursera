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
 