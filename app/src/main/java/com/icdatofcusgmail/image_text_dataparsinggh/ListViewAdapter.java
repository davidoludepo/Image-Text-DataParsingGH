package com.icdatofcusgmail.image_text_dataparsinggh;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by DAVID OGUNDEPO on 05/09/2017.
 *
 */

public class ListViewAdapter extends BaseAdapter implements Filterable{

    private Context context;
  //  LayoutInflater inflater;
    private ArrayList<WorldPopulation> worldPopulationList;
    private SparseBooleanArray mSelectedItemsIds;
    private Map<Integer, Boolean> isCheckMap = new HashMap<>();
    private List<Map<String, String>> data;

    public ListViewAdapter(Context context, ArrayList<WorldPopulation> worldPopulationList) {
        super();

        mSelectedItemsIds = new SparseBooleanArray();
        this.context = context;
        this.worldPopulationList = worldPopulationList;
       // inflater = LayoutInflater.from(context);

        configCheckMap(false);
    }

    public void configCheckMap(boolean bool) {
        for (int i = 0; i < worldPopulationList.size(); i++) {
            isCheckMap.put(i, bool);
        }
    }

    @Override
    public Filter getFilter() {
        return null;
    }

    private class ViewHolder {
        TextView rank;
        TextView country;
        TextView population;
        ImageView flag;
    }

    @Override
    public int getCount() {
        return worldPopulationList == null ? 0 : worldPopulationList.size();
    }

    @Override
    public Object getItem(int position) {
        return worldPopulationList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return worldPopulationList.indexOf(getItem(position));
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final ViewHolder holder;

        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.single_item, parent, false);

            holder.rank = (TextView) view.findViewById(R.id.rank);
            holder.country = (TextView) view.findViewById(R.id.country);
            holder.population = (TextView) view.findViewById(R.id.population);
            holder.flag = (ImageView) view.findViewById(R.id.flag);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.rank.setText(worldPopulationList.get(position).getRank());
        holder.country.setText(worldPopulationList.get(position).getCountry());
        holder.population.setText(worldPopulationList.get(position).getPopulation());

        holder.flag.setImageResource(worldPopulationList.get(position).getFlag());

        return view;
    }

  //  @Override
    public void remove(WorldPopulation object) {
        worldPopulationList.remove(object);
        notifyDataSetChanged();
    }

    public ArrayList<WorldPopulation> getWorldPopulation() {
        return worldPopulationList;
    }

    public void toggleSelection(int position) {
        selectView(position, !mSelectedItemsIds.get(position));
    }

   public void removeSelection() {
        mSelectedItemsIds = new SparseBooleanArray();
        notifyDataSetChanged();
    }

    public void selectView(int position, boolean value) {
        if (value) {
            mSelectedItemsIds.put(position, value);
        } else {
            mSelectedItemsIds.delete(position);
        }
        notifyDataSetChanged();
    }

   public int getSelectedCount() {
        return mSelectedItemsIds.size();
    }

    public SparseBooleanArray getSelectedIds() {
        return mSelectedItemsIds;
    }
}
