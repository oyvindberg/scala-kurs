package scalakurs.functional


object Functional {

  // Eksempel, imperative style
  def imperativeFib(n: Int): Int = {
    var nth, i1 = 0
    var i2 = 1
    for (i <- 2 until n) {
      nth = i1 + i2
      i1 = i2
      i2 = nth
    }
    nth
  }

  def factorial(n: Int): Int = {
    def fac0(n: Int, acc: Int): Int = {
      if (n <= 0) ??? // acc
      else ??? // fac0(n - 1, acc * n)
    }
    fac0(n, 1)
  }
  
  def fib(n: Int): Int = {
    def fib0(n: Int, i0: Int, i1: Int): Int = {
      if (n <= 1) i0
      else fib0(n - 1, i1, i0 + i1)
    }
    
    fib0(n, 0, 1)
  }

}