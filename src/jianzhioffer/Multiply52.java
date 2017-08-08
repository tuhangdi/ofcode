package jianzhioffer;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;

/**
 * Created by thd on 2017/4/12.
 * 给定一个数组 A[0,1,...,n-1], 请构建一个数组 B[0,1,...,n-1],
 * 其中 B 中的元素 B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 */
public class Multiply52 {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        if(A.length != 0){
            B[0] = 1;
            for(int i = 1; i < A.length; i++){//计算下三角
                B[i] = B[i - 1] * A[i - 1];
            }
            int temp = 1;
            for(int j = A.length - 2; j >= 0;j --){//计算上三角
                temp *= A[j + 1];
                B[j] *= temp;
            }
        }
        return B;
    }
}
