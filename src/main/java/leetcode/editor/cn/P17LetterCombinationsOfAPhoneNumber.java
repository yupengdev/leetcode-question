//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 2971 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P17LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        new P17LetterCombinationsOfAPhoneNumber().new Solution().letterCombinations("23");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCombinations(String digits) {
            List<String> combinations = new ArrayList<String>();
            if (digits.length() == 0) {
                return combinations;
            }
            Map<Character, String> phoneMap = new HashMap<Character, String>() {{
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }};
            backtrack(combinations, phoneMap, 0, digits, new StringBuilder(""));
            return combinations;
        }

        private void backtrack(List<String> combinations, Map<Character, String> phoneMap, int index, String digits, StringBuilder stringBuilder) {
            if (index == digits.length()) {
                combinations.add(stringBuilder.toString());
                return;
            }

            char digit = digits.charAt(index);
            String s = phoneMap.get(digit);
            for (int i = 0; i < s.length(); i++) {
                stringBuilder.append(s.charAt(i));
                backtrack(combinations, phoneMap, index + 1, digits, stringBuilder);
                stringBuilder.deleteCharAt(index);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
