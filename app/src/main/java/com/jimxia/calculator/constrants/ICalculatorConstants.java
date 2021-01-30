package com.jimxia.calculator.constrants;

public interface ICalculatorConstants {
    int BUTTON_COUNT = 20;

    int[] BUTTON_IDS = {
            ButtonIds.BUTTON_ID_BACK, ButtonIds.BUTTON_ID_LEFT, ButtonIds.BUTTON_ID_RIGHT, ButtonIds.BUTTON_ID_CE,

            ButtonIds.BUTTON_ID_7, ButtonIds.BUTTON_ID_8, ButtonIds.BUTTON_ID_9, ButtonIds.BUTTON_ID_DIV,

            ButtonIds.BUTTON_ID_4, ButtonIds.BUTTON_ID_5, ButtonIds.BUTTON_ID_6, ButtonIds.BUTTON_ID_MUL,

            ButtonIds.BUTTON_ID_1, ButtonIds.BUTTON_ID_2, ButtonIds.BUTTON_ID_3, ButtonIds.BUTTON_ID_ADD,

            ButtonIds.BUTTON_ID_0, ButtonIds.BUTTON_ID_DOT, ButtonIds.BUTTON_ID_EQU, ButtonIds.BUTTON_ID_SUB,
    };

    String[] BUTTON_TEXTS = {
            "Back", "(", ")", "CE",

            "7", "8", "9", "/",

            "4", "5", "6", "*",

            "1", "2", "3", "+",

            "0", ".", "=", "-",
    };

    interface Operator {
        byte NONE = 0;
        byte ADD = 1;
        byte SUB = 2;
        byte MUL = 3;
        byte DIV = 4;
    }

    /**
     * 按钮Id定义
     */
    interface ButtonIds {
        int BUTTON_ID_BASE = 1000;
        int BUTTON_ID_BACK = BUTTON_ID_BASE + 0;
        int BUTTON_ID_LEFT = BUTTON_ID_BASE + 1;
        int BUTTON_ID_RIGHT = BUTTON_ID_BASE + 2;
        int BUTTON_ID_CE = BUTTON_ID_BASE + 3;

        int BUTTON_ID_7 = BUTTON_ID_BASE + 4;
        int BUTTON_ID_8 = BUTTON_ID_BASE + 5;
        int BUTTON_ID_9 = BUTTON_ID_BASE + 6;
        int BUTTON_ID_DIV = BUTTON_ID_BASE + 7;

        int BUTTON_ID_4 = BUTTON_ID_BASE + 8;
        int BUTTON_ID_5 = BUTTON_ID_BASE + 9;
        int BUTTON_ID_6 = BUTTON_ID_BASE + 10;
        int BUTTON_ID_MUL = BUTTON_ID_BASE + 11;

        int BUTTON_ID_1 = BUTTON_ID_BASE + 12;
        int BUTTON_ID_2 = BUTTON_ID_BASE + 13;
        int BUTTON_ID_3 = BUTTON_ID_BASE + 14;
        int BUTTON_ID_ADD = BUTTON_ID_BASE + 15;

        int BUTTON_ID_0 = BUTTON_ID_BASE + 16;
        int BUTTON_ID_DOT = BUTTON_ID_BASE + 17;
        int BUTTON_ID_EQU = BUTTON_ID_BASE + 18;
        int BUTTON_ID_SUB = BUTTON_ID_BASE + 19;
    }
}
