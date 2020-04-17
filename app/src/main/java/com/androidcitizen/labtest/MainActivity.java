package com.androidcitizen.labtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private Button btnAdd;
    private EditText etTaskEntry;
    private RecyclerView recyclerView;
    private TaskAdapter adapter;

    private List<TaskModel> taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btn_add);
        recyclerView = findViewById(R.id.recyclerview);
        etTaskEntry = findViewById(R.id.et_entry);

        taskList = PrefConfig.readListFromPref(this);

        if (taskList == null)
            taskList = new ArrayList<>();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new TaskAdapter(getApplicationContext(), taskList);
        recyclerView.setAdapter(adapter);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TaskModel taskModel = new TaskModel(etTaskEntry.getText().toString(), getDate());
                taskList.add(taskModel);
                PrefConfig.writeListInPref(getApplicationContext(), taskList);
                Collections.reverse(taskList);
                adapter.setTaskModelList(taskList);

                if (!etTaskEntry.getText().equals(""))
                    etTaskEntry.setText("");

            }
        });

    }

    private String getDate() {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return String.valueOf(dateFormat.format(date));
    }
}
