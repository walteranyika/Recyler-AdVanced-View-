package io.mkulima.recyclerexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by walter on 9/25/18.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
//https://guides.codepath.com/android/Using-the-RecyclerView
    Context context;
    ArrayList<User> arrayList;

    public CustomAdapter(Context context, ArrayList<User> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        User u=arrayList.get(position);
        holder.cbComplete.setChecked(u.isComplete());
        holder.txtCourse.setText(u.getCourse());
        holder.txtCampus.setText(u.getCampus());
        holder.txtNames.setText(u.getName());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txtNames;
        TextView txtCourse;
        TextView txtCampus;
        CheckBox cbComplete;
        public MyViewHolder(View itemView) {
            super(itemView);
            this.txtNames=itemView.findViewById(R.id.txtNames);
            this.txtCampus=itemView.findViewById(R.id.txtCampus);
            this.txtCourse=itemView.findViewById(R.id.txtCourse);
            this.cbComplete=itemView.findViewById(R.id.cbComplete);
        }
    }
}
