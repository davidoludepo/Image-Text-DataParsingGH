package com.icdatofcusgmail.image_text_dataparsinggh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class SecondActivity extends AppCompatActivity {

    ListView gridview;
    ListViewAdapter listViewAdapter;
    WorldPopulation worldPopulation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle bundle = getIntent().getExtras();
      //  String[] strings = bundle.getStringArray("Key");
        gridview = (ListView) findViewById(R.id.gridview);

       // listViewAdapter = new ListViewAdapter(getApplicationContext(), ArrayList<WorldPopulation> worldPopulation)

     //   Intent intent = getIntent();
     //   Parcelable parcelable = (Parcelable) intent.getParcelableArrayListExtra("Key");
    //    gridview.setAdapter(listViewAdapter);
      //  getIntent().getParcelableExtra("Key");

    }
}
