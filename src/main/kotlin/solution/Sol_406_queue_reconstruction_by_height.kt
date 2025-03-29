package solution

import Solution
import common.to2DIntArray

class Sol_406_queue_reconstruction_by_height: Solution.General<Sol_406_queue_reconstruction_by_height.Params, Array<IntArray>>() {
    fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
        val queueInputOrder = people.sortedWith(compareBy({ -it[0] }, { it[1]}))
        val mutableQueue = mutableListOf<IntArray>()
        queueInputOrder.forEach {
            mutableQueue.add(it[1], it)
        }
        return mutableQueue.toTypedArray()
    }

    override val givenTestCases: Map<String, Array<IntArray>> = mapOf(
        "[[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]" to "[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]".to2DIntArray(),
        "[[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]" to "[[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]".to2DIntArray(),
    )

    override fun inputStringToInputType(input: String): Params {
        val people = input.to2DIntArray()
        return Params(people)
    }
    override fun algorithm(input: Params): Array<IntArray> = reconstructQueue(input.people)
    class Params(val people: Array<IntArray>)
}
