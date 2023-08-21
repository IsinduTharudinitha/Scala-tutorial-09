class RationalNum(n: Int, d: Int) {
  require(d != 0)
  val numerator: Int = n
  val denominator: Int = d
  def neg: RationalNum = new RationalNum(-numerator, denominator)
  def sub(that: RationalNum): RationalNum =
    new RationalNum(
      numerator * that.denominator - that.numerator * denominator,
      denominator * that.denominator
    )

  override def toString: String = s"$numerator/$denominator"
}

object RationalSample {
  def main(args: Array[String]): Unit = {
    val x = new RationalNum(3, 4)
    val y = new RationalNum(5, 8)
    val z = new RationalNum(2, 7)
    val result = x.sub(y).sub(z)

    println(result)
  }
}





