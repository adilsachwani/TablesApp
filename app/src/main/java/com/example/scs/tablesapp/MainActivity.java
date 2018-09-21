package com.example.scs.tablesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listview);
        seekBar = (SeekBar) findViewById(R.id.seekbar);

        seekBar.setProgress(10);
        seekBar.setMax(20);
        createTable(10);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int min = 1;
                int currentTable;

                if(progress == 0)
                    currentTable = min;
                else
                    currentTable = progress;

                createTable(currentTable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void createTable(int table){
        ArrayList<String> tables = new ArrayList<String>();

        for(int i=1; i<=10; i++) {
            String t = table + " x " + i + " = " +  (i*table);
            tables.add(t);
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,tables);

        listView.setAdapter(arrayAdapter);
    }
}
