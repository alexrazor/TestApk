package com.alexrazor.testapk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Owner> list;
    private ArrayAdapter<Owner> adapter;

    EditText ownerName;
    EditText ownerNumber;

    Button addToListButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();

        // for testing only!
        //fillCarOwners(list);

        listView = (ListView) findViewById(R.id.listView);

        adapter = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,list);
        listView.setAdapter(adapter);

        ownerName = (EditText) findViewById(R.id.name);
        ownerNumber = (EditText) findViewById(R.id.number);

        addToListButton = (Button) findViewById(R.id.button);
        addToListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ownerName.getText().toString();
                int number = Integer.parseInt(ownerNumber.getText().toString());
                //list.add(new Owner(name,number));
                adapter.add(new Owner(name,number));
            }
        });
        // Test this method first
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.remove(list.get(position));

            }
        });

        //testPopUp
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"must do something", Toast.LENGTH_SHORT).show();
                return false;

            }
        });
    }

    private void fillCarOwners(List <Owner> list) {
        String name = "Owner";
        int number;

        for (int i =0; i<14; i++){
            name =name+i;
            number=i;
            list.add(new Owner(name,number));
            name = "Owner";

        }
    }
}
