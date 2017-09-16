package by.belstu.fit.golik.calculator;


import java.util.HashMap;
import java.lang.reflect.*;

/**
 * Created by frost on 11.09.2017.
 */

public class Calculation
{
    private HashMap<Integer, String> _operationHashMap = new HashMap<>(); //Operation dictionary, [ID] [Operation Name].
    private String _operationName=null;
    private Method _method=null;
    private Class _clazz = Operation.class;  //Get class for reflection.
    private static double _result;

    public void InitOperation() //Filling in the dictionary.
    {
        //Binary operation.
        _operationHashMap.put(R.id.btnPlus,"Plus");
        _operationHashMap.put(R.id.btnMinus, "Minus");
        _operationHashMap.put(R.id.btnDiv, "Div");
        _operationHashMap.put(R.id.btnMulti, "Multi");

        //Unary operation.
        _operationHashMap.put(R.id.btnSquareRoot,"Square");
        _operationHashMap.put(R.id.btnCos, "Cos");
        _operationHashMap.put(R.id.btnSin, "Sin");
        _operationHashMap.put(R.id.btnTan, "Tan");
        _operationHashMap.put(R.id.btnReverseSign, "ReverseSign");

        //Constant operation.
        _operationHashMap.put(R.id.btnOne, "One");
        _operationHashMap.put(R.id.btnTwo, "Two");
        _operationHashMap.put(R.id.btnThree, "Three");
        _operationHashMap.put(R.id.btnFour, "Four");
        _operationHashMap.put(R.id.btnFive, "Five");
        _operationHashMap.put(R.id.btnSix, "Six");
        _operationHashMap.put(R.id.btnSeven, "Seven");
        _operationHashMap.put(R.id.btnEight, "Eight");
        _operationHashMap.put(R.id.btnNine, "Nine");
        _operationHashMap.put(R.id.btnZero, "Zero");
        _operationHashMap.put(R.id.btnPi, "Pi");
        _operationHashMap.put(R.id.btnE, "E");
    }

    public void WorkWithOperations(OperationsType opType, Integer operationsId, Object[] args) throws InvocationTargetException, IllegalAccessException {
        _operationName = _operationHashMap.get(operationsId);  //Get the operation name from the dictionary by id.
        switch (opType) {
            case binary:
                try {
                    _method = _clazz.getMethod(_operationName, new Class[]{double.class, double.class}); //Get operation by name.
                }
                catch (NoSuchMethodException e) {}
                _result = (double) _method.invoke(null, args);
                break;
            case unary:
               try{
                   _method=_clazz.getMethod(_operationName,new Class[]{double.class});
               }
               catch (NoSuchMethodException e){}
                _result = (double) _method.invoke(null, args);
                MainActivity.tvLCD.setText(Double.toString(_result)); //For beauty. Unary operations
                // are considered immediately.
                MainActivity.operand1 = 0;
                MainActivity.operand2 = 0;
                MainActivity.operand1 = _result;                        //For the possibility of continuing calculations.
                MainActivity.flagAction = 1;
                _result = 0;
                break;
            case equal:
                MainActivity.tvLCD.setText(Double.toString(_result));
                MainActivity.operand1 = 0;
                MainActivity.operand2 = 0;
                MainActivity.operand1 = _result;                       ////For the possibility of continuing calculations.
                MainActivity.flagAction = 1;
                _result = 0;
                break;
            case constant:
                //For enter number.
                try {
                    _method = _clazz.getMethod(_operationName, null); //Get operation by name.
                } catch (NoSuchMethodException e) {
                }
                MainActivity.ClickNumber((double) _method.invoke(null, args));
                break;
        }
    }
}
