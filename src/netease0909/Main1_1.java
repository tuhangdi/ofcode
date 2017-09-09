package netease0909;

/**
 * Created by thd on 2017/9/9
 */
import java.util.Scanner;

public class Main1_1 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        sc.nextLine();
        for(;t>0;t--)
        {
            int n=sc.nextInt();
            sc.nextLine();
            String str=sc.nextLine();
            String []strs=str.split(" ");

            int div4=0;
            int div2=0;
            for(int i=0;i<strs.length;i++)
            {
                int num=Integer.parseInt(strs[i]);
                if(num%4==0) div4++;
                else if(num>2&&num%2==0) div2++;
                else ;
            }

            if((2*div4+div2)>=n)
            {
                System.out.println("YES");
            }
            else
                System.out.println("NO");

        }
    }


}
