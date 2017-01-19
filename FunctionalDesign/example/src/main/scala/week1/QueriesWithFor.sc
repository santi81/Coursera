

case class Book(title: String, authors: List[String])

val books: List[Book] = List(
Book(title = "Structure and Interpretation of Computer Programs",
     authors = List("Abelson, Herald","Sussman, Gerald J")),
  Book(title = "Introduction to Functional Programming",
    authors = List("Bird, Richard","Wadler,Phil")),
  Book(title = "Effective Java",
    authors = List("Bloch Joshua")),
  Book(title = "Java Puzzlers",
    authors = List("Bloch Joshua","Gafter, Neal")),
  Book(title = "Programming in Scala",
    authors = List("Odersky Martin","Spoon Lex","Venners,Bill"))
)

//To find titles of books whose authors name is Bird

for {
  book <- books
  a <- book.authors if a startsWith "Bird,"
} yield book.title

// To find all books which have word Program in title

for {
  book <- books if book.title.indexOf("Java") >= 0
} yield book.title


// To find all authors who have written more than 2 books in the database


books.flatMap(book =>
  book.authors withFilter(author => author startsWith "Bird")
  map(x => book.title))


books.map(book => if (book.title.indexOf("Java") >= 0) book.title)

books.withFilter(book => book.title.indexOf("Java") >= 0).map(x => x.title)
