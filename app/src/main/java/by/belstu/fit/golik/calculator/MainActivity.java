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
    Button btnOne,btnTwo,btnThree,btnFour,btnFive,btnSix,btnSeven,btnEight,btnNine,btnZero;
    Button btnPlus, btnMinus, btnMulti, btnDiv, btnEqual, btnClear;
    TextView tvLCD;

    double operand1,operand2;
    int flagAction;
    double result;
    Object[] binaryArgs;
    Object[] unaryArgs;

    Calculation obj = new Calculation();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOne=(Button) findViewById(R.id.btnOne);
        btnTwo=(Button) findViewById(R.id.btnTwo);
        btnThree=(Button) findViewById(R.id.btnThree);
        btnFour=(Button) findViewById(R.id.btnFour);
        btnFive=(Button) findViewById(R.id.btnFive);
        btnSix=(Button) findViewById(R.id.btnSix);
        btnSeven=(Button) findViewById(R.id.btnSeven);
        btnEight=(Button) findViewById(R.id.btnEight);
        btnNine=(Button) findViewById(R.id.btnNine);
        btnZero=(Button) findViewById(R.id.btnZero);
        btnPlus=(Button) findViewById(R.id.btnPlus);
        btnMinus=(Button) findViewById(R.id.btnMinus);
        btnMulti=(Button) findViewById(R.id.btnMulti);
        btnDiv=(Button) findViewById(R.id.btnDiv);
        btnClear=(Button) findViewById(R.id.btnClear);
        btnEqual=(Button) findViewById(R.id.btnEqual);
        tvLCD=(TextView) findViewById(R.id.tvLCD);

        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnNine.setOnClickListener(this);
        btnZero.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnMulti.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnEqual.setOnClickListener(this);

        operand1=0; operand2=0; flagAction=0; result=0;
        tvLCD.setText(Double.toString(operand1));


        obj.InitOperation();
    }

    private void ClickNumber(int num)
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

    @Override
    public void onClick(View v)
    {
        //TODO: Подумать как убрать кучу свичей
        //TODO: потому что выглядит жутко и все остальное выглядит
        //TODO: В общем унифицировать вызов как-то.
        //походу никак. один черт выхватывать отдельные нажатия надо. смысл несколько теряется, оверхэд в общем
        switch (v.getId())
        {
            case R.id.btnOne:
                ClickNumber(1);
                break;
            case R.id.btnTwo:
                ClickNumber(2);
                break;
            case R.id.btnThree:
                ClickNumber(3);
                break;
            case R.id.btnFour:
                ClickNumber(4);
                break;
            case R.id.btnFive:
                ClickNumber(5);
                break;
            case R.id.btnSix:
                ClickNumber(6);
                break;
            case R.id.btnSeven:
                ClickNumber(7);
                break;
            case R.id.btnEight:
                ClickNumber(8);
                break;
            case R.id.btnNine:
                ClickNumber(9);
                break;
            case R.id.btnZero:
                ClickNumber(0);
                break;
            case R.id.btnPlus:
                if(flagAction==0)
                    flagAction=1;
                break;
            case R.id.btnMinus:
                if(flagAction==0)
                   // flagAction=2; Тестовая штука. по нажатию на минус считает корень
                    unaryArgs=new Object[]{new Double(operand1)};
                try{
                    result=obj.WorkWithOperations(OperationsType.unary,R.id.btnSquareRoot,unaryArgs);
                }
                catch (InvocationTargetException e) {}
                catch (IllegalAccessException e) {}
                tvLCD.setText(Double.toString(result));
                break;
            case R.id.btnDiv:
                if(flagAction==0)
                    flagAction=3;
                break;
            case R.id.btnMulti:
                if(flagAction==0)
                    flagAction=4;
                break;
            case R.id.btnEqual:
                switch((int) flagAction)
                {
                    case 1:
                        //result=operand1+operand2;
                       binaryArgs=new Object[]{new Double(operand1),new Double(operand2)};
                        try
                        {
                            result=obj.WorkWithOperations(OperationsType.binary,R.id.btnPlus,binaryArgs);
                        }
                        catch (InvocationTargetException e) {}
                        catch (IllegalAccessException e) {}
                        tvLCD.setText(Double.toString(result));
                        break;
                    case 2:
                        //result=operand1-operand2;
                        unaryArgs=new Object[]{new Double(operand1)};
                        try{
                            result=obj.WorkWithOperations(OperationsType.unary,R.id.btnSquareRoot,unaryArgs);
                        }
                        catch (InvocationTargetException e) {}
                        catch (IllegalAccessException e) {}
                        tvLCD.setText(Double.toString(result));
                        break;
                    case 3:
                        result=operand1/operand2;
                        break;
                    case 4:
                        result=operand1*operand2;
                        break;
                    default:
                        Toast.makeText(this,"Operation not specified",Toast.LENGTH_LONG);
                }
                if(flagAction!=0)
                {
                   // tvLCD.setText(Double.toString(result));
                    operand1=0;
                    operand2=0;
                    result=0;
                    flagAction=0;
                }
                break;
        }
    }
}
