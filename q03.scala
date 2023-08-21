class Account(id: String, initialBalance: Double) {
  private var balance = initialBalance
  def deposit(amount: Double): Unit = { balance += amount }
  def withdraw(amount: Double): Unit = { balance -= amount }
  def transfer(that: Account, amount: Double): Unit = {
    this.withdraw(amount)
    that.deposit(amount)
  }

  override def toString: String = s"[$id] $balance"
}

object AccountTest {
  def main(args: Array[String]): Unit ={
    val account1 = new Account("1", 1000)
    val account2 = new Account("2", 500)

    account1.transfer(account2, 100)
    println(account1)
    println(account2)

    account1.withdraw(100)
    println(account1)

    account2.deposit(100)
    println(account2)
  }
}