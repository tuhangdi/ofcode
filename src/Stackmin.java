import java.util.Stack;

/**
 * Created by thd on 2017/3/3.
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
public class Stackmin {
    Stack<Integer> data = new Stack<>();
    Stack<Integer> min = new Stack<>();
    public void push(int node) {
        data.push(node);
        if(min.size() == 0 || node < min.peek())
            min.push(node);
        else min.push(min.peek());
    }

    public void pop() {
        data.pop();
        min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return min.peek();
    }
    public static void main(String[] args){
        Stackmin sm = new Stackmin();
        sm.push(2);
        sm.push(1);
        sm.push(3);
        System.out.println(sm.min());
        System.out.println(sm.top());
        sm.pop();
        sm.pop();
        System.out.println(sm.min());

    }
}
