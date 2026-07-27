import java.util.Stack;
import java.util.Scanner;

class InfixConversion {

    // Function to check precedence
    static int prec(char c) {
        if (c == '+' || c == '-') return 1;
        if (c == '*' || c == '/') return 2;
        return 0;
    }

    // Infix to Postfix conversion
    static String toPostfix(String exp) {
        String post = "";
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            // Operand
            if (Character.isLetterOrDigit(ch)) {
                post += ch;
            }
            // Opening bracket
            else if (ch == '(') {
                st.push(ch);
            }
            // Closing bracket
            else if (ch == ')') {
                while (st.peek() != '(')
                    post += st.pop();
                st.pop(); // remove '('
            }
            // Operator
            else {
                while (!st.isEmpty() && prec(ch) <= prec(st.peek()))
                    post += st.pop();
                st.push(ch);
            }
        }

        // Pop remaining operators
        while (!st.isEmpty())
            post += st.pop();

        return post;
    }

    // Infix to Prefix conversion
    static String toPrefix(String exp) {

        // Reverse infix expression
        String rev = new StringBuilder(exp).reverse().toString();

        // Swap brackets
        rev = rev.replace('(', '#')
                 .replace(')', '(')
                 .replace('#', ')');

        // Convert to postfix
        String post = toPostfix(rev);

        // Reverse postfix to get prefix
        return new StringBuilder(post).reverse().toString();
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Infix Expression: ");
        String infix = sc.nextLine();

        System.out.println("Postfix Expression: " + toPostfix(infix));
        System.out.println("Prefix Expression : " + toPrefix(infix));

        sc.close();
    }
}
