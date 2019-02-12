package com.thoughtworks.demo

import org.junit.Test

class ClosureStudy {
    // Groovy中的闭包是一个开放，匿名的代码块，可以接受参数，返回值并分配给变量，是一中数据类型，可以作为函数的参数
    // 定义闭包：def myClosure = {parameters -> code} 多个parameter用逗号隔开,代码块用{}包含，代码块中还可以包含{}
    // 调用闭包：myClosure(parameters)  myClosure.call(parameter)
    // 闭包不指定参数时，有一个隐藏的参数，名字叫it

    @Test()
  void testClosure() {
        def firstClosure = { name, age ->
            if (age > 100)
            {println(name + '----too old---' + age)}
            else
            {println(name + '----' + age)}
        }
        firstClosure("echo", 101)
        firstClosure.call('lilei', 80)


        def secondClosure = { println "my name is ----- $it" }
        secondClosure('qiaotl')

    }

    // Groovy中函数调用可以省略（），如果参数只有一个closure那么调用看起来有点怪，要注意

    void myFunction (myClosure) {
       myClosure()
    }
    void youFunction (name,age) {
        println 'your name is ====' + name
        println 'your age is =====' + age
    }
    @Test()
    void testMyFunction() {
        youFunction 'zhangshan', 1000
        myFunction {println 'hello world'}
        //Groovy中很多自带的API都是这样调用方式 例如list.each{}
        //对于Groovy中自带API的closure，closure需要传递的参数是什么，多少个等需要查Groovy的API文档
        //delegation 是让closure可以操作其他class中的对象
    }
    }

