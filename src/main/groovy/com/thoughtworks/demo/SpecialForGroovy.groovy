package com.thoughtworks.demo

import org.junit.Test

class SpecialForGroovy {
    // Groovy扩展了java，运行在java平台（jvm）的动态语言
    // 执行groovy脚本时，先将其编译成java的class字节码，然后在jvm中运行，对于jvm而言，并不知道运行的时候java还是groovy
    // 定义变量时可以不指定具体类型，用def定义即可，函数参数可以不指定数据类型
    // 函数调用可以不使用（）
    // 无需使用return，最后一行就是返回值
    // 单引号，双引号:支持变量解析，三引号使用：支持换行，无需使用换行符号

    def myfunction(name, age) {
        println "this is my name $name"
        println "this is your age $age"
        println '''first line
                second line'''
        name
    }

    @Test()
    void testMyFunction() {
        println myfunction('Done', 100)
    }

    // Groovy 数据类型包含java的基础数据类型，容器类，闭包
    // 容器类包含list，map，range，
    // list是ArrayList作为真正的实现类，map对应java底层的linkedHashMap，range是list的一种扩展
    // array是数组，定义的时候需要制定长度，且只能存放一种数据类型，arrayList是集合，可以存在不同类型的数据，Groovy中使用arrayList
    // linkedHashMap,LazyHashMap, ThreeMap 存储和查找数据上实现方式有差异，使用时写法上无区别
}