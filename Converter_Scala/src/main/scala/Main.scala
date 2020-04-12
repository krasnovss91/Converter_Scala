
object Main extends App {

  println(Europe.Euro from(US.Dollar))
  println(US.Dollar from(Europe.Euro))
  println(Japan.Yen from(US.Dollar))
  println(US.Dollar from(Japan.Yen))

  println(US.Dollar * 100)
}
