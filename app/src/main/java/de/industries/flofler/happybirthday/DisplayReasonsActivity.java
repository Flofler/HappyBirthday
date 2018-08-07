package de.industries.flofler.happybirthday;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisplayReasonsActivity extends AppCompatActivity {

    private static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nameTxt;

        MyViewHolder(View itemView) {
            super(itemView);
            nameTxt = itemView.findViewById(R.id.nameTxt);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_reasons);

        final Context mContext = getApplicationContext();

        RecyclerView reasonsList = findViewById(R.id.reasonsList);
        final String[] reasons = {
                "Deine Augen",
                "Deine Treue",
                "Deine Fürsorglichkeit",
                "Deine Fähigkeit, es mit mir auszuhalten"


        };
        final List<String> reasonsAsList = new ArrayList<>(Arrays.asList(reasons));

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(mContext,1);
        reasonsList.setLayoutManager(mLayoutManager);
        reasonsList.setAdapter(new RecyclerView.Adapter<MyViewHolder>() {



            @Override
            public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(mContext).inflate(R.layout.model, parent, false);
                return new MyViewHolder(v);
            }

            @Override
            public void onBindViewHolder(MyViewHolder holder, int position) {
                holder.nameTxt.setText(reasonsAsList.get(position));
            }

            @Override
            public int getItemCount() {
                return reasonsAsList.size();
            }
        });

    }
}
