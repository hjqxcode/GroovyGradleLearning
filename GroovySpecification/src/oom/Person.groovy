package oom

class Person implements Action { // 默认都是public
    // 所有成员变量默认生成对应的get/set方法
    String name
    Number age

    def increaseAge(Number years) {
        this.age += years
    }

    def invokeMethod(String name, Object args) { // 注意是def而不是override invokeMethod()
        return "invokeMethod name ${name}, params ${args}"
    }

    def methodMissing(String name, Object args) {
        name.toUpperCase()
        return "methodMissing name ${name}, params ${args}"
    }

    @Override
    void eat() {
    }

    @Override
    void drink() {
    }

    @Override
    void play() {
    }
}
