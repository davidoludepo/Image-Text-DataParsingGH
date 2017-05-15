package com.icdatofcusgmail.image_text_dataparsinggh;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    static GridView list;
    ListViewAdapter listViewAdapter;
    String[] country = new String[]{"White Rice", "Jollof Rice", "Fried Rice", "Beef", "Chicken", "Moi Moi", "Beans", "Egg", "Coleslaw", "Plantain"};
    String[] rank =new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    String[] population = new String[]{"10", "20", "30", "40", "50", "60", "70", "80", "90", "100"};
    int[] flag =  {R.drawable.c_whiterice, R.drawable.c_jollof, R.drawable.c_friedrice, R.drawable.c_beef, R.drawable.c_chicken, R.drawable.c_moimoi, R.drawable.c_beans, R.drawable.c_egg, R.drawable.c_coleslaw, R.drawable.c_plantain};
    Toolbar toolbar;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SparseBooleanArray check = list.getCheckedItemPositions();
                ArrayList<Parcelable> seectedItems = new ArrayList<>();
                for (int i = 0; i < check.size(); i++) {
                    int position = check.keyAt(i);
                    if (check.valueAt(i))
                        seectedItems.add((Parcelable) listViewAdapter.getItem(position));
                }

                // String[] outputStrArr = new String[seectedItems.size()];
                Parcelable[] outputStrArr = new Parcelable[seectedItems.size()];

                for (int i = 0; i < seectedItems.size(); i++) {
                    outputStrArr[i] = seectedItems.get(i);
                }

                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);

                //     Bundle bundle = new Bundle();
                //   bundle.putParcelableArray("Key", outputStrArr);
                //    intent.putExtra("Key", getWorldPopulations());
                //   intent.putExtras(bundle);
                startActivity(intent);
            }
        });

      //  toolbar = (Toolbar) findViewById(R.id.ToolbarVendorActivity);
        //setSupportActionBar(toolbar);
        //   list.setOnItemClickListener(this);


      /*  for (int i = 0; i < rank.length; i++) {
            WorldPopulation worldPopulation = new WorldPopulation(rank[i],
            country[i], population[i], flag[i]);
            worldPopulations.add(worldPopulation);
        }   */

        list = (GridView) findViewById(R.id.listview);

        listViewAdapter = new ListViewAdapter(getApplicationContext(), getWorldPopulations());
        list.setAdapter(listViewAdapter);
        //  list.setMultiChoiceModeListener(this);
        list.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);

        list.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                final int checkedCount = list.getCheckedItemCount();
                mode.setTitle(checkedCount + " Selected");
                listViewAdapter.toggleSelection(position);

                Toast.makeText(getApplicationContext(), "This is cool", Toast.LENGTH_SHORT).show();

            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                mode.getMenuInflater().inflate(R.menu.main, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.delete:
                        SparseBooleanArray selected = listViewAdapter.getSelectedIds();

                        for (int i = (selected.size() - 1); i >=0; i--) {
                            if (selected.valueAt(i)) {
                                WorldPopulation selecteditem = (WorldPopulation) listViewAdapter.getItem(selected.keyAt(i));
                                listViewAdapter.remove(selecteditem);
                            }
                        }
                        mode.finish();
                        return true;
                    default:
                        return false;
                }

            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                listViewAdapter.removeSelection();
            }
        });
    }

    private ArrayList<WorldPopulation> getWorldPopulations() {
        ArrayList<WorldPopulation> worldPopulations = new ArrayList<WorldPopulation>();
        worldPopulations.add(new WorldPopulation(rank[0], country[0], population[0], flag[0]));
        worldPopulations.add(new WorldPopulation(rank[1], country[1], population[1], flag[1]));
        worldPopulations.add(new WorldPopulation(rank[2], country[2], population[2], flag[2]));
        worldPopulations.add(new WorldPopulation(rank[3], country[3], population[3], flag[3]));
        worldPopulations.add(new WorldPopulation(rank[4], country[4], population[4], flag[4]));
        worldPopulations.add(new WorldPopulation(rank[5], country[5], population[5], flag[5]));
        worldPopulations.add(new WorldPopulation(rank[6], country[6], population[6], flag[6]));
        worldPopulations.add(new WorldPopulation(rank[7], country[7], population[7], flag[7]));
        worldPopulations.add(new WorldPopulation(rank[8], country[8], population[8], flag[8]));
        worldPopulations.add(new WorldPopulation(rank[9], country[9], population[9], flag[9]));

        return worldPopulations;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(), "This is cooler", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("VendorActivity","onStart invoked");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("VendorActivity","onResume invoked");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("VendorActivity","onPause invoked");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("VendorActivity","onRestart invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("VendorActivity","onDestroy invoked");

    }
}
