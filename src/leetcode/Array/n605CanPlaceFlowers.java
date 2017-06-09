package leetcode.Array;

/**
 * Created by thd on 2017/6/9.
 * Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.
 假设你有一个长的花坛，其中一些地块种植，有些不是。 然而，花不能种植在相邻的地块 - 他们会争夺水，两者都会死亡。
 Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.

 给定一个花坛（表示为0和1的数组，其中0表示空白，1表示不为空），数字n返回，如果n个新鲜花可以种植在其中，而不违反不相邻花规则。
 Example 1:
 Input: flowerbed = [1,0,0,0,1], n = 1
 Output: True
 Example 2:
 Input: flowerbed = [1,0,0,0,1], n = 2
 Output: False
 */
public class n605CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0;
        int flower = 0;
        if (flowerbed.length == 1){
            if(flowerbed[0] == 0) return 1 >= n;
            else return 0 == n;
        }
        while(i < flowerbed.length){
            if (i == flowerbed.length - 1){
                if (flowerbed[i-1]==0 &&flowerbed[i] == 0)
                    flower ++;
                break;
            }
            else if  (flowerbed[i] == 1 || flowerbed[i+1] == 1){
                i = i + 1;
            }
            else if (flowerbed[i] == 0 && flowerbed[i+1] == 0){
                if (i == 0 || flowerbed[i -1] == 0) {
                    flower++;
                    i = i + 2;
                }
                else {
                    i++;
                }
            }
        }
        System.out.println(flower);
        return flower >= n;
    }

    public static void main(String[] args) {
        int[] f = {1,0,0,0,1};
        n605CanPlaceFlowers n = new n605CanPlaceFlowers();
        System.out.println(n.canPlaceFlowers(f, 1));
    }
}
