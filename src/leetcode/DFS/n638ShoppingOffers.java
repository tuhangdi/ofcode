package leetcode.DFS;

import java.util.List;

/**
 * Created by thd on 2017/7/17.
 * In LeetCode Store, there are some kinds of items to sell. Each item has a price.
 在LeetCode Store中，有一些要销售的物品。每个项目都有一个价格。
 However, there are some special offers, and a special offer consists of one or more different kinds of items with a sale price.
 但是，有一些特别优惠，特价优惠包含一种或多种不同种类的具有销售价格的商品。
 You are given the each item's price, a set of special offers, and the number we need to buy for each item. The job is to output the lowest price you have to pay for exactly certain items as given, where you could make optimal use of the special offers.
 您将获得每件物品的价格，一套特别优惠以及我们为每件物品购买的数量。这份工作是输出您所要支付的最低价格，以确定特定的项目，您可以在哪里最佳地使用特别优惠。
 Each special offer is represented in the form of an array, the last number represents the price you need to pay for this special offer, other numbers represents how many specific items you could get if you buy this offer.
 每个特别优惠以数组的形式表示，最后一个数字表示您需要为此特别优惠支付的价格，其他数字表示您购买此优惠时可获得多少具体项目。
 You could use any of special offers as many times as you want.
 您可以根据需要多次使用任何特别优惠。

 Example 1:
 Input: [2,5], [[3,0,5],[1,2,10]], [3,2]
 Output: 14
 Explanation:
 There are two kinds of items, A and B. Their prices are $2 and $5 respectively.
 In special offer 1, you can pay $5 for 3A and 0B
 In special offer 2, you can pay $10 for 1A and 2B.
 You need to buy 3A and 2B, so you may pay $10 for 1A and 2B (special offer #2), and $4 for 2A.


 Example 2:
 Input: [2,3,4], [[1,1,0,4],[2,2,1,9]], [1,2,1]
 Output: 11
 Explanation:
 The price of A is $2, and $3 for B, $4 for C.
 You may pay $4 for 1A and 1B, and $9 for 2A ,2B and 1C.
 You need to buy 1A ,2B and 1C, so you may pay $4 for 1A and 1B (special offer #1), and $3 for 1B, $4 for 1C.
 You cannot add more items, though only $9 for 2A ,2B and 1C.
 */
public class n638ShoppingOffers {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return 0;
    }
}
