package com.sunday.imoocpulltorefresh.cate;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sunday.imoocpulltorefresh.R;

import java.util.List;

/**
 * Created by Sunday on 2018/5/11.
 */

public class CateAdapter extends RecyclerView.Adapter<CateAdapter.MyHolder> {

    private LayoutInflater mInflater;
    private List<CateModel> mDataSource;

    public void setDataSource(List<CateModel> mDataSource) {
        this.mDataSource = mDataSource;
        notifyDataSetChanged();
    }


    public CateAdapter(Context context, List<CateModel> dataSource) {
        mDataSource = dataSource;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(mInflater.inflate(R.layout.item_cate, parent, false));
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.tvNickName.setText(mDataSource.get(position).getNickname());
        holder.tvName.setText(mDataSource.get(position).getName());
        holder.ivImage.setImageResource(mDataSource.get(position).getImageId());
        holder.ivAvatar.setImageResource(mDataSource.get(position).getAvatarId());
    }

    @Override
    public int getItemCount() {
        return mDataSource.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvNickName;
        ImageView ivImage, ivAvatar;

        public MyHolder(View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.name);
            tvNickName = itemView.findViewById(R.id.nickname);
            ivImage = itemView.findViewById(R.id.image);
            ivAvatar = itemView.findViewById(R.id.avatar);
        }
    }
}
