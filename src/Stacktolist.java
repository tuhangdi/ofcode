import java.util.Stack;

/**
 * Created by thd on 2017/2/24.
 */
public class Stacktolist {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    public static void main(String[] args){
        Stacktolist stl = new Stacktolist();
        stl.push(1);
        stl.push(2);
        stl.push(3);
        System.out.println(stl.pop());
        System.out.println(stl.pop());
        System.out.println(stl.pop());
    }
}
