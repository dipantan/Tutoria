package net.totalh.tutoria.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.totalh.tutoria.CustomClickListener;
import net.totalh.tutoria.R;

import java.util.ArrayList;

/**
 * Created by Apollo on 6/3/2020.
 */

public class JavaListAdapter extends RecyclerView.Adapter<JavaListAdapter.JavaViewHolder> {
    private Context mContext;
    private ArrayList<String> javaList;
    private CustomClickListener clickListener;

    public JavaListAdapter(Context mContext, ArrayList<String> javaList, CustomClickListener clickListener) {
        this.mContext = mContext;
        this.javaList = javaList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public JavaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        final View view = inflater.inflate(R.layout.list_java, viewGroup, false);
        final JavaViewHolder javaViewHolder = new JavaViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(view, javaViewHolder.getAdapterPosition());
            }
        });
        return javaViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull JavaViewHolder javaViewHolder, int i) {
        javaViewHolder.textView.setText(javaList.get(i).replace("_"," "));
    }

    @Override
    public int getItemCount() {
        return javaList.size();
    }

    class JavaViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        JavaViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textViewJava);
        }
    }
}
