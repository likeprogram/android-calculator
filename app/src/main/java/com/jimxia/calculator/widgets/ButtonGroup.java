package com.jimxia.calculator.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ButtonGroup extends FrameLayout {
    private int mColNum = 4;
    private int mScreenWidth;
    private int childMargin = 30; // pixel

    public ButtonGroup(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mScreenWidth = context.getResources().getDisplayMetrics().widthPixels;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int count = getChildCount();
        if (count <= 0) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }

        // 简单处理，margin情况
        // 按钮宽高一样，显示为正方形
        final int totalWidth = mScreenWidth;
        int availableWidth = totalWidth - getPaddingLeft() - getPaddingRight();
        availableWidth -= (childMargin * (mColNum + 1)); // 去掉button之间margin
        int rowNum = count / mColNum + count % mColNum;
        int btnWidth = availableWidth / mColNum;
        final int totalHeight = btnWidth * rowNum + childMargin * (rowNum + 1);

        setMeasuredDimension(totalWidth, totalHeight);

        widthMeasureSpec = MeasureSpec.makeMeasureSpec(btnWidth, MeasureSpec.EXACTLY);
        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            if (child.getVisibility() != GONE) {
                measureChildWithMargins(child, widthMeasureSpec, 0, widthMeasureSpec, 0);
            }
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        final int btnCount = getChildCount();
        if (btnCount <= 0) {
            super.onLayout(changed, left, top, right, bottom);
            return;
        }

        int childLeft = childMargin, childTop = childMargin, childWidth, childHeight;
        int rowBtnCount = 0;
        for (int i = 0; i < btnCount; i ++) {
            final View child = getChildAt(i);
            if (child != null && child.getVisibility() != GONE) {
                childWidth = child.getMeasuredWidth();
                childHeight = child.getMeasuredHeight();
                child.layout(childLeft, childTop, childLeft + childWidth, childTop + childHeight);
                childLeft += (childWidth + childMargin);
                rowBtnCount ++;
                if (rowBtnCount == mColNum) {
                    // 换行
                    childLeft = childMargin;
                    childTop += (childHeight + childMargin);
                    rowBtnCount = 0;
                }
            }
        }
    }
}
