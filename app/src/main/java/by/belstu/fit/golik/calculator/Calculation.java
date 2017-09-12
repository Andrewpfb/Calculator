package by.belstu.fit.golik.calculator;

import java.util.Arrays;
import java.util.HashMap;
import java.lang.reflect.*;
import java.util.Objects;

/**
 * Created by frost on 11.09.2017.
 */

public class Calculation
{
    private HashMap<Integer,String> _operationHashMap=new HashMap<>(); //Operation dictionary, [ID] [Operation Name]
    private String _operationName=null;
    private Method _method=null;
    private Class _clazz = Operation.class;  //Get class for reflection

    public void InitOperation() //Filling in the dictionary
    {
        _operationHashMap.put(R.id.btnPlus,"Plus");
        _operationHashMap.put(R.id.btnSquareRoot,"Square");
    }

    public double WorkWithOperations(OperationsType opType, Integer operationsId, Object[]args) throws InvocationTargetException, IllegalAccessException {
        _operationName = _operationHashMap.get(operationsId);  //Get the operation name from the dictionary by id
        switch (opType) {
            case binary:
                try {
                    _method = _clazz.getMethod(_operationName,new Class[]{double.class,double.class}); //get operation by name
                }
                catch (NoSuchMethodException e) {}
                return (double) _method.invoke(null,args);
            case unary:
               try{
                   _method=_clazz.getMethod(_operationName,new Class[]{double.class});
               }
               catch (NoSuchMethodException e){}
                return (double) _method.invoke(null,args);
            case equal:
                return 0;
            case constant:
                return 0;
        }
        return 0;
    }
}
