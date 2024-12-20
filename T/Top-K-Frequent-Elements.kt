class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val frequencyMap = mutableMapOf<Int, Int>()
        for (num in nums) {
            frequencyMap[num] = frequencyMap.getOrDefault(num, 0) + 1
        }

        val maxFrequency = frequencyMap.values.maxOrNull() ?: 0
        val buckets = Array<MutableList<Int>>(maxFrequency + 1) { mutableListOf() }

        for ((num, freq) in frequencyMap) {
            buckets[freq].add(num)
        }

        val result = mutableListOf<Int>()
        for (freq in buckets.size - 1 downTo 1) {
            for (num in buckets[freq]) {
                result.add(num)
                if (result.size == k) {
                    return result.toIntArray()
                }
            }
        }

        return intArrayOf()
    }
}