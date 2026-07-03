package com.company.stacksandqueues

fun main() {
    /**
     * When main() calls a(), which calls b(), which calls c(),
     * each function gets its own stack frame.
     * The stack grows with each call and shrinks as functions return.
     * */

    println("Starting")
    a()
    println("Done")

}

fun a(){
    val x = 10
    b(x)
}

fun b(value: Int){
    val y = value * 2
    c(y)
}

fun c(result : Int){
    println("Result: $result")
}