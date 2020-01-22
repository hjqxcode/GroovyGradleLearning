package variable

// 闭包定义
def closure = {println "Hello closure"}
println closure.class //--> class variable.Closure$_run_closure1

// 闭包调用
closure.call() //-->Hello closure
closure() //-->Hello closure

// 带参数闭包
def closureWithArg = {String name -> println "Hello ${name}"}
closureWithArg.call("Groovy") // -->Hello Groovy
closureWithArg("Closure") // -->Hello Closure

// 带默认参数闭包, 不能有'->'
def closureWithDefaultArg = {
    println "Hello ${it}"
}
closureWithDefaultArg("Groovy default") // -->Hello Groovy default


def closureWithArgs = {String name, int age ->
    println "My name is ${name}, now is ${age} years old"
}
closureWithArgs('Groovy', 20) // -->My name is Groovy, now is 20 years old

// 闭包返回结果
def result = closureWithDefaultArg("Groovy default") // --> Hello Groovy default
println result //-->null

def closureWithReturn = {
    return "Return ${it}"
}
result = closureWithReturn("result")
println result //-->Return result