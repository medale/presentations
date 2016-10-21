import scala.annotation.tailrec

def factorial(n: BigInt): BigInt = if (n == 1) 1 else n * factorial(n-1)

val b = BigInt("10000")
//factorial(b)


def fac2(n: BigInt): BigInt = {
	def loop(currN : BigInt, facSoFar: BigInt): BigInt = {
		if (currN == 1) {
			facSoFar
		} else {
			loop(currN - 1, currN * facSoFar)
		}
	}
	loop(n, 1)
}

fac2(10000)

val incr : (BigInt) => BigInt = (n) => n + 1

incr(1011111)


val myPow: (Int, Int) => Int = (a,b) => Math.pow(a,b).toInt

myPow(2,3)

myPow(3,2)

val curriedMyPow: Int => Int => Int = myPow.curried

val threePow = curriedMyPow(3)

threePow(2)
threePow(4)



