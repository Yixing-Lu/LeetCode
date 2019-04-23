/*
* @Author: Yixing Lu
* @Date:   2019-04-23 15:14:09
* @Last Modified by:   Louis
* @Last Modified time: 2019-04-23 15:29:12
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if (nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
}
public class TwoSum {
   public static void main(String []args){
      Solution solution = new Solution();
      int[] nums = {2, 7, 11, 15};
      int target = 9;
      int[] result = solution.twoSum(nums,target);
      System.out.println(target);
      for (int i = 0; i < result.length; i++) {
         System.out.print(result[i] + " ");
      }
   }
}