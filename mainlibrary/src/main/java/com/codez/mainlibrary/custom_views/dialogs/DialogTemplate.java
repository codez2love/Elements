package com.codez.mainlibrary.custom_views.dialogs;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;

/**
 * Created by Eptron on 9/17/2015.
 */
public class DialogTemplate extends DialogFragment{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int style = DialogFragment.STYLE_NORMAL;
        int theme = android.R.style.Theme_Holo_Light_Dialog;
        setStyle(style, theme);
    }
}
