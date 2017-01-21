import java.util.Random
val random = new Random
random.nextInt()
trait Generator[T]{
  def generate:T
}
val integers = new Generator[Int] {
  val random = new Random
  def generate = random.nextInt()
}
val boolean = new Generator[Boolean] {
  def generate = integers.generate > 0
}
val pairs = new Generator[(Int,Int)] {
  def generate = (integers.generate,integers.generate)
}



def pairs_iter3[T,U](t:Generator[T],u:Generator[U]) = new Generator[(T,U)] {
  def generate = (t.generate,u.generate)
}