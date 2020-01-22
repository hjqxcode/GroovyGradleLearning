package variable

// switch/case语句
def swicthCase(x) {
    switch(x) {
        case 'First':
            println "Found First"
            break
        case [1,2,3,4,'Five']: // 列表
            println "Found in List"
            break
        case 1..10: // 范围
            println "Found In Ranges"
            break
        case Integer:
            println "Found Integer"
            break
        case BigDecimal:
            println "Found BigDecimal"
            break
        default:
            println("Found none")
    }
}

def x = 2;
swicthCase(x) // -->Found in List

x = 5
swicthCase(x) // -->Found In Ranges

x = 3.1415
swicthCase(x) //-->Found BigDecimal

// for语句
def sum = 0
for (i in 1..3) { // Range
    sum += i
}
println sum //-->6

sum = 0
for (i in [1,2,3]) { // List
    sum += i
}
println sum //-->6

sum = 0
for (i in ['a':1, 'b':2, 'c':3]) { // Map
    sum += i.value
}
println sum //-->6
