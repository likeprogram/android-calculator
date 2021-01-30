package com.jimxia.calculator.view;

import android.content.Context;
import android.util.TypedValue;
import android.widget.Button;

public class ButtonFactory {
    public static Button newButton(Context context) {
        Button btn = new Button(context);
        btn.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        btn.setTransformationMethod(null); // 按钮字母默认大写，禁用这个特性
        return btn;
    }
}
