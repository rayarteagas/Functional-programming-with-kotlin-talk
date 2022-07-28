
/*
Compilation error. You cannot local return from a lambda expression.

fun doSomethingWithLambda(){
    10.extension{
        if(it == 10)
            return//compiler error
    }
    println("hello")
}
*/

//Does not print hello, the println line is never reached as the lambda returns to the caller 
// (non local), which in this case is doSomethingWithCopiedLambda()
fun doSomethingWithCopiedLambda(){
    10.inlineExtension{
        if(it == 10)
            return
    }
    println("hello1")
}

//Does print hello, as we can achieve a return to the inlined lambda using a tag (in this case "@inlineExtension")
fun doSomethingWithCopiedLambdaAndTag(){
    10.inlineExtension{
        if(it == 10)
            return@inlineExtension
    }
    println("hello2")
}

//Does print hello, as the anonymous function return locally, so the caller (doSomethingWithAnonymousFunction()) runs unaffected
fun doSomethingWithAnonymousFunction(){
    10.extension(fun(it){
        if(it == 10)
            return
    })
    println("hello3")
}

doSomethingWithCopiedLambda()
doSomethingWithCopiedLambdaAndTag()
doSomethingWithAnonymousFunction()


fun Int.extension(f: (Int)->Unit){
    f(this)
}

inline fun Int.inlineExtension(f: (Int)->Unit){
    f(this)
}
