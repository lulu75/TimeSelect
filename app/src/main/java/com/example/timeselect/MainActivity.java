package com.example.timeselect;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.jaaksi.pickerview.topbar.DefaultTopBar;
import org.jaaksi.pickerview.util.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Button btn_showtime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_showtime = findViewById(R.id.btn_showtime);

        btn_showtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TimeSelectPicker mTimePicker = new TimeSelectPicker.Builder(MainActivity.this, TimeSelectPicker.TYPE_TIME, new TimeSelectPicker.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(TimeSelectPicker picker, Date date, Date datestart) {
//                        Toast.makeText(MainActivity.this, picker.last + "", Toast.LENGTH_SHORT).show();
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                        String t1 = format.format(date);
                        String t2 = format.format(datestart);
                        Toast.makeText(MainActivity.this, t1 + "`"+t2, Toast.LENGTH_LONG).show();
                    }
                })
                        // 设置不包含超出的结束时间<=
                        .setContainsEndDate(false)
                        // 设置时间间隔为30分钟
                        .setTimeMinuteOffset(30)
                        .setRangDate(System.currentTimeMillis(), 1577976666000L)
                        .create();
                // 2018/2/5 03:14:11 - 2020/1/2 22:51:6
                Dialog pickerDialog = mTimePicker.getPickerDialog();
                pickerDialog.setCanceledOnTouchOutside(true);
                DefaultTopBar topBar = (DefaultTopBar) mTimePicker.getTopBar();
                topBar.getTitleView().setText("请选择时间");
                pickerDialog.show();


            }
        });

    }


}
