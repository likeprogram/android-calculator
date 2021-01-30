package com.jimxia.calculator.view;

/**
 * 计算器view
 */
public interface ICalcView {

    void showFirstNumber(String text);
    void showOperator(String operator);
    void showSecondNumber(String text);
    void showEqual(String equal);
    void showResult(String result);
    void clear();

    String getFirstNumber();
    String getSecondNumber();
    String getOperator();
    String getResult();
}
