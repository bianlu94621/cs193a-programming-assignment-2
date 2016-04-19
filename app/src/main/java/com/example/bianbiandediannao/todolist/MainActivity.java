package com.example.bianbiandediannao.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> itemList;
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        itemList = new ArrayList<String>();

    }

    public void addItem(View view) {
        EditText item = (EditText) findViewById(R.id.new_item);
        String new_item = item.getText().toString();
        itemList.add(new_item);
        item.setText("");

        ListView listView = (ListView) findViewById(R.id.item_list);

        if(adapter == null) {
            adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1,
                    itemList);
            listView.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }

        // listen to clicks on the ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemClicked = itemList.get(position);
                for (int i = 0; i < itemList.size(); i++) {
                    if (itemClicked.equals(itemList.get(i))) {
                        itemList.remove(i);
                    }
                }
                adapter.notifyDataSetChanged();
            }
        });
    }
}
