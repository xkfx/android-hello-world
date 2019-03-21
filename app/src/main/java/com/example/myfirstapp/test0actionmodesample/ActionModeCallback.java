package com.example.myfirstapp.test0actionmodesample;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.view.ActionMode;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.myfirstapp.R;
import com.example.myfirstapp.test0actionmodesample.model.ItemModel;
import com.example.myfirstapp.test0actionmodesample.adapter.ListViewAdapter;
import com.example.myfirstapp.test0actionmodesample.fragment.ListViewFragment;
import com.example.myfirstapp.test0actionmodesample.adapter.RecyclerViewAdapter;
import com.example.myfirstapp.test0actionmodesample.fragment.RecyclerViewFragment;

import java.util.ArrayList;

/**
 * ActionMode的关键在于
 * startActionMode的时机
 * 以及传递进去的回调ActionMode.Callback
 */
public class ActionModeCallback implements ActionMode.Callback {

    private Context fragmentActivity;
    private RecyclerViewAdapter recyclerViewAdapter; // 便于操控recyclerViewAdapter中的数据
    private ListViewAdapter listViewAdapter; // 便于操控listView中的数据
    private ArrayList<ItemModel> itemModels;
    private boolean isListViewFragment;

    public ActionModeCallback(FragmentActivity fragmentActivity, RecyclerViewAdapter recyclerViewAdapter, ListViewAdapter listViewAdapter, ArrayList<ItemModel> itemModels, boolean isListViewFragment) {
        this.fragmentActivity = fragmentActivity;
        this.recyclerViewAdapter = recyclerViewAdapter;
        this.listViewAdapter = listViewAdapter;
        this.itemModels = itemModels;
        this.isListViewFragment = isListViewFragment;
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        // ex3_4_action_mode_menu是ActionMode的布局文件
        mode.getMenuInflater().inflate(R.menu.ex3_4_action_mode_menu, menu);// Inflate the menu over action mode
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        // Sometimes the meu will not be visible so for that we need to set their visibility manually in this method
        menu.findItem(R.id.action_delete).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        menu.findItem(R.id.action_copy).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        menu.findItem(R.id.action_forward).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return true;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_delete:
                // 因为两个Fragment共用同一个ActionMode.Callback对象
                // Check if current action mode is from ListView Fragment or RecyclerView Fragment
                if (isListViewFragment) {
                    Fragment listFragment = new ActionModeSampleMain().getFragment(0);//Get list view Fragment
                    if (listFragment != null) {
                        ((ListViewFragment) listFragment).deleteRows();//delete selected rows
                    }
                } else {
                    //If current fragment is recycler view fragment
                    Fragment recyclerFragment = new ActionModeSampleMain().getFragment(1);//Get recycler view fragment
                    if (recyclerFragment != null) {
                        ((RecyclerViewFragment) recyclerFragment).deleteRows();//delete selected rows
                    }
                }
                break;
            case R.id.action_copy:
                //Get selected ids on basis of current fragment action mode
                SparseBooleanArray selected;
                if (isListViewFragment) {
                    selected = listViewAdapter
                            .getSelectedIds();
                } else {
                    selected = recyclerViewAdapter
                            .getSelectedIds();
                }
                int selectedMessageSize = selected.size();
                //Loop to all selected items
                for (int i = (selectedMessageSize - 1); i >= 0; i--) {
                    if (selected.valueAt(i)) {
                        //get selected data in Model
                        ItemModel model = itemModels.get(selected.keyAt(i));
                        String title = model.getTitle();
                        String subTitle = model.getSubTitle();
                        //Print the data to show if its working properly or not
                        Log.e("Selected Items", "Title - " + title + "n" + "Sub Title - " + subTitle);
                    }
                }
                Toast.makeText(fragmentActivity, "You selected Copy menu.", Toast.LENGTH_SHORT).show();//Show toast
                mode.finish();//Finish action mode
                break;
            case R.id.action_forward:
                Toast.makeText(fragmentActivity, "You selected Forward menu.", Toast.LENGTH_SHORT).show();//Show toast
                mode.finish();//Finish action mode
                break;
        }
        return false;
    }


    @Override
    public void onDestroyActionMode(ActionMode mode) {
        // When action mode destroyed remove selected selections and set action mode to null
        // First check current fragment action mode
        if (isListViewFragment) {
            listViewAdapter.removeSelection();  // remove selection
            Fragment listFragment = new ActionModeSampleMain().getFragment(0);// Get list fragment
            if (listFragment != null) {
                ((ListViewFragment) listFragment).setNullToActionMode();// Set action mode null
            }
        } else {
            recyclerViewAdapter.removeSelection();  // remove selection
            Fragment recyclerFragment = new ActionModeSampleMain().getFragment(1);//Get recycler fragment
            if (recyclerFragment != null) {
                ((RecyclerViewFragment) recyclerFragment).setNullToActionMode();//Set action mode null
            }
        }
    }
}