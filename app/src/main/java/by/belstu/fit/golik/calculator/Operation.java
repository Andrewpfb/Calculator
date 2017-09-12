package by.belstu.fit.golik.calculator;

/**
 * Created by frost on 11.09.2017.
 */

public class Operation// implements IOperation
{

    //@Override
   static public double Plus(double operand1, double operand2) {
        return operand1+operand2;
    }

    //@Override
    static public double Minus(double operand1, double operand2) {
        return operand1-operand2;
    }

    //@Override
    static public double Multi(double operand1, double operand2) {
        return operand1*operand2;
    }

    //@Override
    static public double Div(double operand1, double operand2) {
        return operand1/operand2;
    }

    //@Override
    static public double Sin(double operand1) {
        return 0;
    }

    //@Override
    static public double Cos(double operand2) {
        return 0;
    }

    //@Override
    static public double Square(double operand1) {
        return Math.sqrt(operand1);
    }
}
