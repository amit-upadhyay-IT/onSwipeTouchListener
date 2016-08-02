package com.amitupadhyay.advertisingportal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by aupadhyay on 8/3/16.
 */

public class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.ViewHolder> {

    private Context context;
    private ArrayList<CategoriesDetails> categoriList;
    int resource;

    public MyCustomAdapter(Context context, ArrayList<CategoriesDetails> categoriList, int resource) {
        this.context = context;
        this.categoriList = categoriList;
        this.resource = resource;
    }

    @Override
    public MyCustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(resource, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyCustomAdapter.ViewHolder holder, int position) {

        CategoriesDetails obj = categoriList.get(position);

        holder.details.setText(obj.getDetails());
        holder.imageView.setImageResource(obj.getImage());
    }

    @Override
    public int getItemCount() {
        return categoriList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView details;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            details = (TextView) itemView.findViewById(R.id.textRecyclerView1);
            imageView = (ImageView) itemView.findViewById(R.id.imageRecyclerView1);
        }
    }

}
