package variable

/****************************List****************************/
// 列表定义
def list = [1, 2, 3, 4, 5, [6, 7], 'eight']
println list.class  // --> class java.util.ArrayList

list.add("9")
list.remove(0)
println list        // --> [2, 3, 4, 5, [6, 7], eight, 9]

// 数组定义
def array = [1, 2, 3, 4, 5] as int[] // 等价于 int[] array = [1, 2, 3, 4, 5]
println array.class // --> class [I

// 列表排序
list.sort()         // 默认规则排序
println list        // --> [2, 3, 4, 5, 9, [6, 7], eight]

def growsPercent = [1.1, 2.2, -1.6, 0, 0.6, 2.9]
growsPercent.sort {
    a, b -> a == b ? 0 : Math.abs(a) < Math.abs(b) ? -1 : 1 // 闭包指定排序规则
}
println growsPercent    // --> [0, 0.6, 1.1, -1.6, 2.2, 2.9]

def sortStringList = ['abc', 'd', 'China', 'Great country']
sortStringList.sort {
    return it.size()
}
println sortStringList  // --> [d, abc, China, Great country]

// 列表查找（find/findAll/any/every/min/max/count）
def scores = [88, 66, 52, 73, 59, 99, 29]
println scores.max()                // --> 99
println scores.find {it < 60}       // --> 52
println scores.findAll {it >= 80}   // --> [88, 99]
println scores.count {it < 60}      // --> 3
println scores.groupBy {            // --> [良好:[88], 及格:[66, 73], 不及格:[52, 59, 29], 优秀:[99]]
    switch (it) {
        case 0..59:
            return "不及格"
        case 60..79:
            return "及格"
        case 80..89:
            return "良好"
        case 90..100:
            return "优秀"
    }
}

/****************************Map****************************/
// 映射定义，key必须是Number或String(必须不可变单引号字符串，可省略引号)
def colorMap = [red: 'ff0000', green: '00ff00', blue: '0000ff', 0: 'ff000000'] //
println "class: ${colorMap.getClass()}, ${colorMap['red']}, ${colorMap[0]}"   // --> class: class java.util.LinkedHashMap, ff0000, ff000000
// 添加新key-value
colorMap.black = '000000'
println colorMap.toMapString() // --> [red:ff0000, green:00ff00, blue:0000ff, 0:ff000000, black:000000]
// 遍历
colorMap.each {def entry  -> print "${entry.key}->${entry.value} "} // --> red->ff0000 green->00ff00 blue->0000ff 0->ff000000 black->000000
print '\n'
colorMap.eachWithIndex{ entry, int i -> print "${i}: ${entry.key}->${entry.value} "}
// --> 0: red->ff0000 1: green->00ff00 2: blue->0000ff 3: 0->ff000000 4: black->000000
print '\n'
colorMap.eachWithIndex { key, value, index -> print "${index}: ${key}->${value} "}
// --> 0: red->ff0000 1: green->00ff00 2: blue->0000ff 3: 0->ff000000 4: black->000000
print '\n'
// 查找(find/findAll/count/collect)同list
// 排序(sort)同list

/****************************Range****************************/
// Range类是个接口,继承List
def rang = 60..100  // class groovy.lang.IntRange
println "${rang.from}->${rang.to}, rang contain 50 ? ${rang.contains(50)}" // --> 60->100, rang contain 50 ? false