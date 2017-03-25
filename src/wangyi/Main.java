package wangyi;

import java.util.Scanner;

/**
 * Created by 11626 on 2017/3/25.
 */


public class Main {

    public static void main(String[] args) {
        int x ;
        int i,j ,k;
        int n , m;
        Scanner sc = new Scanner(System.in);
        int N = 500+10;
        long xx[] = new long[N] ;
        long y[] = new long[N];
        long gx,gy;
        while(sc.hasNext()){
            n = sc.nextInt();
            for( i = 0 ; i < n ;++i){
                xx[i] = sc.nextLong();
            }
            for(i=0 ; i < n ;++i){
                y[i] = sc.nextLong();
            }
            gx = sc.nextLong();
            gy = sc.nextLong();
            xx[n] = gx;
            y[n] = gy;
            long walkTime,taxiTime;
            walkTime = sc.nextLong();
            taxiTime = sc.nextLong();
            long mint = fun(gx)+fun(gy);
            mint*=walkTime;
            for(i=0;i<n;i++){
                long s = walkTime*(fun(xx[i])+fun(y[i]));
                long ts = taxiTime*(fun(xx[i]-gx)+fun(y[i]-gy));
                mint = Math.min(mint, s+ts);
            }
            System.out.println(mint);

        }
    }
    public static long fun(long a){
        if(a>0){
            return a;
        }else{
            return -a;
        }
    }

}