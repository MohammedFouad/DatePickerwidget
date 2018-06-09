package com.app.smart.datepickerwidget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class customToast extends AppCompatActivity {
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_toast);

        LayoutInflater inflater = getLayoutInflater();
         view = inflater.inflate(R.layout.activity_custom_toast,
                (ViewGroup)findViewById(R.id.relativeLayout1));
toastImage();

    }

    public void toastImage(){

        Toast toast = new Toast(this);
        toast.setView(view);
        toast.show();
    }
}
