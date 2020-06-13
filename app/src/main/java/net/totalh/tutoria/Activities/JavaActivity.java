package net.totalh.tutoria.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import net.totalh.tutoria.Adapters.JavaListAdapter;
import net.totalh.tutoria.Constants.JavaConstants;
import net.totalh.tutoria.CustomClickListener;
import net.totalh.tutoria.R;

import java.util.ArrayList;

public class JavaActivity extends AppCompatActivity {
    Context mContext;
    ArrayList<String> titleArrayList;
    RecyclerView recyclerView;
    JavaListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);
        mContext = JavaActivity.this;
        recyclerView = findViewById(R.id.recyclerViewJava);
        titleArrayList = new ArrayList<>();
        titleArrayList.add(JavaConstants.WHAT_IS_JAVA);
        titleArrayList.add(JavaConstants.HISTORY_OF_JAVA);
        titleArrayList.add(JavaConstants.FEATURES_OF_JAVA);
        titleArrayList.add(JavaConstants.FIRST_JAVA_PROGRAM);
        titleArrayList.add(JavaConstants.HOW_TO_SET_PATH_IN_JAVA);
        titleArrayList.add(JavaConstants.DIFFERENCE_BETWEEN_JDK_JRE_JVM);
        titleArrayList.add(JavaConstants.JAVA_VARIABLES);
        titleArrayList.add(JavaConstants.DATA_TYPES_IN_JAVA);
        titleArrayList.add(JavaConstants.OPERATORS_IN_JAVA);
        titleArrayList.add(JavaConstants.JAVA_KEYWORDS);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter = new JavaListAdapter(mContext, titleArrayList, new CustomClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent(mContext,WebViewActivity.class);
                intent.putExtra("titles",titleArrayList.get(position));
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
    }
}
