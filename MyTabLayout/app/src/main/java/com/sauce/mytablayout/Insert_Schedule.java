package com.sauce.mytablayout;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

/**
 * Created by even1415 on 2017-07-31.
 */

public class Insert_Schedule extends AppCompatActivity implements TimePicker.OnTimeChangedListener {
    Button save;
    DatePicker datePicker;
    TimePicker timePicker;
    EditText title, memo;
    myDBHelper myHelper;
    SQLiteDatabase sqlDB;

    int dateYear, dateMonth, dateDay, timeHour, timeMinute;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert_schedule);

        save = (Button)findViewById(R.id.save);
        datePicker = (DatePicker)findViewById(R.id.date);
        timePicker = (TimePicker)findViewById(R.id.time);
        title = (EditText)findViewById(R.id.title);
        memo = (EditText)findViewById(R.id.memo);

        timePicker.setIs24HourView(true);
        timePicker.setOnTimeChangedListener(this);

        myHelper = new myDBHelper(this);

        datePicker.init(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int day) {
//                dateYear = String.format("%d", year);
//                dateMonth = String.format("%d", month+1);
//                dateDay = String.format("%d", day);
                dateYear = year;
                dateMonth = month+1;
                dateDay = day;
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase();
                sqlDB.execSQL("INSERT INTO groupTBL VALUES ( '"
                        + title.getText().toString() + "', '"
                        + memo.getText().toString() + "', '"
                        + dateYear + "', '"
                        + dateMonth + "', '"
                        + dateDay + "', '"
                        + timeHour + "', '"
                        + timeMinute + "');");
                sqlDB.close();
                Toast.makeText(getApplicationContext(), "저장되었습니다.", Toast.LENGTH_SHORT).show();

                //이 부분에 조회페이지 출력
                sqlDB = myHelper.getReadableDatabase();
                Cursor cursor;
                cursor = sqlDB.rawQuery("SELECT * FROM groupTBL;", null);

                String str = "데이터베이스 확인" + "\r\n";

                while (cursor.moveToNext()) {
                    str += cursor.getString(0) + cursor.getString(1) + cursor.getString(2)
                           + cursor.getString(3) + cursor.getString(4) + cursor.getString(5)
                           + cursor.getString(6) + "\r\n";
                }

                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();

                cursor.close();
                sqlDB.close();
            }
        });
    }

    @Override
    public void onTimeChanged(TimePicker timePicker, int hour, int minute) {
//        timeHour = String.format("%d", hour);
//        timeMinute = String.format("%d", minute);
        timeHour = hour;
        timeMinute = minute;
    }
}
