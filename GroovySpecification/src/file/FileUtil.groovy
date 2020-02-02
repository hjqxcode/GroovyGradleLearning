package file

def imlFile = new File('../../GroovySpecification.iml')
// getText
def allContent = imlFile.getText('UTF-8') // 返回所有字符串
// readLines
def allContentList = imlFile.readLines()  // 返回所有行字符串构成的列表
// eachLine
def lineIndex = 1
imlFile.eachLine { line  ->
    println "line ${lineIndex}: ${line}"
    lineIndex++
}

// withReader读取内容
println imlFile.withReader {
    reader ->
        char[] buff = new char[10]
        reader.read(buff, 0, 10)
        return buff
}

println copyFile('../../GroovySpecification.iml', '../../GroovySpecificationCopy.iml')

def copyFile(String srcFilePath, String destFilePath) {
    try {
        def srcFile = new File(srcFilePath)
        if (!srcFile.exists()) {
            println "source file ${srcFilePath} not exist"
            return false
        }

        def destFile = new File(destFilePath)
        if (!destFile.exists()) {
            destFile.createNewFile()
        }

        srcFile.withReader {reader ->
            def lines = reader.readLines()
            destFile.withWriter { writer ->
                lines.each { line ->
                    writer.writeLine(line)
                }
            }
        }

        return true
    } catch (Exception exception) {
        println "copyFile exception: " + exception
    }

    return false
}



