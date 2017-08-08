package com.example.user.demoorder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by User on 008 08.08.17.
 */

public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.TitleModelHolder>{
    private ArrayList<TitleModel> dataset;
    private static MyClickListener myClickListener;

    public static class TitleModelHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        TextView description;

        public TitleModelHolder(View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getAdapterPosition(), v);
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public MyRecycleViewAdapter(ArrayList<TitleModel> myDataset){
        dataset = myDataset;
    }

    @Override
    public TitleModelHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_card, parent, false);
        TitleModelHolder titleModel = new TitleModelHolder(view);
        return titleModel;
    }

    @Override
    public void onBindViewHolder(TitleModelHolder holder, int position) {
        holder.title.setText(dataset.get(position).getTitle());
        holder.description.setText(dataset.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }


    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }
}
