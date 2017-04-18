package com.mllwf.oval;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ML on 2017/4/18.
 */
public class MyAdapter extends RecyclerView.Adapter {


    private Context mContext;
    private List<String> mList = new ArrayList<>();

    public interface onItemCLikListener {
        void onTvClick(String view);

        void onCheckBoxClick(View view);
    }

    private onItemCLikListener mListener;

    public void setOnClickListener(onItemCLikListener listener) {
        mListener = listener;
    }

    public MyAdapter(List<String> list, Context context) {
        mContext = context;
        mList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHodler(LayoutInflater.from(mContext).inflate(R.layout.list_cell_view, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final MyViewHodler h = (MyViewHodler) holder;
        h.tv.setText(mList.get(position));
        h.cb.setText(position + "");
        //        h.tv.setOnClickListener(new View.OnClickListener() {
        //            @Override
        //            public void onClick(View v) {
        //                if (mListener != null) {
        //                    mListener.onTvClick(v);
        //                }
        //            }
        //        });
        h.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onTvClick(mList.get(position));
                }
            }
        });
        h.cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onCheckBoxClick(v);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    private class MyViewHodler extends RecyclerView.ViewHolder {
        public TextView tv;
        public CheckBox cb;
        public LinearLayout ll;

        public MyViewHodler(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv_message);
            cb = (CheckBox) itemView.findViewById(R.id.cb_select);
            ll = (LinearLayout) itemView.findViewById(R.id.ll_all);
        }
    }
}
