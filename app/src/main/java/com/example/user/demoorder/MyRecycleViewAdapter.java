package com.example.user.demoorder;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by User on 008 08.08.17.
 */

public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.TitleModelHolder>{
    private ArrayList<TitleModel> dataset;
    private Context context;
    private static MyClickListener myClickListener;

    public static class TitleModelHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        TextView description;
        ImageView favorite;

        public TitleModelHolder(View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);
            favorite = (ImageView) itemView.findViewById(R.id.favorite);

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

    public MyRecycleViewAdapter(ArrayList<TitleModel> myDataset, Context context){
        dataset = myDataset;
        this.context = context;
    }

    @Override
    public TitleModelHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_card, parent, false);
        TitleModelHolder titleModel = new TitleModelHolder(view);
        return titleModel;
    }

    @Override
    public void onBindViewHolder(final TitleModelHolder holder, int position) {
        holder.title.setText(dataset.get(position).getTitle());
        holder.description.setText(dataset.get(position).getDescription());
        holder.favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //showPopupMenu(holder.favorite);
                //Toast.makeText(context, "added to fav!", Toast.LENGTH_SHORT).show();
                holder.favorite.setImageResource(R.drawable.ic_favorite_black_24dp);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }


    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    class MyMenuClickListener implements PopupMenu.OnMenuItemClickListener{
        public MyMenuClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            if (item.getItemId() == R.id.action_add_to_favorite){
                Toast.makeText(context, "add to favorite", Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        }
    }

    private void showPopupMenu(View view){
        PopupMenu popupMenu = new PopupMenu(context, view);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.menu_item, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new MyMenuClickListener());
        popupMenu.show();
    }


}
