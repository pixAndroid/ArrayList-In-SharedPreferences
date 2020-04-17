package com.androidcitizen.labtest;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

/********************************************
 *     Created by DailyCoding on 3/23/2020.  *
 ********************************************/

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.Holder> {
    private Context context;
    private List<TaskModel> taskModelList;

    public TaskAdapter(Context context, List<TaskModel> taskModelList) {
        this.context = context;
        this.taskModelList = taskModelList;
        Collections.reverse(taskModelList);
    }

    public void setTaskModelList(List<TaskModel> taskModelList) {
        this.taskModelList = taskModelList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(context)
                .inflate(R.layout.layout_task_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Log.d("Daily", "taskModelList: " + taskModelList);
        holder.txtTaskName.setText(taskModelList.get(position).getTaskName());
        holder.txtTaskAddTime.setText(String.valueOf(taskModelList.get(position).getTaskAddedTime()));
    }

    @Override
    public int getItemCount() {
        return taskModelList != null ? taskModelList.size() : 0;
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView txtTaskName, txtTaskAddTime;
        public Holder(@NonNull View itemView) {
            super(itemView);
            txtTaskName = itemView.findViewById(R.id.txt_task_name);
            txtTaskAddTime = itemView.findViewById(R.id.txt_date);
        }
    }

}
