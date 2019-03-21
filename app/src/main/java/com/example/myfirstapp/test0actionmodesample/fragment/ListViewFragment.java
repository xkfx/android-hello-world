package com.example.myfirstapp.test0actionmodesample.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myfirstapp.R;
import com.example.myfirstapp.test0actionmodesample.ActionModeCallback;
import com.example.myfirstapp.test0actionmodesample.model.ItemModel;
import com.example.myfirstapp.test0actionmodesample.adapter.ListViewAdapter;

import java.util.ArrayList;
import java.util.Objects;

public class ListViewFragment extends Fragment {
    private View listViewContainer;
    private ListView listView;
    private ListViewAdapter listViewAdapter;
    // Action Mode for toolbar
    private ActionMode actionMode;
    private ArrayList<ItemModel> itemModels;

    public ListViewFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        listViewContainer = inflater.inflate(R.layout.ex3_4_list_view_fragment, container, false);
        populateListViewWithDummyData();
        implementListViewClickListeners();
        return listViewContainer;
    }

    private void populateListViewWithDummyData() {
        listView = listViewContainer.findViewById(R.id.list_view);
        itemModels = new ArrayList<>();
        for (int i = 1; i <= 40; i++) {
            itemModels.add(new ItemModel("Title " + i, "Sub Title " + i));
        }
        listViewAdapter = new ListViewAdapter(getActivity(), itemModels);
        listView.setAdapter(listViewAdapter);
        listViewAdapter.notifyDataSetChanged();
    }

    // Implement item click and long click over list listViewContainer
    private void implementListViewClickListeners() {
        listView.setOnItemClickListener((parent, view, position, id) -> {
            // If ActionMode not null select item
            if (actionMode != null) {
                onListItemSelect(position);
            }
        });
        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            // Select item on long click
            onListItemSelect(position);
            return true;
        });
    }

    // List item select method
    private void onListItemSelect(int position) {
        listViewAdapter.toggleSelection(position);// Toggle the selection
        boolean hasCheckedItems = listViewAdapter.getSelectedCount() > 0;// Check if any itemModels are already selected or not
        if (hasCheckedItems && actionMode == null)
            // there are some selected itemModels, start the actionMode
            actionMode = ((AppCompatActivity) Objects.requireNonNull(getActivity()))
                    .startSupportActionMode(new ActionModeCallback(getActivity(), null, listViewAdapter, itemModels, true));
        else if (!hasCheckedItems && actionMode != null)
            // there no selected itemModels, finish the actionMode
            actionMode.finish();
        if (actionMode != null) {
            // set action mode title on item selection
            actionMode.setTitle(String.valueOf(listViewAdapter
                    .getSelectedCount()) + " selected");
        }
    }

    //Set action mode null after use
    public void setNullToActionMode() {
        if (actionMode != null)
            actionMode = null;
    }

    //Delete selected rows
    public void deleteRows() {
        SparseBooleanArray selected = listViewAdapter
                .getSelectedIds();//Get selected ids
        //Loop all selected ids
        for (int i = (selected.size() - 1); i >= 0; i--) {
            if (selected.valueAt(i)) {
                //If current id is selected remove the item via key
                itemModels.remove(selected.keyAt(i));
                listViewAdapter.notifyDataSetChanged();//notify listViewAdapter

            }
        }
        Toast.makeText(getActivity(), selected.size() + " item deleted.", Toast.LENGTH_SHORT).show();//Show Toast
        actionMode.finish();//Finish action mode after use
    }
}