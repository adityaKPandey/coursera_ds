package com.lesson1.week2;

public class EvaluateArithmeticExpression {

  public Double evaluate(String expression){
    StackArrayWithIterator<String> operandStack = new StackArrayWithIterator<>(10);
    StackArrayWithIterator<Character> operatorStack = new StackArrayWithIterator<>(10);

    Double result = 0D;

    for(Character c : expression.toCharArray()){
      char cVal = c.charValue() ;

      if(')' == cVal){
        Double operand1 = Double.parseDouble(operandStack.pop().toString());
        Double operand2 = Double.parseDouble(operandStack.pop().toString());

        char operator = operatorStack.pop();

        if(operator == '+')
          operandStack.push((operand1 + operand2)+"" );
        else if( operator == '*')
          operandStack.push((operand1 * operand2) + "");

      }else if ( cVal == '+' || cVal == '*'){
           operatorStack.push(cVal);
      }else if (cVal != '('){
        // single digit number
        operandStack.push(c.toString());
      }

    }

    return Double.parseDouble(operandStack.pop());
  }

  //TODO :Fix resizeOnPop : if size is 3 and top is at 0 , it resizes unnecessary and without size check in resize method , it fails
  public static void main (String [] args){
     EvaluateArithmeticExpression evaluateArithmeticExpression = new EvaluateArithmeticExpression();

     String expression = "(1+((2+3)*(4*5)))" ;
     System.out.println(evaluateArithmeticExpression.evaluate(expression));

  }

}
