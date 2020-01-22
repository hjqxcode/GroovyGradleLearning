package variable

/*
 * created by groovy script
 */

// 变量的类型分为基本类型和对象类型，基本类型最终会转化为对象类型
int x = 10
println x.class   // --> class java.lang.Integer

// 变量的定义分为强类型定义和弱类型def定义
// 弱类型def定义方式
def y1 = 10
println y1.class // -->class java.lang.Integer
def y2 = 3.1415
println y2.class // -->class java.math.BigDecimal
def y3 = 'Groovy'
println y3.class // -->class java.lang.String

y1 = "Variable"
println y1.class // -->class java.lang.String