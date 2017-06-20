package leetcode.String;

/**
 * Created by thd on 2017/6/20.
 * Given a list of positive integers, the adjacent integers will perform the float division. For example, [2,3,4] -> 2 / 3 / 4.
 给定一个正整数的列表，相邻的整数将执行浮点划分。 例如，[2,3,4] - > 2/3/4。
 However, you can add any number of parenthesis at any position to change the priority of operations. You should find out how to add parenthesis to get the maximum result, and return the corresponding expression in string format. Your expression should NOT contain redundant parenthesis.
 但是，您可以在任何位置添加任意数量的括号来更改操作的优先级。 您应该知道如何添加括号以获得最大结果，并以字符串格式返回相应的表达式。 您的表达式不应包含冗余圆括号。


 Example:
 Input: [1000,100,10,2]
 Output: "1000/(100/10/2)"
 Explanation:
 1000/(100/10/2) = 1000/((100/10)/2) = 200
 However, the bold parenthesis in "1000/((100/10)/2)" are redundant,
 since they don't influence the operation priority. So you should return "1000/(100/10/2)".

 Other cases:
 1000/(100/10)/2 = 50
 1000/(100/(10/2)) = 50
 1000/100/10/2 = 0.5
 1000/100/(10/2) = 2
 */
public class n553OptimalDivision {
    public String optimalDivision(int[] nums) {
        StringBuffer sb = new StringBuffer();
        if (nums.length == 0) return null;
        sb.append(nums[0]);
        if (nums.length == 1)return new String(sb);
        if (nums.length == 2){
            sb.append("/");
            sb.append(nums[1]);
            return new String(sb);
        }
        sb.append("/(");
        for (int i = 1; i < nums.length - 1; i++) {
            sb.append(nums[i]);
            sb.append("/");
        }
        sb.append(nums[nums.length - 1]);
        sb.append(")");
        return new String(sb);
    }

    public static void main(String[] args) {
        n553OptimalDivision n = new n553OptimalDivision();
        int[] nu = {1000,100,10,2};
        System.out.println(n.optimalDivision(nu));
    }
}
