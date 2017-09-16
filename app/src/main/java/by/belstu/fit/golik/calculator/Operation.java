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
    static public double Sin(double operand) {
        return Math.sin(operand);
    }
    static public double Cos(double operand) {
        return Math.cos(operand);
    }
    static public double Tan(double operand) {
        return Math.tan(operand);
    }
    static public double Square(double operand) {
        return Math.sqrt(operand);
    }
    static public double ReverseSign(double operand) {
        return -operand;
    }

    //Constant
    static public double One() {
        return 1;
    }

    static public double Two() {
        return 2;
    }

    static public double Three() {
        return 3;
    }

    static public double Four() {
        return 4;
    }

    static public double Five() {
        return 5;
    }

    static public double Six() {
        return 6;
    }

    static public double Seven() {
        return 7;
    }

    static public double Eight() {
        return 8;
    }

    static public double Nine() {
        return 9;
    }

    static public double Zero() {
        return 0;
    }
    static public double Pi() {
        return Math.PI;
    }
    static public double E() {
        return Math.E;
    }

    // Make dot.
}
