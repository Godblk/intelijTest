package com.example.recycleDemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by lt on 2015/3/19.
 */
public class ListAdapterHolder extends RecyclerView.Adapter<ListAdapterHolder.ViewHolder> {
    private OnItemClickListener mItemClickListener;
private List<UserDetails> mUserDetail = new ArrayList<UserDetails>();
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater =LayoutInflater.from( viewGroup.getContext());
        View view = inflater.inflate(R.layout.single_list_item,null);
        inttDetail();
        return new ViewHolder(view);
    }

    private void inttDetail() {
        for (int i = 0; i < 100; i++) {
            final UserDetails mDetails = new UserDetails();
            mDetails.setId(i);
            mDetails.setName("Name " + i);
            mDetails.setSex((i % 2) == 0 ? "M" : "F");
            mDetails.setAge(randInt(14, 50));
            mUserDetail.add(mDetails);
        }
    }

    private int randInt(int i, int i1) {
        final Random rand = new Random();
        return rand.nextInt((i - i1) + 1) + i1;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
    viewHolder.vAge.setText(mUserDetail.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void setmItemClickListener(OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView vName, vSex, vId, vAge;
        public ViewHolder(View itemView) {
            super(itemView);
            vId = (TextView) itemView.findViewById(R.id.list_id);
            vName = (TextView) itemView.findViewById(R.id.list_name);
            vSex = (TextView) itemView.findViewById(R.id.list_sex);
            vAge = (TextView) itemView.findViewById(R.id.list_age);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
    if (mItemClickListener != null)
    mItemClickListener.onItemClick(v,getPosition());
        }
    }

    public interface OnItemClickListener {
        public void onItemClick(View view , int position);
    }
}
