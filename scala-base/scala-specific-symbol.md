# scala 特殊符号说明

# 符号`_`
* 通配符  
作为“通配符”，类似Java中的*。如`import scala.math._`
* `:_*`  
`:_*`作为一个整体，告诉编译器你希望将某个参数当作参数序列处理！例如`val s = sum(1 to 5:_*)`就是将`1 to 5`当作参数序列处理。
* 指代一个集合中的每个元素  
例如我们要在一个Array a中筛出偶数，并乘以2，可以用以下办法：`a.filter(_%2==0).map(2*_)`。
又如要对缓冲数组ArrayBuffer b排序，可以这样：`val bSorted = b.sorted(_)`
* 元组访问元素  
可以用方法_1, _2, _3访问组员。如a._2。其中句点可以用空格替代
* 使用模式匹配可以用来获取元组的组员  
例如 `val (first, second, third) = t`
但如果不是所有的部件都需要，那么可以在不需要的部件位置上使用_。比如上一例中 `val (first, second, _) = t`
* 某一类型的默认值  
对于Int来说，它是0
对于Double来说，它是0.0
对于引用类型，它是null

# `::`  
该方法被称为cons，意为构造，向队列的头部追加数据，创造新的列表。用法为 x::list,其中x为加入到头部的元素，无论x是列表与否，它都只将成为新生成列表的第一个元素，也就是说新生成的列表长度为list的长度＋1(btw,x::list等价于list.::(x))

# `:+和+:`  
两者的区别在于:+方法用于在尾部追加元素，+:方法用于在头部追加元素，和::很类似，但是::可以用于pattern match ，而+:则不行. 关于+:和:+,只要记住冒号永远靠近集合类型就OK了。

# `++`  
该方法用于连接两个集合，`list1++list2`

# `:::`   
该方法只能用于连接两个List类型的集合