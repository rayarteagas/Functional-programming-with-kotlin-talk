
fun doSomething(elements: List<String>):List<Pair<String, Int>>{
    var i = 0
    val result = hashMapOf<String, Int>()
    while(i<elements.size){
        val element = elements[i]
        if(element.length>10){
            val elementOnResult = result[element]
            if(elementOnResult != null){
                result[element] = elementOnResult + 1
            }
            else {
                result[element] = 1
            }
        }
        i++
    }
    return result.toList()
}



fun doSomethingBetter(elements: List<String>): List<Pair<String, Int>>{
    return elements
        .filter { it.length>10 }
        .groupBy { it }
        .map { Pair(it.key, it.value.count()) }
}