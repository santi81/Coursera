import java.util.Random

trait Generator[T]
{
  self =>

  def generate: T

  def map[S](f:T=>S): Generator[S] = new Generator[S]{

     def generate = f(self.generate)
  }

  def flatMap[S](f:T=>Generator[S]):Generator[S] = new Generator[S] {
    override def generate: S = f(self.generate).generate
  }

}

val integers = new Generator[Int] {
  val random = new Random
  def generate = random.nextInt()
}

//Boolean Generator

val booleans = for (i <- integers) yield i > 0
val booleans_map = integers map { x => x > 0}

val boolean_iter_1 = new Generator[Boolean]{

  def generate = integers.generate > 0
}


booleans_map.generate


def pairs_for[T,U](t:Generator[T],u:Generator[U]) = for {
  x <- t
  y<- u
} yield (x,y)



def pairs[T,U](t:Generator[T],u:Generator[T]) = t flatMap(x => u map (y => (x,y)))
//Pairs Generator



def pairs_iter1[T,U](t:Generator[T],u:Generator[U]) = t flatMap {
  x => new Generator[(T,U)] {
     override def generate = (x,u.generate)
  }
}


def pairs_iter2[T,U](t:Generator[T],u:Generator[U]) = new Generator[(T,U)]{
  override def generate = new Generator[(T,U)] {
    override def generate = (t.generate,u.generate)
  }.generate
}

def pairs_iter3[T,U](t:Generator[T],u:Generator[U]) = new Generator[(T,U)] {
  def generate = (t.generate,u.generate)
}


val pairs_attr = pairs_iter2[Int,Int](integers,integers).generate

def single[T](x:T):Generator[T]= new Generator[T] {
  override def generate: T = x
}

def choose(lo : Int,hi:Int): Generator[Int]={

  for(x<- integers) yield lo + x % ( hi - lo)
}


choose(10,20).generate

def oneOfT[T](xs:T*): Generator[T] = {
  // for (idx <- choose(0,xs.length)) yield xs(idx)
  choose(0,xs.length) map {idx => xs(idx)}
}

oneOfT[String]("Santosh","Kumar","Addanki").generate






