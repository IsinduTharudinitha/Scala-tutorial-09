class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator cannot be zero")

  private val g = gcd(n.abs, d.abs)
  val numerator: Int = n / g
  val denominator: Int = d / g

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  def neg: Rational = new Rational(-numerator, denominator)

  override def toString: String = s"$numerator/$denominator"
}

object RationalTest extends App {
  val x = new Rational(3, 4)
  println(s"x: $x")

  val negX = x.neg
  println(s"-x: "+negX)
}
