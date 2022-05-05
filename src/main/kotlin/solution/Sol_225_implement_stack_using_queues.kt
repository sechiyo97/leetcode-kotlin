package solution

import java.util.*

fun main(){
    val obj = Sol_225_implement_stack_using_queues.MyStack()
    obj.push(1)
    obj.push(2)
    val param2 = obj.pop()
    val param3 = obj.top()
    val param4 = obj.empty()
    println("param2 $param2 param3 $param3 param4 $param4")
}

class Sol_225_implement_stack_using_queues {
    /**
     * Solution 2
     * one queue
     */
    class MyStack() {
        val queue = LinkedList<Int>()

        fun push(x: Int) {
            queue.offer(x)
            for (i in 0 until queue.size-1) {
                val value = queue.poll()
                queue.offer(value)
            }
        }

        fun pop(): Int = queue.poll()
        fun top(): Int = queue.peek()
        fun empty(): Boolean = queue.isEmpty()
    }



    /**
     * Solution 1
     * two queues
     */
//    class MyStack() {
//        val queue0 = LinkedList<Int>()
//        val queue1 = LinkedList<Int>()
//
//        fun push(x: Int) {
//            if (x%2==0) {
//                queue0.offer(x)
//                while (queue1.isEmpty().not()) {
//                    queue0.offer(queue1.poll())
//                }
//            } else {
//                queue1.offer(x)
//                while (queue0.isEmpty().not()) {
//                    queue1.offer(queue0.poll())
//                }
//            }
//        }
//
//        fun pop(): Int {
//            return if (queue0.isEmpty()) queue1.poll()
//            else queue0.poll()
//        }
//
//        fun top(): Int {
//            return if (queue0.isEmpty()) queue1.peek()
//            else queue0.peek()
//        }
//
//        fun empty(): Boolean {
//            return queue0.isEmpty() && queue1.isEmpty()
//        }
//    }
}