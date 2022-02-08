import java.lang.Exception

//This is a simple calculator using higher order functions.
//main function at line 34

fun sum(a:Int, b:Int):Int{
    return a+b
}

fun sub(a:Int, b:Int) = a-b

val div = {a:Int, b:Int->
    a/b
}

val mult = fun(a:Int, b:Int):Int{
    return a*b
}

fun executeOperation(a:Int, b:Int, operation:(Int, Int)->Int): Int{
    return operation(a,b)
}

fun getOperationFromOperator(operator: String):(Int,Int)->Int{
    return when(operator){
        "+"->::sum
        "-"->::sub
        "/"->div
        "*"->mult
        else->throw Exception("Unidentified operation")
    }
}

fun main(vararg args: String){
    //Let's overwrite args, so we don't need to use this as a console application :)
    val args = listOf("+","2","3")
    val operation = getOperationFromOperator(args[0])
    val result = executeOperation(args[1].toInt(), args[2].toInt(), operation)
    println(result)
}