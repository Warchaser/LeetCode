import java.lang.IllegalArgumentException

class Run {

    companion object{
        @JvmStatic
        fun main(args : Array<String>) {
//            twoSumWrap()
            reverseWrap()
        }

        @JvmStatic
        fun twoSumWrap(){
            val nums = intArrayOf(2,7,11,15)
            val target = 9
            print(Run().twoSum(target = target, nums = nums).contentToString())
        }

        @JvmStatic
        fun reverseWrap(){
            val x = -2147483648
            print(Run().reverse(x))
        }
    }

    /**
     * 1.两数之和
     * @param nums 输入整形数组
     * @param target 输入的目标值
     * @return IntArray
     * */
    fun twoSum(nums: IntArray, target: Int) : IntArray{
        val map = HashMap<Int, Int>()
        for (i in nums.indices){
            val pre = nums[i]
            val differ = target - pre
            if(map.containsKey(differ)){
                return intArrayOf(map[differ]!!, i)
            }
            map[pre] = i
        }
        throw IllegalArgumentException("")
    }

    /**
     * 697.数组的度
     * */
    fun findShortestSubArray(nums: IntArray): Int {
        return 1
    }

    fun reverse(x: Int): Int {
        var res = 0
        var xT = x
        while(xT != 0){
            val t = res * 10 + xT % 10
            if(t / 10 != res){
                return 0
            }

            res = t
            xT /= 10
        }

        return res
    }

}