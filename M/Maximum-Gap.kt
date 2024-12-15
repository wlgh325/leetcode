class Solution {
    fun maximumGap(nums: IntArray): Int {
        if (nums.size < 2) {
            return 0;
        }

        nums.sort()

        var max = 0
        val len = nums.size
        for (i in 0 until len-1) {
            val diff = nums[i+1] - nums[i]
            if (diff > max) {
                max = diff
            }
        }

        return max
    }
}