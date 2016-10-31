def startsWithUpperCase(input: String): Boolean = {
	(input != null) &&
		(!input.isEmpty) &&
		(input(0).isUpper)
}

def containsAtLeastThreeLetters(input: String): Boolean = {
	if ((input != null) && (!input.isEmpty)) {
		val letters = input.filter(c => c.isLetter)
		letters.size >= 3
	} else {
		false
	}
}

val testInputs = List(null, "", "lower", "Upper")

testInputs.map(input =>
	(startsWithUpperCase(input),
		containsAtLeastThreeLetters(input)))
