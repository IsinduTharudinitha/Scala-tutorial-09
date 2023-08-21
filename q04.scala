class AccountClass(id: String, initialBalance: Double) {
  private var balance = initialBalance
  def deposit(amount: Double): Unit = { balance += amount }
  def withdraw(amount: Double): Unit = { balance -= amount }
  def transfer(that: AccountClass, amount: Double): Unit = {
    this.withdraw(amount)
    that.deposit(amount)
  }

  def getBalance: Double = balance
  override def toString: String = s"[$id] $balance"
}

class Bank {
  private var accounts: List[AccountClass] = Nil
  def addAccount(account: AccountClass): Unit = { accounts ::= account }
  def accountsWithNegativeBalances: List[AccountClass] =
    accounts.filter(_.getBalance < 0)
  def getAccounts: List[AccountClass] = accounts
  def sumOfAllBalances: Double = accounts.map(_.getBalance).sum
  def applyInterest(): Unit =
    for (account <- accounts) {
      if (account.getBalance > 0) account.deposit(account.getBalance * 0.05)
      else account.withdraw(account.getBalance.abs * 0.1)
    }
}

object AccountSample {
  def main(args: Array[String]): Unit = {
    val bank = new Bank()
    bank.addAccount(new AccountClass("1", -100))
    bank.addAccount(new AccountClass("2", -200))
    bank.addAccount(new AccountClass("3", 900))
    bank.addAccount(new AccountClass("4", -400))
    bank.addAccount(new AccountClass("5", 1500))
    bank.addAccount(new AccountClass("6", -600))
    bank.addAccount(new AccountClass("7", -500))
    bank.addAccount(new AccountClass("8", 1800))
    bank.addAccount(new AccountClass("9", -900))
    bank.addAccount(new AccountClass("10", 1000))

    val negativeAccounts = bank.accountsWithNegativeBalances
    println("Accounts with negative balances:")
    negativeAccounts.foreach(println)

    val sumOfBalances = bank.sumOfAllBalances
    println("\nSum of all balances: " + sumOfBalances)

    bank.applyInterest()
    println("\nAfter applying interest:")
    bank.getAccounts.foreach(println)

  }
}