package com.contact.yen.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView mTvInput;
    private TextView mTvResoult;

    private Button mBtnNumber0;
    private Button mBtnNumber1;
    private Button mBtnNumber2;
    private Button mBtnNumber3;
    private Button mBtnNumber4;
    private Button mBtnNumber5;
    private Button mBtnNumber6;
    private Button mBtnNumber7;
    private Button mBtnNumber8;
    private Button mBtnNumber9;

    private Button mBtnAC;
    private Button mBtnSoAM;
    private Button mBtnRate;
    private Button mBtnAdd;
    private Button mBtnSub;
    private Button mBtnMul;
    private Button mBtnDiv;
    private Button mBtnDot;
    private Button mBtnResult;

    public ArrayList<String> arrOperation;
    public ArrayList<Double> arrNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setEvenClick();
    }
    public void init(){
        mTvInput = findViewById(R.id.text_input);
        mTvResoult = findViewById(R.id.text_result);

        mBtnAC = findViewById(R.id.button_ac);
        mBtnRate = findViewById(R.id.button_rate);
        mBtnDiv = findViewById(R.id.button_div);
        mBtnSoAM = findViewById(R.id.button_soam);
        mBtnDot= findViewById(R.id.button_dot);
        mBtnAdd = findViewById(R.id.button_add);
        mBtnSub = findViewById(R.id.button_sub);
        mBtnResult = findViewById(R.id.button_result);
        mBtnMul = findViewById(R.id.button_mul);

        mBtnNumber7 = findViewById(R.id.button_7);
        mBtnNumber8= findViewById(R.id.button_8);
        mBtnNumber9= findViewById(R.id.button_9);
        mBtnNumber6 = findViewById(R.id.button_6);
        mBtnNumber5 = findViewById(R.id.button_5);
        mBtnNumber4 = findViewById(R.id.button_4);
        mBtnNumber3 = findViewById(R.id.button_3);
        mBtnNumber2 = findViewById(R.id.button_2);
        mBtnNumber1= findViewById(R.id.button_1);
        mBtnNumber0 = findViewById(R.id.button_0);

    }
    public void setEvenClick(){
        mBtnNumber0.setOnClickListener(this);
        mBtnNumber1.setOnClickListener(this);
        mBtnNumber2.setOnClickListener(this);
        mBtnNumber3.setOnClickListener(this);
        mBtnNumber4.setOnClickListener(this);
        mBtnNumber5.setOnClickListener(this);
        mBtnNumber6.setOnClickListener(this);
        mBtnNumber7.setOnClickListener(this);
        mBtnNumber8.setOnClickListener(this);
        mBtnNumber9.setOnClickListener(this);

        mBtnAC.setOnClickListener(this);
        mBtnSoAM.setOnClickListener(this);
        mBtnRate.setOnClickListener(this);
        mBtnAdd.setOnClickListener(this);
        mBtnSub.setOnClickListener(this);
        mBtnMul.setOnClickListener(this);
        mBtnDiv.setOnClickListener(this);
        mBtnDot.setOnClickListener(this);
        mBtnResult.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_0:{
                mTvInput.append("0");
                break;
            }
            case R.id.button_1:{
                mTvInput.append("1");
                break;
            }
            case R.id.button_2:{
                mTvInput.append("2");
                break;
            }
            case R.id.button_3:{
                mTvInput.append("3");
                break;
            }
            case R.id.button_4:{
                mTvInput.append("4");
                break;
            }
            case R.id.button_5:{
                mTvInput.append("5");
                break;
            }
            case R.id.button_6:{
                mTvInput.append("6");
                break;
            }
            case R.id.button_7:{
                mTvInput.append("7");
                break;
            }
            case R.id.button_8:{
                mTvInput.append("8");
                break;
            }
            case R.id.button_9:{
                mTvInput.append("9");
                break;
            }
            case R.id.button_add:{
                mTvInput.append("+");
                break;
            }
            case R.id.button_sub:{
                mTvInput.append("-");
                break;
            }
            case R.id.button_mul:{
                mTvInput.append("x");
                break;
            }
            case R.id.button_div:{
                mTvInput.append("/");
                break;
            }
            case R.id.button_ac:{
                mTvInput.setText(" ");
                break;
            }
            case R.id.button_rate:{
                mTvInput.append("%");
                break;
            }
            case R.id.button_result:{
                DecimalFormat df = new DecimalFormat("###.#######");
                double result = 0;
                addOperation(mTvInput.getText().toString());
                addNumber(mTvInput.getText().toString());
                if(arrOperation.size()>=arrNumber.size() ||arrOperation.size()<1){
                    mTvResoult.setText("Lỗi định dạng");
                }else {
                    for (int i = 0; i < (arrNumber.size() - 1); i++) {
                        switch (arrOperation.get(i)) {
                            case "+":
                                if (i == 0) {
                                    result = arrNumber.get(i) + arrNumber.get(i + 1);
                                } else {
                                    result = result + arrNumber.get(i + 1);
                                }
                                break;
                            case "-":
                                if (i == 0) {
                                    result = arrNumber.get(i) - arrNumber.get(i + 1);
                                } else {
                                    result = result - arrNumber.get(i + 1);
                                }
                                break;
                            case "x":
                                if (i == 0) {
                                    result = arrNumber.get(i) * arrNumber.get(i + 1);
                                } else {
                                    result = result * arrNumber.get(i + 1);
                                }
                                break;
                            case "/":
                                if (i == 0) {
                                    result = arrNumber.get(i) / arrNumber.get(i + 1);
                                } else {
                                    result = result / arrNumber.get(i + 1);
                                }
                                break;
                            default:
                                break;
                        }
                    }
                    mTvResoult.setText(df.format(result) + "");
                }
            }
        }
    }



    public void addOperation(String input) {
        arrOperation = new ArrayList<>();

        char[] cArray = input.toCharArray();
        for (int i = 0; i < cArray.length; i++) {
            switch (cArray[i]) {
                case '+':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '-':
                    arrOperation.add(cArray[i] + "");
                    break;
                case 'x':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '/':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '%':
                    arrOperation.add(cArray[i] + "");
                    break;
                default:
                    break;
            }
        }
    }
    public void addNumber(String stringInput) {
        arrNumber = new ArrayList<>();
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = regex.matcher(stringInput);
        while(matcher.find()){
            arrNumber.add(Double.valueOf(matcher.group(1)));
        }
    }

}

