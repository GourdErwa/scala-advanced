package com.gourd.scala.overviews

import org.slf4j.LoggerFactory

/** 字符串插值
  *
  * @author Li.Wei by 2019-08-06
  */
object StringInterpolation {
  private val logger = LoggerFactory.getLogger("MyApp")

  def main(args: Array[String]): Unit = {
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    // 字符串插值方法 s
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    {
      val name = "James"
      // 插值器知道在这个字符串的这个地方应该插入这个name变量的值，以使输出字符串为Hello,James。使用s插值器，
      // 在这个字符串中可以使用任何在处理范围内的名字。
      println(s"Hello,$name") //Hello,James 此例中，$name嵌套在一个将被s字符串插值器处理的字符串中。

      println(s"1+1=${1 + 1}") // 将会输出字符串1+1=2。任何表达式都可以嵌入到${}中。

    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    // 字符串插值方法 f
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    {
      val height = 1.9d
      val name = "James"
      println(f"$name%s is $height%2.2f meters tall") //James is 1.90 meters tall f 插值器是类型安全的。
      // 如果试图向只支持 int 的格式化串传入一个double 值，编译器则会报错。例如： val height:Double=1.9d

    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    // 字符串插值方法 raw
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    // 除了对字面值中的字符不做编码外，raw 插值器与 s 插值器在功能上是相同的
    {
      println(raw"a\nb")
    }
  }
}
