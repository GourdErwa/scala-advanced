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


  ///////////////////////////////////////////////////////////////////////////////////////////////////////
  // 表达式
  ///////////////////////////////////////////////////////////////////////////////////////////////////////
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

  ///////////////////////////////////////////////////////////////////////////////////////////////////////
  // 函数
  ///////////////////////////////////////////////////////////////////////////////////////////////////////
  {
    val addOne = (x: Int) => x + 1
    println(addOne(1)) // 2

    val add = (x: Int, y: Int) => x + y
    println(add(1, 2)) // 3

    val getTheAnswer = () => 42
    println(getTheAnswer()) // 42
  }

  ///////////////////////////////////////////////////////////////////////////////////////////////////////
  // 方法
  ///////////////////////////////////////////////////////////////////////////////////////////////////////
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

  ///////////////////////////////////////////////////////////////////////////////////////////////////////
  // 类型推断
  ///////////////////////////////////////////////////////////////////////////////////////////////////////
  {
    val businessName = "Montreux Jazz Café" // String

    def squareOf(x: Int) = x * x // 编译器可以推断出方法的返回类型为 Int

    def fac(n: Int): Int = if (n == 0) 1 else n * fac(n - 1)

    case class MyPair[A, B](x: A, y: B)
    val p = MyPair(1, "scala") // type: MyPair[Int, String]

    def id[T](x: T) = x

    val q = id(1) // type: Int

    //何时 不要 依赖类型推断
    var obj = null // 等价于 var obj: Null = null
    // obj = new AnyRef 它不能编译，因为 obj 推断出的类型是 Null。 由于该类型的唯一值是 null，因此无法分配其他的值。

  }


  ///////////////////////////////////////////////////////////////////////////////////////////////////////
  // 默认参数值
  // Scala具备给参数提供默认值的能力，这样调用者就可以忽略这些具有默认值的参数。
  ///////////////////////////////////////////////////////////////////////////////////////////////////////
  {
    def log(message: String, level: String = "INFO"): Unit = println(s"$level: $message")

    log("System starting") // prints INFO: System starting
    log("User not found", "WARNING") // prints WARNING: User not found

    class Point(val x: Double = 0, val y: Double = 0)
    val point1 = new Point(y = 1)

    // 注意从Java代码中调用时，Scala中的默认参数则是必填的（非可选），如：
    /*
    public class Main {
    public static void main(String[] args) {
      Point point = new Point(1);  // does not compile
    }
   }
   */

  }

  ///////////////////////////////////////////////////////////////////////////////////////////////////////
  // 命名参数
  // 当调用方法时，实际参数可以通过其对应的形式参数的名称来标记
  // 注意调用 Java 方法时不能使用命名参数
  ///////////////////////////////////////////////////////////////////////////////////////////////////////
  {
    def printName(first: String, last: String): Unit = {
      println(first + " " + last)
    }

    printName("John", "Smith") // Prints "John Smith"
    printName(first = "John", last = "Smith") // Prints "John Smith"
    printName(last = "Smith", first = "John") // Prints "John Smith"

    // 注意使用命名参数时，顺序是可以重新排列的。
    // 但是，如果某些参数被命名了，而其他参数没有，则未命名的参数要按照其方法签名中的参数顺序放在前面。
    // printName(last = "Smith", "john") // error: positional after named argument

  }

  ///////////////////////////////////////////////////////////////////////////////////////////////////////
  // 传名参数
  // 传名参数 仅在被使用时触发实际参数的求值运算。 它们与 传值参数 正好相反。 要将一个参数变为传名参数，只需在它的类型前加上 =>
  // 如果参数是计算密集型或长时间运行的代码块，如获取 URL，这种延迟计算参数直到它被使用时才计算的能力可以帮助提高性能。
  ///////////////////////////////////////////////////////////////////////////////////////////////////////
  {
    def calculate(input: => Int): Int = input * 37

    // 传名参数的优点是，如果它们在函数体中未被使用，则不会对它们进行求值。 另一方面，传值参数的优点是它们仅被计算一次
    // 方法 whileLoop 使用多个参数列表来分别获取循环条件和循环体。 如果 condition 为 true，则执行 body，然后对 whileLoop 进行递归调用。
    // 如果 condition 为 false，则永远不会计算 body，因为我们在 body 的类型前加上了 =>。
    @scala.annotation.tailrec
    def whileLoop(condition: => Boolean)(body: => Unit): Unit =
      if (condition) {
        body
        whileLoop(condition)(body)
      }

    var i = 2

    whileLoop(i > 0) {
      println(i)
      i -= 1
    } // prints 2 1

  }


  ///////////////////////////////////////////////////////////////////////////////////////////////////////
  // 运算符
  ///////////////////////////////////////////////////////////////////////////////////////////////////////
  {
    /* 当一个表达式使用多个运算符时，将根据运算符的第一个字符来评估优先级：
      * (characters not shown below)
      * / %
      * + -
      * :
      * = !
      * < >
      * &
      * ^
      * |
      * (all letters)
      **/
    // a + b ^? c ?^ d less a ==> b | c  等价于 ((a + b) ^? (c ?^ d)) less ((a ==> b) | c)
  }

}