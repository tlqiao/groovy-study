package com.thoughtworks.demo
import org.junit.Test
class HandleFile {
    @Test()
    void one() {
        // 读取文件
        def configFile = new File(getClass().getResource('config/test.yaml').toURI())
        def jsonFile = new File(getClass().getResource('testData.json').toURI())
        println configFile.path
        println jsonFile.path
        // 创建文件时使用相对路径，注意：/是系统根路径，创建文件的时候不要写成new File('/src/...')
        def myFile = new File ('src/main/resources/com/thoughtworks/demo/test.txt')
        // 注意：必须赋值后，文件才会创建出来
        myFile << ''
        println System.getProperty("user.dir")
    }
}
