package oom

def zhangSan = new Person(name: 'Zhangsan', age: 35)
println "The name is ${zhangSan.name}, the age is ${zhangSan.age}"  // --> The name is Zhangsan, the age is 35

zhangSan.increaseAge(1)
println "The name is ${zhangSan.name}, the age is ${zhangSan.age}"  // --> The name is Zhangsan, the age is 36

// Person类中未定义walk方法时调用
println zhangSan.walk() // --> runtime报错groovy.lang.MissingMethodException: No signature of method: oom.Person.walk() is applicable for argument types: () values: []

// Person类中新增def invokeMethod(String name, Object args)或者def methodMissing(String name, Object args) {
println zhangSan.walk() // --> methodMissing name walk, params []

// 类动态添加属性
Person.metaClass.sex = 'male'
def liSi = new Person(name: 'lisi', age: 28)
println liSi.sex        // --> male

// 类动态添加方法
Person.metaClass.formatName = {
    -> name.toUpperCase()
}
def wangWu = new Person(name: 'wangwu', age: 25)
println wangWu.formatName() // --> WANGWU

// 类动态添加静态方法
Person.metaClass.static.createPerson = {
    name, age -> new Person(name: name, age: age)
}
def chenliu = Person.createPerson('chenliu', 39)
println chenliu.name + " is age " + chenliu.age + ", sex is " + chenliu.sex // --> chenliu is age 39, sex is male

// 全局注入
ExpandoMetaClass.enableGlobally()