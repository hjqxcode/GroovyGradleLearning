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
str.each {String item -> print item.toUpperCase()} // -->CLOSURE USAGE WITH STRING

String strWithNumber = 'We have 8 days 9 hours left'
println strWithNumber.find { String item ->
    item.isNumber()
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