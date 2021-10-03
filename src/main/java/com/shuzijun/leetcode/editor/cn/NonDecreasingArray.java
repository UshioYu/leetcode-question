//给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
//
// 我们是这样定义一个非递减数列的： 对于数组中任意的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [4,2,3]
//输出: true
//解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
// 
//
// 示例 2: 
//
// 
//输入: nums = [4,2,1]
//输出: false
//解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10 ^ 4 
// - 10 ^ 5 <= nums[i] <= 10 ^ 5 
// 
// Related Topics 数组 👍 615 👎 0


package com.shuzijun.leetcode.editor.cn;

public class NonDecreasingArray {
    public static void main(String[] args) {
        Solution solution = new NonDecreasingArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 贪心的思想，就是每次修改都要确保前面的数值要小
         * 这道题给了我们一个数组，说我们最多有1次修改某个数字的机会，
         * 问能不能将数组变为非递减数组。题目中给的例子太少，不能覆盖所有情况，我们再来看下面三个例子：
         * 	4，2，3
         * 	-1，4，2，3
         * 	2，3，3，2，4
         * 我们通过分析上面三个例子可以发现，当我们发现后面的数字小于前面的数字产生冲突后，
         * [1]有时候需要修改前面较大的数字(比如前两个例子需要修改4)，
         * [2]有时候却要修改后面较小的那个数字(比如前第三个例子需要修改2)，
         * 那么有什么内在规律吗？是有的，判断修改那个数字其实跟再前面一个数的大小有关系，
         * 首先如果再前面的数不存在，比如例子1，4前面没有数字了，我们直接修改前面的数字为当前的数字2即可。
         * 而当再前面的数字存在，并且小于当前数时，比如例子2，-1小于2，我们还是需要修改前面的数字4为当前数字2；
         * 如果再前面的数大于当前数，比如例子3，3大于2，我们需要修改当前数2为前面的数3。
         * @param nums
         * @return
         */
        public boolean checkPossibility(int[] nums) {
            if (nums == null || nums.length <= 2)
                //长度为2的时候，肯定是true，顶多把第一个或第二个数改成
                //跟另一个一致即可
                return true;
            //count计数，初始为0，当当前比前一个元素小时，累加，应该肯定要操作元素的值
            //当当前的count=2时，就可提前结束for循环了
            int count = 0;
            //因为下面判断i-1开始，所以for循环从1到length进行计数
            for (int i = 1; i < nums.length && count < 2; i++) {
                if (nums[i - 1] <= nums[i])
                    //当前元素比前一个大，继续遍历下一个
                    continue;
                count++;
                if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                    //这里是当前前2个元素比当前大，可得i-2的值应该跟i-1的值一致
                    //把i的值等于i-1即可
                    nums[i] = nums[i - 1];
                } else {
                    //不满足上述条件。表示i-1的值比较大，让他等于i即可
                    nums[i - 1] = nums[i];
                }
            }
            return count <= 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
