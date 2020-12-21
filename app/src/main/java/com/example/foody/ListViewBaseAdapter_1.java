package com.example.foody;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public abstract class ListViewBaseAdapter_1 extends BaseAdapter {
    public ArrayList<ListViewBean_1> arrayListListener;
    private List<ListViewBean_1> mListenerList;
    Context mContext;

    public ListViewBaseAdapter_1(List<ListViewBean_1> mListenerList, Context context){
        mContext = context;
        this.mListenerList = mListenerList;
        this.arrayListListener = new ArrayList<ListViewBean_1>();
        this.arrayListListener.addAll(mListenerList);
    }
    public class ViewHolder{
        ImageView mItemPic;
        TextView mLangTitle;
        TextView mcomment;
    }
    @Override
    public int getCount(){
        return mListenerList.size();
    }
    @Override
    public Object getItem(int position){
        return position;
    }
    @Override
    public View getView(final int position, View view, ViewGroup parent){
        final ViewHolder holder;
        if (view==null){
            view = LayoutInflater.from(mContext).inflate(R.layout.list_item_1, null);
            holder = new ViewHolder();
            holder.mItemPic = (ImageView) view.findViewById(R.id.img);
            holder.mLangTitle = (TextView) view.findViewById(R.id.title);
            holder.mcomment = (TextView) view.findViewById(R.id.txt_cmt);

            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }
        try{
            int image = mListenerList.get(position).getImage();
            holder.mItemPic.setImageResource(image);
            holder.mLangTitle.setText(mListenerList.get(position).getLangTitle());
            holder.mcomment.setText(mListenerList.get(position).getComment());
        } catch (Exception ẽx){

        }
        return view;
    }
}
