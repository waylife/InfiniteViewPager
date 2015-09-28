package com.zanlabs.infiniteviewpager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zanlabs.infiniteviewpager.R;
import com.zanlabs.widget.infiniteviewpager.InfinitePagerAdapter;

import java.util.List;

/**
 * Created by RxRead on 2015/9/24.
 */
public class MockPagerAdapter extends InfinitePagerAdapter{

    private final LayoutInflater mInflater;
    private final Context mContext;

    private List<PagerItem> mList;


    public void setDataList(List<PagerItem> list) {
        if (list == null || list.size() == 0)
            throw new IllegalArgumentException("list can not be null or has an empty size");
        this.mList = list;
        this.notifyDataSetChanged();
    }


    public MockPagerAdapter(Context context) {
        mContext=context;
        mInflater = LayoutInflater.from(mContext);
    }


    @Override
    public View getView(int position, View view, ViewGroup container) {
        ViewHolder holder;
        if (view != null) {
            holder = (ViewHolder) view.getTag();
        } else {
            view = mInflater.inflate(R.layout.item_infinite_viewpager, container, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }
        PagerItem item = mList.get(position);
        holder.position = position;
        holder.name.setText(item.getName());
        holder.description.setText(item.getDesc()+"position:"+position);
        Picasso.with(mContext).load(item.getImageUrl()).placeholder(R.mipmap.bg_loding_horizontal).into(holder.image);
        return view;
    }


    @Override
    public int getItemCount() {
        return mList==null?0:mList.size();
    }


    private static class ViewHolder {
        public int position;
        TextView name;
        TextView description;
        ImageView image;
        Button downloadButton;

        public ViewHolder(View view) {
            name = (TextView) view.findViewById(R.id.item_name);
            description = (TextView) view.findViewById(R.id.item_desc);
            image = (ImageView) view.findViewById(R.id.item_image);
            downloadButton = (Button) view.findViewById(R.id.item_button);
        }
    }

}
