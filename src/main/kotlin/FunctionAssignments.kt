

fun calculateSum(parameter1: Int, parameter2:Int):Int{
    return parameter1+parameter2
}



fun main(){
    var variableToStoreAFunction: (Int, Int)->Int

    //Using the :: construct to reference a named function and assign it to a variable
    variableToStoreAFunction = ::calculateSum

    //assigning an anonymous function to a variable
    variableToStoreAFunction = fun (parameter1:Int, parameter2: Int):Int{
        return parameter1+parameter2
    }

    //assigning a lambda to a variable
    variableToStoreAFunction = {parameter1, parameter2->
        parameter1+parameter2
    }

    //single parameter lambdas can omit parameter names, the single parameter is automatically named
    //as "it". In this case, this lambda raises a number to the power of 2
    val variableHoldingALambdaThatSquaresANumber: (Int)->Int = {
        it*it
    }

    //using a function stored on a variable;
    variableHoldingALambdaThatSquaresANumber.invoke(2)//this returns 4
    variableHoldingALambdaThatSquaresANumber(2)//this returns 4 also, the invoke is not required
}