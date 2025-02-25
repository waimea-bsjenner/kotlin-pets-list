/**
 * vvelcome to the funny pet list in kotlin
 */

fun main() {
    val pets = mutableListOf<String>()
    pets.add("Pepper")
    pets.add("Henny <3")
    pets.add("Isaac")
    pets.add("Kieran")
    while (true) {
        //show current pets
        show(pets)
        //get user action
        val action = menu()
        //act upon it
        when (action) {
            'q' -> break
            'a' -> getNewPet(pets)
          //  'd' -> deletePet()
        }
    }
}
/**
 * show a given list with numbered entries
 * (from 1 upwards)
 */
fun show(list: List<Any>) {
    for ((i, item) in list.withIndex()) {
        println("${i+1}: $item")
    }
}

/**
 * show a menu and get the users input
 * return this as a Char
 */
fun menu(): Char {
    println("[A]dd a new pet")
    println("[D]elete a pet")
    println("[Q]uit")

    while (true) {
        print("Choice: ")
        val input = readln()
        //try again if nothing
        if (input.isBlank()) continue
        //convert to lowercase and take first character
        val choice = input.lowercase().first()
        //check if said character is a valid option
        if ("adq".contains(choice)) {
            return choice
        }
    }
}

fun getNewPet(pets: MutableList<String>) {
    val newPet = getString("New pet: ")
    pets.add(newPet)
}

fun getString(prompt: String): String {
    var userInput: String

    while (true) {
        print(prompt)

        userInput = readln()
        if (userInput.isNotBlank()) break
    }
    return userInput
}