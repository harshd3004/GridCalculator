package com.example.gridcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText inpBox;
    float num1,num2;
    GridView gv;
    char op;
    String btns[] = {"C", "%", "Del", "/",
                    "7", "8", "9", "X",
                    "4", "5", "6", "+",
                    "1","2","3","-",
                    "00","0",".","="};

    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inpBox = (EditText) findViewById(R.id.inpBox);

        adapter = new ArrayAdapter(this,R.layout.simple_button,btns);
        gv = (GridView) findViewById(R.id.gvBtns);

        gv.setAdapter(adapter);
    }
    public void buttonClicked(View v){
        Button btn = (Button) v;
        String ch = btn.getText().toString();
        int no=-1;
        try {
            no = Integer.parseInt(ch);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(no>=0 && no<=9){
            inpBox.setText(inpBox.getText().toString() + no);
        }
        if(ch.equals(".")){
            inpBox.setText(inpBox.getText().toString() + ch);
        }
        if(ch.equals("00")){
            inpBox.setText(inpBox.getText().toString() + "0");
        }
        if(ch.equals("C")){
            inpBox.setText("");
        }
        if(ch.equals("Del")){
            String str = inpBox.getText().toString();
            str = str.substring(0,str.length()-1);
            inpBox.setText(str);
        }

        if(ch.equals("%") || ch.equals("/") || ch.equals("X")||ch.equals("+")||ch.equals("-")){
            if(inpBox.getText().toString().isEmpty()){
                return;
            }
            num1 = Float.parseFloat(inpBox.getText().toString());
            inpBox.setText("");
            op = ch.charAt(0);
        }

        if(ch.equals("=")){
            num2 = Float.parseFloat(inpBox.getText().toString());
            float res;
            switch (op){
                case '%' : res = num1 %num2;
                    break;
                case 'X' : res = num1 *num2;
                    break;
                case '/' : res = num1 /num2;
                    break;
                case '+' : res = num1 +num2;
                    break;
                case '-' : res = num1 -num2;
                    break;
                default:res = 0;
            }
            inpBox.setText(Float.toString(res));
        }
    }
}