package com.example.lesson6task3java.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lesson6task3java.Model.Member;
import com.example.lesson6task3java.R;

import java.util.ArrayList;

public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.MemberViewHolder> {
    Context context;
    ArrayList<Member> members;

    public MemberAdapter(Context context, ArrayList<Member> members) {
        this.context = context;
        this.members = members;
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    @NonNull
    @Override
    public MemberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MemberViewHolder(LayoutInflater.from(context).inflate(R.layout.item_member_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MemberViewHolder holder, int position) {
        Member member = members.get(position);

        if (holder instanceof MemberViewHolder) {
            TextView tv_lastname = ((MemberViewHolder) holder).tv_lastname;

            tv_lastname.setText(member.getLastname());
        }
    }

    static public class MemberViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView tv_lastname;

        public MemberViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;

            tv_lastname = view.findViewById(R.id.tv_lastName);
        }
    }
}
