
for {
  x <- List(1, 2)
}
  yield(x + 2)


List(1, 2) map {x => x + 2}
val first = List(1, 2)
val next = List(8, 9)
for {
  i <- first
  j <- next
}
  yield(i * j)


first flatMap(i => next.map(_ * i))
first flatMap {
  f => next map {
    n => f * n
  }
}


val firsta = List(1, 2)
val nexta = List(8, 9)
val lasta = List("ab", "cde", "fghi")
for {
  i <- firsta
  j <- nexta
  k <- lasta
}
  yield(i * j * k.length)


firsta flatMap {
  i => nexta flatMap {
    j => lasta map {
      k => i * j * k.length
    }
  }
}


val res = for {
  i <- 1 until 100
  j <- 1 until (i-1)
  if i+j > 0
}
  yield (i, j)




