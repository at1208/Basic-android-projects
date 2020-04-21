package me.amantiwari.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView  tableList;

    public void generateTimeTable(int timetableNum){
        final  ArrayList<String> timeTableList = new ArrayList<String>();
        for(int j =1; j<=10; j++){
            timeTableList.add(Integer.toString(j* timetableNum));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timeTableList);
       tableList.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



          tableList = findViewById(R.id.tableList);
          SeekBar  seekBar = findViewById(R.id.seekBar);

           seekBar.setMax(20);
           seekBar.setProgress(1);

           seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
               @Override
               public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                   int min = 1;
                   int timetableNum;

                   if (progress < min){
                     timetableNum = min;
                     seekBar.setProgress(min);
                   } else {
                       timetableNum = progress;
                   }

                   Log.i("seekbar value",Integer.toString(timetableNum));
                     generateTimeTable(timetableNum);
               }

               @Override
               public void onStartTrackingTouch(SeekBar seekBar) {

               }

               @Override
               public void onStopTrackingTouch(SeekBar seekBar) {

               }
           });

    }
}
