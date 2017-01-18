
object test {

  println("Welcome to Week 1 of Functional Design")

  val f : String => String = {case "ping" => "pong"}

  f("ping")

 // f("ammu")

  val g: PartialFunction[String,String] = {case "ping" => "pong"}

  g("ping")

  g.isDefinedAt("motu")

}