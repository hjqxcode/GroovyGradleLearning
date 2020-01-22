package variable

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

