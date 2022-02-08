import kotlin.random.Random

val elements: List<String> = listOf("red","green","blue")

fun main(){
  println(elements.pickRandomItem())
  println(2 plus 3)
}

//this picks a random item from a list of strings
fun List<String>.pickRandomItem():String{
    val randomNumber = Random.nextInt(this.size)
    return this.get(randomNumber)
}

//this is an infix function
infix fun Int.plus(numB:Int) = this+numB













