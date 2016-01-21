package com.codez.mainlibrary.custom_views.other;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.codez.mainlibrary.R;
import com.codez.mainlibrary.utilities.OtherUtils;

import java.util.ArrayList;

/**
 * The SlideIndicator resides at bottom right corner of the MultiBannerView and
 * keeps track which Slide is selected
 *
 * @author Claudiu Manea
 */
@SuppressLint("ViewConstructor")
public class SlideIndicator extends LinearLayout {

    private ArrayList<Boolean> actives;
    private Context mContext;
    private Drawable onIndicator;
    private Drawable offIndicator;

    private LayoutParams mParams;

    /**
     * @param context needed for the LinearLayout super class
     * @param size    How many indicators it should display
     */
    public SlideIndicator(Context context, int size) {
        super(context);
        mContext = context;
        onIndicator = context.getResources().getDrawable(
                R.drawable.selected);
        offIndicator = context.getResources().getDrawable(
                R.drawable.unselected);
        mParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);
        mParams.rightMargin = 8;
        actives = new ArrayList<Boolean>();
        for (int i = 0; i < size; i++)
            addSlide();
    }

    public void setActive(int pos) {
        actives.set(pos, true);
        setActiveBg(this.getChildAt(pos));
        for (int i = 0; i < this.getChildCount(); i++)
            if (i != pos)
                setInactiveBG(this.getChildAt(i));
    }

    /**
     * Adds a Slide (picture + item in the arrayList to track
     */
    private void addSlide() {
        View view = new ImageView(mContext);
        if (actives.isEmpty()) {
            actives.add(true);
            setActiveBg(view);
        } else {
            actives.add(false);
            setInactiveBG(view);
        }
        this.addView(view, mParams);
    }

    /**
     * Sets the background of the View to the onIndicator drawable
     *
     * @param v the View to set ON
     */
    private void setActiveBg(View v) {
        OtherUtils.setBG(v, onIndicator);
    }

    /**
     * Sets the background of the View to the offIndicator drawable
     *
     * @param v the View to set ON
     */
    private void setInactiveBG(View v) {
        OtherUtils.setBG(v, offIndicator);
    }

}
