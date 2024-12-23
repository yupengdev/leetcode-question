  //给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 3004 👎 0


  package leetcode.editor.cn;

  import java.util.ArrayDeque;
  import java.util.ArrayList;
  import java.util.Arrays;
  import java.util.Deque;
  import java.util.List;
  public class P46Permutations{
      public static void main(String[] args) {
              int[] nums = {1, 2, 3};
              Solution solution = new P46Permutations().new Solution();
              List<List<Integer>> lists = solution.permute(nums);
              System.out.println(lists);
      }
      //leetcode submit region begin(Prohibit modification and deletion)






      public class Solution {

          public List<List<Integer>> permute(int[] nums) {
              int len = nums.length;
              // 使用一个动态数组保存所有可能的全排列
              List<List<Integer>> res = new ArrayList<>();
              if (len == 0) {
                  return res;
              }
              boolean[] used = new boolean[len];
              List<Integer> list = Arrays.asList(new Integer[nums.length]);
              dfs(used, len, res, nums, list, 0);
              return res;
          }

          private void dfs(boolean[] used, int len, List<List<Integer>> res, int[] nums, List<Integer> path, int deph) {
              if (deph == len) {
                  res.add(new ArrayList<>(path));
                  return;
              }

              for (int i = 0; i < len; i++) {
                  if (!used[i]) {
                      used[i] = true;
                      path.set(deph, nums[i]);
                      dfs(used, len, res, nums, path, deph + 1);
                      used[i] = false;
                  }
              }

          }


      }


//leetcode submit region end(Prohibit modification and deletion)

  }
