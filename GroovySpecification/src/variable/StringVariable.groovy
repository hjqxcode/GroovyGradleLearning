package variable

/************************字符串变量定义***********************************/
// 单引号定义，跟java双引号定义一致
def singleName = 'a single string'
// println name.class // --> class java.lang.String
// 转义
singleName = 'a single \'name\' string'
println singleName // --> a single 'name' string

// 三引号定义，相比单引号或双引号，省去换行（'\n'）、拼接('+')等特殊字符
def tupleName = '''\
three single string:
line one
line two'''
println tupleName
println tupleName.class // --> class java.lang.String

// 双引号（可扩展）
def doubleName = "This is common string"
println doubleName.class // --> class java.lang.String
def name = "Groovy"
def sayHello = "Hello ${name}!"
println sayHello // --> Hello Groovy!
println sayHello.class // --> class org.codehaus.groovy.runtime.GStringImpl

def sum = "the sum of 1 and 1 equals ${1+1}"
println sum // --> the sum of 1 and 1 equals 2
println sum.class // --> class org.codehaus.groovy.runtime.GStringImpl

//String和GString是可以相互转换的
def String output(String content) {
    return content;
}

def result = output(sum)
println result // --> the sum of 1 and 1 equals 2
println result.class // --> class java.lang.String

/************************字符串方法***********************************/
// String方法来源java.lang.String/DefaultGroovyMethods/StringGroovyMethods
// StringGroovyMethods 普通类型的参数、闭包类型的参数

// 字符串填充
def str ="groovy"
println str.center(8, 'C') // --> CgroovyC
println str.padLeft(8, "L") // --> LLgroovy

// 字符串比较
def aa = "a"
def bb = 'b'
println aa > bb // --> false

// 字符串索引
def list = "012345678"
println list.charAt(1) // --> 1
println list[0] // --> 0
println list[0..2] // --> 012

println list.reverse() //--> 876543210
