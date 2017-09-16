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
    Button btnTmp;
    public static TextView tvLCD;

    public static double operand1, operand2;
    static int flagAction;
    private static int _operationId;
    Object[] binaryArgs;
    Object[] unaryArgs;
    Object[] constantArgs;

    Calculation obj = new Calculation();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnClear=(Button) findViewById(R.id.btnClear);
        tvLCD=(TextView) findViewById(R.id.tvLCD);

        btnClear.setOnClickListener(this);

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
            operand1=operand1*10+num;
            tvLCD.setText(Double.toString(operand1));
        }
        else
        {
            operand2=operand2*10+num;
            tvLCD.setText(Double.toString(operand2));
        }
    }

    //For each type of operation its own handler.

    public void ConstantOperationOnClick(View v) throws InvocationTargetException, IllegalAccessException {
/*        btnTmp = (Button) findViewById(v.getId());
        constantArgs = new Object[]{new String((String) btnTmp.getText())};*/
        obj.WorkWithOperations(OperationsType.constant, v.getId(), null);
    }

    public void UnaryOperationOnClick(View v) throws InvocationTargetException, IllegalAccessException {
        unaryArgs = new Object[]{new Double(operand1)};
        obj.WorkWithOperations(OperationsType.unary, v.getId(), unaryArgs);
    }

    public void BinaryOperationOnClick(View v) {
        flagAction = 1;
        _operationId = v.getId();
    }

    public void EqualOperationOnClick(View v) throws InvocationTargetException, IllegalAccessException {
        if (flagAction == 1) {
            binaryArgs = new Object[]{new Double(operand1), new Double(operand2)};
            obj.WorkWithOperations(OperationsType.binary, _operationId, binaryArgs);
            obj.WorkWithOperations(OperationsType.equal, null, null);
        }
        flagAction = 0;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnClear:
                operand1 = 0;
                operand2 = 0;
                tvLCD.setText("0.0");
                break;
        }
    }
}
