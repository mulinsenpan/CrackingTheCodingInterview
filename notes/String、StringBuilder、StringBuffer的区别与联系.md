## 1、可变与不可变
String类中使用字符数组保存字符串，有final修饰符，因此string对象不可变。
StringBuffer和StringBuilder都继承自AbstractStringBuilder类，也是使用字符数组保存字符串，但是没有final字符修饰，因此可变
### 问题：如何在不重新分配内存地址的情况下修改string对象？
利用Java的反射机制(final只对编译有效，对运行无效，因此可以在运行时改变final的内容。)

## 2、是否多线程安全
String是不可变的，可以理解为常量，因此是线程安全的。
StringBuilder对方法增加了同步锁或者对调用的方法加了同步锁，因此是线程安全的。
StringBuffer没有对方法进行加同步锁，所以是非线程安全的。

## 3、StringBuilder与StringBuffer共同点
共同点：有公共父类AbstractStringBuffer
		两者的方法都会调用父类中的公共方法，但是StringBuilder对在方法上加synchronized关键字，加上同步锁。
		如果程序不是多线程的，StringBuilder的运行效率高于StringBuffer。

## 4、使用总结
1.如果要操作少量的数据用 = String
2.单线程操作字符串缓冲区 下操作大量数据 = StringBuilder
3.多线程操作字符串缓冲区 下操作大量数据 = StringBuffer
## 5、抽象类和接口的区别：
抽象类中可以定义一些子类的公共方法，子类字需要增加新的功能，不需要重复写已经存在的方法；
接口知识对方法的声明和常量的定义。

