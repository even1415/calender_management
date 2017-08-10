package com.sauce.mytablayout;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import static com.sauce.mytablayout.R.layout.list_memo;

/**
 * Created by Junyoung on 2016-06-23.
 */

public class Tab_List extends Fragment {
    View view;
    Button select;
    FloatingActionButton addListbtn;
    ListView memolist;
    myDBHelper myHelper;
    SQLiteDatabase sqlDB;
    Cursor cursor;
    String[] title = {"내일 주말!!", "개강 한달전..."};
    String[] memo = {"얗얗얗", "에이씽ㅠㅠ짱시러어어어엉T^ T"};
    String preview = new String();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_list, container, false);
        select = (Button) view.findViewById(R.id.select);
        addListbtn = (FloatingActionButton) view.findViewById(R.id.addListbtn);
        memolist = (ListView) view.findViewById(R.id.memoList);
        CustomList adapter = new CustomList(getActivity());

        memolist.setAdapter(adapter);

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Password.class);
                startActivity(intent);
            }
        });

        addListbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Insert_Schedule.class);
                startActivity(intent);
            }
        });

        memolist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(getContext(), title[+position], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), View_contents.class);

                intent.putExtra("title",title[position]);
                intent.putExtra("memo",memo[position]);
                intent.putExtra("position",position);
                startActivity(intent);
            }
        });

        return view;
    }


    public class CustomList extends ArrayAdapter<String> {
        private final Activity context;
        public CustomList(Activity context) {
            super(context, list_memo, title);
            this.context = context;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = inflater.inflate(list_memo, null, true);
            TextView list_title = (TextView) rowView.findViewById(R.id.list_title);
            TextView list_memo = (TextView) rowView.findViewById(R.id.list_memo);


            /*
            sqlDB = myHelper.getReadableDatabase();
            cursor = sqlDB.rawQuery("SELECT * FROM groupTBL;", null);

            while (cursor.moveToNext()) {
                title[position] = cursor.getString(0);
                memo[position] = cursor.getString(1);
            }
            cursor.close();
            sqlDB.close();
            */



            if(memo[position].length()>10) {
                preview = memo[position].substring(0,10);
                preview += " ...";
            } //미리보기 작업(앞의 일부분만 보이게)
            else preview = memo[position];

            list_title.setText(title[position]);
            list_memo.setText(preview);

            return rowView;
        }
    }
}


/*


sqlDB = myHelper.getReadableDatabase();
                cursor = sqlDB.rawQuery("SELECT * FROM groupTBL;", null);

                String strNames = "그룹 이름" + "\r\n" + "----------" + "\r\n";
                String strNumbers = "인원" + "\r\n" + "----------" + "\r\n";

                while (cursor.moveToNext()) {
                    strNames += cursor.getString(0) + "\r\n";
                    strNumbers += cursor.getString(1) + "\r\n";
                }

                //이 부분에 list에 표시

                cursor.close();
                sqlDB.close();
 */