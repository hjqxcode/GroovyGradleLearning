package variable
/*
 * 与基本数据类型结合使用
 */
int factorial(int num) {
    int result = 1
    1.upto(num, {number -> result *= number})
    println result // --> 3628800

    // 最后一个参数为闭包可以将闭包放在()外面
    int resultTwo = 1
    1.upto(num) {number -> resultTwo *= number}
    println resultTwo // --> 3628800

    int sum = 0
    // 闭包作为唯一参数可省略() times(Closure closure)
    num.times {numbers -> sum += numbers}
    println "Sum 1..${num} is ${sum}" // --> Sum 1..10 is 45

    return result
}

println factorial(10) // --> 3628800



/*public static void upto(Number self, Number to, @ClosureParams(FirstParam.class) groovy.lang.Closure closure) {
    int self1 = self.intValue();
    int to1 = to.intValue();
    if (self1 > to1) {
        throw new GroovyRuntimeException("The argument (" + to + ") to upto() cannot be less than the value (" + self + ") it's called on.");
    } else {
        for(int i = self1; i <= to1; ++i) {
            closure.call(i);
        }
    }
}*/

/*
 * 与String结合使用
 */
def str = "Closure usage with String"

/*while(self.hasNext()) {
    Object arg = self.next();
    closure.call(arg);
}
return self;*/
// each函数见上，可见参数是单个字符，返回的也是单词本身
str.each {String item -> print item.toUpperCase()} // --> CLOSURE USAGE WITH STRING
print '\n'

String strWithNumber = 'We have 8 days 9 hours left'
println strWithNumber.find { element ->     // --> 8
    element.isNumber()
}

def list = strWithNumber.findAll { String item ->
    item.isNumber()
}
println list.toListString(); // -->[8, 9]

def anyResult = strWithNumber.any {
    String item -> item.isNumber()
}
println anyResult // -->true

def everyResult = strWithNumber.every {
    String item -> item.isNumber()
}
println everyResult // -->false

def collectResult = strWithNumber.collect {
    it.toUpperCase()
}
println collectResult // -->[W, E,  , H, A, V, E,  , 8,  , D, A, Y, S,  , 9,  , H, O, U, R, S,  , L, E, F, T]


/*
 * 闭包中三个重要变量this、owner、delegate
 * this 代表闭包定义处的类
 * owner 代表闭包定义处的类或对象
 * delegate 代表任意对象, 默认以owner一致
 */
def outerClosure = {
    def innerClosure = {
        println "innerClosure this: " + this            // --> innerClosure this: variable.ClosureUsage@4d15107f
        println "innerClosure owner: " + owner          // --> innerClosure owner: variable.ClosureUsage$_run_closure7@dc7df28
        println "innerClosure delegate: " + delegate    // --> innerClosure delegate: variable.ClosureUsage$_run_closure7@dc7df28
    }

    println "innerClosure: " + innerClosure             // --> innerClosure: variable.ClosureUsage$_run_closure7$_closure11@69c81773
    innerClosure.call()
    println "outerClosure this: " + this                // --> outerClosure this: variable.ClosureUsage@4d15107f
    println "outerClosure owner: " + owner              // --> outerClosure owner: variable.ClosureUsage@4d15107f
    println "outerClosure delegate: " + delegate        // --> outerClosure delegate: variable.ClosureUsage@4d15107f
}

println "outerClosure: " + outerClosure                 // --> outerClosure: variable.ClosureUsage$_run_closure7@dc7df28
outerClosure.call()

/*
 * 闭包委托策略
 */
class School {
    String name
    def outputName = {
        "Name is ${name}"
    }

    @Override
    String toString() {
        outputName.call()
    }
}

class ClassRoom {
    String name
}

def school = new School(name : "Senior School")
println school.toString()  // --> Name is Senior School

def room = new School(name : "Senior Class")
school.outputName.delegate = room
school.outputName.resolveStrategy = groovy.lang.Closure.DELEGATE_FIRST
println school.toString() // --> Name is Senior Class


