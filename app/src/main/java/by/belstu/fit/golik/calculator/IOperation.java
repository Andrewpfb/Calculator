package by.belstu.fit.golik.calculator;

/**
 * Created by frost on 07.09.2017.
 */

public interface IOperation
{
    double Plus(double operand1, double operand2);
    double Minus (double operand1, double operand2);
    double Multi (double operand1, double operand2);
    double Div (double operand1, double operand2);
    double Sin(double operand1);
    double Cos(double operand2);
    double Square (double operand1);
}
