package by.belstu.fit.golik.calculator;

/**
 * Created by frost on 11.09.2017.
 */

public class Operation // implements IOperation
{
   static public double Plus(double operand1, double operand2) {
        return operand1+operand2;
    }

    static public double Minus(double operand1, double operand2) {
        return operand1-operand2;
    }

    static public double Multi(double operand1, double operand2) {
        return operand1*operand2;
    }

    static public double Div(double operand1, double operand2) {
        return operand1/operand2;
    }

    static public double Sin(double operand1) {
        return Math.sin(operand1);
    }

    static public double Cos(double operand1) {
        return Math.cos(operand1);
    }

    static public double Tan(double operand1) {
        return Math.tan(operand1);
    }

    static public double Square(double operand1) {
        return Math.sqrt(operand1);
    }

    //static public double Pi() { return Math.PI; }

    static public double ReverseSign(double operand1) {
        return -operand1;
    }
    // Make dot. Convert int to double
}
