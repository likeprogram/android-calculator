package com.jimxia.calculator.presenter;

import com.jimxia.calculator.constrants.ICalculatorConstants.ButtonIds;
import com.jimxia.calculator.constrants.ICalculatorConstants.Operator;
import com.jimxia.calculator.view.ICalcView;

public class CalculatorPresenter implements ICalcPresenter {
    private ICalcView mView;

    private int mOperator = Operator.NONE;
    private String str1 = "",str2 = "";
    private double number1 ,number2;
    private int answerFlag = 0;

    public CalculatorPresenter(ICalcView view) {
        mView = view;
    }

    @Override
    public void handleClickButton(int id, String text) {
        switch (id) {
            case ButtonIds.BUTTON_ID_1:
            case ButtonIds.BUTTON_ID_2:
            case ButtonIds.BUTTON_ID_3:
            case ButtonIds.BUTTON_ID_4:
            case ButtonIds.BUTTON_ID_5:
            case ButtonIds.BUTTON_ID_6:
            case ButtonIds.BUTTON_ID_7:
            case ButtonIds.BUTTON_ID_8:
            case ButtonIds.BUTTON_ID_9:
                if (answerFlag == 0){
                    if (!hasOperator()) {
                        str1 = str1 + text;
                        mView.showFirstNumber(str1);
                    } else {
                        str2 = str2 + text;
                        mView.showSecondNumber(str2);
                    }
                } else if (answerFlag == 1) {
                    clear();
                    answerFlag = 0;
                    str1 = str1 + text;
                    mView.showFirstNumber(str1);
                }

                break;

            case ButtonIds.BUTTON_ID_DOT:
                if (str1 != "" && !hasOperator()) {
                    str1 = str1 + text;
                    mView.showFirstNumber(str1);
                } else if (hasOperator() && str2 != "") {
                    str2 = str2 + text;
                    mView.showSecondNumber(str2);
                } else {
                    //什么都不执行
                }
                break;

            case ButtonIds.BUTTON_ID_ADD:
                mOperator = Operator.ADD;
                mView.showOperator(text);
                break;

            case ButtonIds.BUTTON_ID_SUB:
                mOperator = Operator.SUB;
                mView.showOperator(text);
                break;

            case ButtonIds.BUTTON_ID_MUL:
                mOperator = Operator.MUL;
                mView.showOperator(text);
                break;

            case ButtonIds.BUTTON_ID_DIV:
                mOperator = Operator.DIV;
                mView.showOperator(text);
                break;

            case ButtonIds.BUTTON_ID_CE:
                clear();
                break;

            case ButtonIds.BUTTON_ID_BACK:
                if (mView.getResult() == "") {
                    if (mView.getSecondNumber() != "") {
                        int length = str2.length();
                        if (length == 1) {
                            mView.showSecondNumber("");
                        } else {
                            str2 = str2.substring(0,length-1);
                            mView.showSecondNumber(str2);
                        }
                        break;
                    }
                    if (mView.getSecondNumber() == "" && mView.getOperator() != "") {
                        mView.showOperator("");
                        break;
                    }
                    if (mView.getSecondNumber() == "" && mView.getResult() == "" && mView.getFirstNumber() != "") {
                        int length = str1.length();
                        if (length == 1) {
                            mView.showFirstNumber("");
                        } else {
                            str1 = str1.substring(0,length-1);
                            mView.showFirstNumber(str1);
                        }
                        break;
                    }
                }
                break;


            case ButtonIds.BUTTON_ID_EQU:
                mView.showEqual(text);
                doCalculate();
                break;

        }
    }

    private boolean hasOperator() {
        return mOperator != Operator.NONE;
    }

    private void doCalculate() {
        answerFlag = 1;

        number1 = Double.parseDouble(mView.getFirstNumber());
        number2 = Double.parseDouble(mView.getSecondNumber());

        switch (mOperator) {
            case Operator.ADD:
                mView.showResult(String.valueOf(number1 + number2));
                break;
            case Operator.SUB:
                mView.showResult(String.valueOf(number1 - number2));
                break;
            case Operator.MUL:
                mView.showResult(String.valueOf(number1 * number2));
                break;
            case Operator.DIV:
                if (number2 == 0) {
                    mView.showResult("错误");
                } else {
                    mView.showResult(String.valueOf(number1 / number2));
                }
                break;
        }
    }

    private void clear(){
        str1 = "";
        str2 = "";
        mOperator = Operator.NONE;

        mView.clear();
    }
}
