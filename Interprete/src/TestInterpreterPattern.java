import java.util.Stack;

public class TestInterpreterPattern {
    public static void main(String[] args) {

        String tokenString = "7 3 - 2 1 + *";
        Stack<Expression> stack = new Stack<Expression>();
        String[] tokenArray = tokenString.split(" ");
        for (String s : tokenArray) {
            if (ExpressionUtils.isOperator(s)) {
                Expression rightExpression = stack.pop();
                Expression leftExpression = stack.pop();
                Expression operator = ExpressionUtils.getOperator(s.charAt(0), leftExpression,rightExpression);
                int result = operator.interpret();
                stack.push(new Number(result));
            } else {
                Expression i = new Number(Integer.parseInt(s));
                stack.push(i);
            }
        }
        System.out.println("( "+tokenString+" ): "+stack.pop().interpret());

    }
}

interface Expression {
    public int interpret();
}

class Add implements Expression{

    private final Expression leftExpression;
    private final Expression rightExpression;

    public Add(Expression leftExpression,Expression rightExpression ){
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }
    @Override
    public int interpret() {
        return leftExpression.interpret() + rightExpression.interpret();
    }

}

class ExpressionUtils {

    public static boolean isOperator(String s) {
        if (s.equals("+") || s.equals("-") || s.equals("*"))
            return true;
        else
            return false;
    }

    public static Expression getOperator(char s, Expression left,	Expression right) {
        switch (s) {
            case '+':
                return new Add(left, right);
            case '-':
                return new Substract(left, right);
            case '*':
                return new Product(left, right);
        }
        return null;
    }

}

class Number implements Expression{

    private final int n;

    public Number(int n){
        this.n = n;
    }
    @Override
    public int interpret() {
        return n;
    }

}

class Product implements Expression{

    private final Expression leftExpression;
    private final Expression rightExpression;

    public Product(Expression leftExpression,Expression rightExpression ){
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }
    @Override
    public int interpret() {
        return leftExpression.interpret() * rightExpression.interpret();
    }
}

class Substract implements Expression{

    private final Expression leftExpression;
    private final Expression rightExpression;

    public Substract(Expression leftExpression,Expression rightExpression ){
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }
    @Override
    public int interpret() {
        return leftExpression.interpret() - rightExpression.interpret();
    }

}