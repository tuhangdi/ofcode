/**
 * Created by thd on 2017/3/4.
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class Sequence {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0) return false;
        if (sequence.length == 1)return true;
        return Verify(sequence, 0, sequence.length - 1);
    }
    public boolean Verify(int [] sequence, int start, int root){
        if (start >= root) return true;
        int i = start;
        while(sequence[i] < sequence[root])
            i++;
        for(int j = i; j < root; j++){
            if(sequence[j] < sequence[root])
                return false;
        }
        return Verify(sequence, start, i - 1) && Verify(sequence, i, root - 1);
    }
    public static void main(String[] args){
        Sequence se = new Sequence();
        int [] a = {7,4,6,5};
        int [] b = {5,7,6,9,11,10,8};
        if(se.VerifySquenceOfBST(a)) System.out.println("true");
            else System.out.println("false");
        if(se.VerifySquenceOfBST(b)) System.out.println("true");
        else System.out.println("false");
    }

}
