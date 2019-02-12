package com.thoughtworks.demo

import groovy.json.JsonSlurper
import org.junit.Test

class HandleMap {
    JsonSlurper jsonSlurper

    HandleMap() {
        jsonSlurper = new JsonSlurper()
    }

    void first() {
        def myMap = ['key1': 'fistValue', 'key2': 'secondValue']
        println myMap.key1
    }
// stages是一个rrayList，stages.find返回rrayList中第一个match的符合条件的对象，因为arrayList中对象是lazyMap，所以find返回的时候LazyMap
    void second() {
        def file = new File(getClass().getResource('testData.json').toURI())
        def res = jsonSlurper.parse(file)
        def result = res.build.stages.find { it ->
            it.id == '15000000000000' }
        println result.getClass()
        println result
//findAll 返回ArrayList
        def secondResult = res.build.stages.findAll { it ->
            it.id == '15000000000000' }
        println secondResult.getClass()
        println secondResult
//find到的对象还可以再次继续筛选获取
        println res.build.stages.find { it -> it.id == '15000000000000' }.status

//each返回ArrayList，each作用是遍历ArrayList中的对象，做一些处理后，整个ArrayList
        def resultTwo = res.build.stages.each {
            it ->
                if (it.id == '15000000000000') {
                    it.name = 'new name'
                } else {
                    it.name = 'old name'
                }
        }
        println resultTwo.getClass()
        println resultTwo
        println resultTwo[0].getClass()
        println resultTwo[0]
    }

    @Test()
    void testFirst() {
        first()
    }

    @Test()
    void testSecond() {
        second()
    }

}
