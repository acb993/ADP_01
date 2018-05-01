package alg;

import core.Stack;

public class VollständigGeklammerterAlgebraischerAusdrücke {

    private static final String CLOSING_BRACKET = ")";
    private static final String ADDITION_OPERATOR = "+";
    private static final String SUBSTRACTION_OPERATOR = "-";
    private static final String MULTIPLICATION_OPERATOR = "*";
    private static final String DIVISION_OPERATOR = "/";

    public static void main(String[] args) {
        String temp = "((6 * (4+2))+(5-1))";
        System.out.println(doSomeMath(temp));
    }

    /***
     * Auswertung von Klammerausdrücken via Stack
     *
     * Ich bin gerade zu faul einen Text zu schreiben..
     * TODO: Beschreibung fürs JavaDoc
     * TODO: REGEX zur Kontrolle einer angemessenen Eingabe-Syntax + Exception
     * TODO: Testen :)
     * */
    private static String doSomeMath(String bracketedExpression) {
        Integer operand2;
        String operator;
        Integer operand1;
        Stack<String> stack = new Stack<String>();

        //Hole jeden Char
        for (String token : bracketedExpression.replaceAll("\\s+", "").split("(?!^)")) {

            //Wenn auf ")" getroffen wird, beginnt eine Operation indem die nötigen Sachen wieder vom
            //Stack genommen werden. Das Ergebnis wird wieder drauf gelegt.
            if (token.equals(CLOSING_BRACKET)) {
                operand2 = Integer.valueOf(stack.pop());
                operator = stack.pop();
                operand1 = Integer.valueOf(stack.pop());
                stack.pop(); //die "(" Klammer

                if (operator.equals(ADDITION_OPERATOR)) {
                    stack.push(Integer.toString(operand1 + operand2));

                } else if (operator.equals(SUBSTRACTION_OPERATOR)) {
                    stack.push(Integer.toString(operand1 - operand2));

                } else if (operator.equals(MULTIPLICATION_OPERATOR)) {
                    stack.push(Integer.toString(operand1 * operand2));

                } else if (operator.equals(DIVISION_OPERATOR)) {
                    stack.push(Integer.toString(operand1 / operand2));
                }
            } else
                //Ohne "(" wird einfach fleißig hinzugefügt
                stack.push(token);
        }

        //Ergbnis time!
        return stack.pop();
    }
}
