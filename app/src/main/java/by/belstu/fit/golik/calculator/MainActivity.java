package by.belstu.fit.golik.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.InvocationTargetException;

enum OperationsType
{
    unary,
    binary,
    equal,
    constant
}

public class MainActivity extends AppCompatActivity implements OnClickListener
{
    Button btnClear;
    Button btnDot;
    public static TextView tvLCD;

    public static double operand1, operand2;
    static int flagAction;
    private static int _operationId;
    private static boolean _checkPoint = false;
    private static int _degree = 0;
    Object[] binaryArgs;
    Object[] unaryArgs;

    Calculation obj = new Calculation();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnClear=(Button) findViewById(R.id.btnClear);
        btnDot = (Button) findViewById(R.id.btnDot);
        tvLCD=(TextView) findViewById(R.id.tvLCD);

        btnClear.setOnClickListener(this);
        btnDot.setOnClickListener(this);

        operand1 = 0;
        operand2 = 0;
        flagAction = 0;
        tvLCD.setText(Double.toString(operand1));


        obj.InitOperation();
    }

    public static void ClickNumber(double num)
    {
        if(flagAction==0)
        {
            if (_checkPoint) {
                _degree++;
                operand1 = operand1 + num / Math.pow(10, _degree);
                tvLCD.setText(Double.toString(operand1));
            } else {
                operand1 = operand1 * 10 + num;
                tvLCD.setText(Double.toString(operand1));
            }
        }
        else
        {
            if (_checkPoint) {
                _degree++;
                operand2 = operand2 + num / Math.pow(10, _degree);
                tvLCD.setText(Double.toString(operand2));
            } else {
                operand2 = operand2 * 10 + num;
                tvLCD.setText(Double.toString(operand2));
            }
        }
    }

    //For each type of operation its own handler.

    public void ConstantOperationOnClick(View v) throws InvocationTargetException, IllegalAccessException {
        obj.WorkWithOperations(OperationsType.constant, v.getId(), null);
    }

    public void UnaryOperationOnClick(View v) throws InvocationTargetException, IllegalAccessException {
        unaryArgs = new Object[]{new Double(operand1)};
        obj.WorkWithOperations(OperationsType.unary, v.getId(), unaryArgs);
        _degree = 0;
        _checkPoint = false;
    }

    public void BinaryOperationOnClick(View v) {
        flagAction = 1;
        _operationId = v.getId();
        _degree = 0;
        _checkPoint = false;
    }

    public void EqualOperationOnClick(View v) throws InvocationTargetException, IllegalAccessException {
        if (flagAction == 1) {
            binaryArgs = new Object[]{new Double(operand1), new Double(operand2)};
            obj.WorkWithOperations(OperationsType.binary, _operationId, binaryArgs);
            obj.WorkWithOperations(OperationsType.equal, null, null);
        }
        flagAction = 0;
        _degree = 0;
        _checkPoint = false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnClear:
                operand1 = 0;
                operand2 = 0;
                _degree = 0;
                _checkPoint = false;
                tvLCD.setText("0.0");
                break;
            case R.id.btnDot:
                _checkPoint = true;
                break;
        }
    }
}
