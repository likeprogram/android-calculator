package com.jimxia.calculator.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.jimxia.androidcalculator.R;
import com.jimxia.calculator.constrants.ICalculatorConstants;
import com.jimxia.calculator.presenter.CalculatorPresenter;
import com.jimxia.calculator.presenter.ICalcPresenter;
import com.jimxia.calculator.widgets.ButtonGroup;

import static com.jimxia.calculator.constrants.ICalculatorConstants.BUTTON_COUNT;
import static com.jimxia.calculator.constrants.ICalculatorConstants.BUTTON_IDS;
import static com.jimxia.calculator.constrants.ICalculatorConstants.BUTTON_TEXTS;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ICalcView {
    private ButtonGroup mBtnGroup;
    private TextView theFirstView;
    private TextView theOptionView;
    private TextView theSecondView;
    private TextView theEqualView;
    private TextView theAnswerView;

    private ICalcPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();  //初始化布局
        mPresenter = new CalculatorPresenter(this);
    }

    @Override
    public void onClick(View view) {
        mPresenter.handleClickButton(view.getId(), ((Button) view).getText().toString());
    }

    public void initView() {
        mBtnGroup = findViewById(R.id.btn_group);
        theFirstView = findViewById(R.id.the_first_number);
        theOptionView = findViewById(R.id.the_option);
        theSecondView = findViewById(R.id.the_second_number);
        theEqualView = findViewById(R.id.the_equal);
        theAnswerView = findViewById(R.id.the_answer);

        // 初始化按钮
        for (int i = 0; i < BUTTON_COUNT; i ++) {
            Button btn = ButtonFactory.newButton(this);
            btn.setId(BUTTON_IDS[i]);
            switch (BUTTON_IDS[i]) {
                case ICalculatorConstants.ButtonIds.BUTTON_ID_BACK:
                    btn.setBackgroundResource(R.drawable.btn_background_gray);
                    break;
                case ICalculatorConstants.ButtonIds.BUTTON_ID_CE:
                    btn.setBackgroundResource(R.drawable.btn_background_orange_dark);
                    break;
                default:
                    btn.setBackgroundResource(R.drawable.btn_background_orange_light);
                    break;
            }
            btn.setText(BUTTON_TEXTS[i]);
            btn.setOnClickListener(this);
            mBtnGroup.addView(btn);
        }
    }

    // -------------- ICalcView方法实现 -----------------------
    @Override
    public void showFirstNumber(String text) {
        theFirstView.setText(text);
    }

    @Override
    public void showOperator(String operator) {
        theOptionView.setText(operator);
    }

    @Override
    public void showSecondNumber(String text) {
        theSecondView.setText(text);
    }

    @Override
    public void showEqual(String equal) {
        theEqualView.setText(equal);
    }

    @Override
    public void showResult(String result) {
        theAnswerView.setText(result);
    }

    @Override
    public void clear(){
        theFirstView.setText("");
        theSecondView.setText("");
        theOptionView.setText("");
        theEqualView.setText("");
        theAnswerView.setText("");
    }

    @Override
    public String getFirstNumber() {
        return theFirstView.getText().toString();
    }

    @Override
    public String getSecondNumber() {
        return theSecondView.getText().toString();
    }

    @Override
    public String getOperator() {
        return theOptionView.getText().toString();
    }

    @Override
    public String getResult() {
        return theAnswerView.getText().toString();
    }
}