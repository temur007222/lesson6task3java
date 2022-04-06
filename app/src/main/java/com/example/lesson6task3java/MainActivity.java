package com.example.lesson6task3java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.lesson6task3java.Adapter.MemberAdapter;
import com.example.lesson6task3java.Model.Member;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Context context;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        List<Member> members = prepareMemberList();
        refreshAdapter((ArrayList<Member>) members);
    }

    private void initView() {
        context = this;
        recyclerView =findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
    }

    private void refreshAdapter(ArrayList<Member> members) {
        MemberAdapter adapter = new MemberAdapter(context, members);
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);
    }

    private List<Member> prepareMemberList() {
        List<Member> members = new ArrayList<>();

        for (int i = 1; i<15; i++){
            members.add(new Member(1+i, "Temur " + i));
        }
        return members;
    }
}