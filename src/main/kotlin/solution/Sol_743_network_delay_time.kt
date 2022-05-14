package solution

import Solution
import common.to2DIntArray
import java.util.*

class Sol_743_network_delay_time: Solution.General<Sol_743_network_delay_time.Params, Int>() {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        val edges = Array<MutableList<Pair<Int,Int>>>(101) { mutableListOf() }
        times.forEach { edges[it[0]].add(Pair(it[1], it[2])) }

        val nodesAtTime = Array<Queue<Int>>(101) { LinkedList() }
        val timeToReachNode = IntArray(101) { 10000 }

        // init
        nodesAtTime[0].offer(k)
        timeToReachNode[k] = 0

        var time = 0
        var nodeCount = 0
        while(time < nodesAtTime.size) {
            // find nearest-time nodes
            val sourceNodes = nodesAtTime[time]
            if (sourceNodes.isEmpty()) {
                time++
                continue
            }

            // fill time map with connected nodes
            while (sourceNodes.isNotEmpty()) {
                if (++nodeCount >= n) return time

                val node = sourceNodes.poll()
                edges[node].forEach { edge ->
                    val target = edge.first
                    val weight = edge.second
                    val newTime = time + weight

                    // if time until the target node is smaller than previously computed time, replace it.
                    if (newTime < timeToReachNode[target]) {
                        if (timeToReachNode[target] < nodesAtTime.size) {
                            nodesAtTime[timeToReachNode[target]].remove(target)
                        }
                        nodesAtTime[newTime].offer(target)
                        timeToReachNode[target] = newTime
                    }
                }
            }
            time++
        }
        return -1
    }

    override val givenTestCases: Map<String, Int> = mapOf(
        "[[2,1,1],[2,3,1],[3,4,1]] 4 2" to 2,
        "[[1,2,1]] 2 1" to 1,
        "[[1,2,1]] 2 2" to -1
    )
    override val customTestCases: Map<String, Int> = mapOf(
        "[[1,2,1],[2,3,7],[1,3,4],[2,1,2]] 3 1" to 4,
        "[[3,5,78],[2,1,1],[1,3,0],[4,3,59],[5,3,85],[5,2,22],[2,4,23],[1,4,43],[4,5,75],[5,1,15],[1,5,91],[4,1,16],[3,2,98],[3,4,22],[5,4,31],[1,2,0],[2,5,4],[4,2,51],[3,1,36],[2,3,59]] 5 5" to 31
    )

    /*
    1 : 15
    1-> 2(0) : 15
    1-> 3(0) : 15
    4 : 31
     */
    override fun algorithm(input: Params): Int = networkDelayTime(input.times, input.n, input.k)
    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        val times = split[0].to2DIntArray()
        val n = split[1].toInt()
        val k = split[2].toInt()
        return Params(times, n, k)
    }
    class Params(val times: Array<IntArray>,val n: Int, val k: Int)
}