package com.jish.shangjitoutiao.util;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Adminjs on 2018/2/1.
 */

public class BanViewPager extends ViewPager {

    private boolean isCanScroll = true;

    public BanViewPager(Context context) {

 super(context);

    }

    public BanViewPager(Context context, AttributeSet attrs) {

 super(context, attrs);

    }

    public void setNoScroll(boolean noScroll) {

 this.isCanScroll = noScroll;

    }

    @Override

    public void scrollTo(int x, int y) {

  super.scrollTo(x, y);

    }

    @Override

    public boolean onTouchEvent(MotionEvent arg0) {

 if (isCanScroll){

 return false;

 }else{

return super.onTouchEvent(arg0);

}

    }

    @Override

    public boolean onInterceptTouchEvent(MotionEvent arg0) {

 if (isCanScroll){

 return false;

 }else{

 return super.onInterceptTouchEvent(arg0);

 }

}

}