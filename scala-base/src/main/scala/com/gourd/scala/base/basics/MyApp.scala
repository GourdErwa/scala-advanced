package com.gourd.scala.base.basics

import org.slf4j.LoggerFactory

/**
  * Scala的基础知识。
  *
  * @author Li.Wei by 2019-08-06
  */
object MyApp {
  private val logger = LoggerFactory.getLogger("MyApp")

  def main(args: Array[String]): Unit = {}


  // 表达式
  {
    println(1) // 1
    println(1 + 1) // 2
    println("Hello!") // Hello!
    println("Hello," + " world!") // Hello, world!

    val x = 1 + 1
    println(x) // 2
    // x = 3 // This does not compile.
    val y: Int = 1 + 1

    (x: Int) => x + 1
  }

  // 函数
  {
    val addOne = (x: Int) => x + 1
    println(addOne(1)) // 2

    val add = (x: Int, y: Int) => x + y
    println(add(1, 2)) // 3

    val getTheAnswer = () => 42
    println(getTheAnswer()) // 42
  }

  // 方法
  {
    def add(x: Int, y: Int): Int = x + y

    println(add(1, 2)) // 3

    def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier

    println(addThenMultiply(1, 2)(3)) // 9

    def name: String = System.getProperty("user.name")

    println("Hello, " + name + "!")

    def getSquareString(input: Double): String = {
      val square = input * input
      square.toString
    }
  }

}