println("UW Complex Kotlin homework")

// write a lambda using map and fold to solve "FIZZBUZZ" for the first fifteen numbers (0..15)
// use map to return a list with "", "FIZZ" or "BUZZ" as necessary
// use fold to compress the array of strings down into a single string
// the final string should look like FIZZBUZZFIZZFIZZBUZZFIZZFIZZBUZZ
//

val myList = arrayOf(1, 2, 3, 4, 5, 6 , 7 , 8, 9 , 10, 11, 12, 13, 14, 15)

val mapResults = myList.map{it -> helper(it)}

fun helper(takes: Int): String {
    if(takes % 3 == 0 && takes % 5 == 0) {
        return "FIZZBUZZ"
    } else if(takes % 3 == 0) {
        return "FIZZ"
    } else if(takes % 5 == 0) {
        return "BUZZ"
    } else {
        return ""
    }
}

val mapFoldResults = mapResults.fold("") {sum, element -> sum + element}

// This is a utility function for your use as you choose, and as an
// example of an extension method
fun Int.times(block: () -> Unit): Unit {
    for (it in 1..this) {
        block()
    }
}

// Use this function
fun process(message: String, block: (String) -> String): String {
    return ">>> ${message}: {" + block(message) + "}"
}
val r1 = process("FOO", {_: String -> "BAR"}) // call process() with message "FOO" and a block that returns "BAR"

val r2_message = "wooga"
val r2 = process("FOO", {_: String -> r2_message.toUpperCase() + r2_message.toUpperCase() + r2_message.toUpperCase()}) // call process() with message "FOO" and a block that upper-cases
            // r2_message, and repeats it three times with no spaces: "WOOGAWOOGAWOOGA"


// write an enum-based state machine between talking and thinking
enum class Philosopher {
    THINKING {
        override fun toString() = "Deep thoughts...."
        override fun signal() = TALKING
    },
    TALKING {
        override fun toString() = "Allow me to suggest an idea..."
        override fun signal() = THINKING
    };

    abstract fun signal(): Philosopher
}


// create an class "Command" that can be used as a function (provide an "invoke()" function)
// that takes a single parameter ("message" of type String)
// primary constructor should take a String argument ("prompt")
// when called, the Command object should return a String containing the prompt and then the message
class Command(val prompt: String) {
    operator fun invoke(message: String): String {
        return prompt + message
    }
}



// ================================
println("map fold test: " + if (mapFoldResults == "FIZZBUZZFIZZFIZZBUZZFIZZFIZZBUZZ") "." else "!")

println("r1 test: " + if (r1 == ">>> FOO: {BAR}") "." else "!")

println("r2 test: " + if (r2 == ">>> FOO: {WOOGAWOOGAWOOGA}") "." else "!")


var seneca = Philosopher.THINKING
print("Seneca, talk! ")
seneca = seneca.signal()
println(if (seneca.toString() == "Allow me to suggest an idea...") "." else "!")
print("Seneca, think! ")
seneca = seneca.signal()
println(if (seneca.toString() == "Deep thoughts....") "." else "!")
print("Seneca, talk! ")
seneca = seneca.signal()
println(if (seneca.toString() == "Allow me to suggest an idea...") "." else "!")

print("Command tests: ")
print(if (Command("")("") == "") "." else "!")
print(if (Command("> ")("Hello!") == "> Hello!") "." else "!")
println("")



