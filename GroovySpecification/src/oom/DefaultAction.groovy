package oom

/*
 * trait类似java抽象类
 */
trait DefaultAction {

    abstract  void eat()

    void play() {
        println "Action play"
    }

    void drink() {
        println "Action drink"
    }

}