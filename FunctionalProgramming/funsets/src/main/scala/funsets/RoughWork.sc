type Set = Int => Boolean

val negativeIntegers: Set = x => x < 0




negativeIntegers(-1)


def contains(s:Set, elem: Int): Boolean = s(elem)

contains(negativeIntegers, 2)