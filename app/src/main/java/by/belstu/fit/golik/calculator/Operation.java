package by.belstu.fit.golik.calculator;

/**
 * Created by frost on 11.09.2017.
 */

public class Operation
{
    //Binary
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

    //Unary
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
    static public double ReverseSign(double operand1) {
        return -operand1;
    }

    //Constant
    static public int One() {
        return 1;
    }

    static public int Two() {
        return 2;
    }

    static public int Three() {
        return 3;
    }

    static public int Four() {
        return 4;
    }

    static public int Five() {
        return 5;
    }

    static public int Six() {
        return 6;
    }

    static public int Seven() {
        return 7;
    }

    static public int Eight() {
        return 8;
    }

    static public int Nine() {
        return 9;
    }

    static public int Zero() {
        return 0;
    }

    static public double Pi() {
        return Math.PI;
    }

    static public double E() {
        return Math.E;
    }

    // Make dot. Convert int to double
}
