import java.util.Stack;

public class ReverseStack {
    
    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        // Step 1: Pop the top element
        int top = stack.pop();

        // Step 2: Reverse the remaining stack
        reverseStack(stack);

        // Step 3: Insert the popped element at the bottom
        insertAtBottom(stack, top);
    }

    private static void insertAtBottom(Stack<Integer> stack, int item) {
        if (stack.isEmpty()) {
            stack.push(item);
            return;
        }

        
        int top = stack.pop();

        
        insertAtBottom(stack, item);

        
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("Original Stack: " + stack);
        reverseStack(stack);
        System.out.println("Reversed Stack: " + stack);  
    }
}
