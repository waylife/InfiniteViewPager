# InfiniteViewpager
https://github.com/waylife/InfiniteViewPager

[中文](https://github.com/waylife/InfiniteViewPager/README_ZH.MD)
[English](https://github.com/waylife/InfiniteViewPager/README.MD)
## Function
   - Automatically scroll to next page
   - Smoothly scrolls from the end page to the first page,so does first to end.
   - View reuse support, no worrying about OOM
   - With indicator support(Modification of [ViewpagerIncicator](https://github.com/JakeWharton/ViewPagerIndicator))
   - Fluid when invoking ViewPager.setCurrentItem(), better than [the common solution](http://stackoverflow.com/a/17424525/1872596)

## Preview

    Demo
    ![Sample demo](https://github.com/waylife/InfiniteViewPager/raw/master/ScreenCapture/preview_s2.gif?raw=true)
    Applied in [Appmall](http://app.sogou.com/detail/311558) (Game Banner)
    ![Sample demo](https://github.com/waylife/InfiniteViewPager/raw/master/ScreenCapture/preview_s1.gif?raw=true)

## Usage
Almost the same as the viewpager. Below are some steps.

### define in xml layout

``` xml
        <RelativeLayout
            android:layout_width="fill_parent"
            android:layout_height="200dp">

            <com.zanlabs.widget.infiniteviewpager.InfiniteViewPager
                android:id="@+id/viewpager"
                android:layout_width="match_parent"
                android:layout_height="fill_parent"
                android:visibility="visible" />

            <com.zanlabs.widget.infiniteviewpager.indicator.LinePageIndicator
                android:id="@+id/indicator"
                android:layout_width="fill_parent"
                android:layout_height="wrap_content"
                android:layout_alignParentBottom="true"
                app:fillColor="#e3ffc7"
                app:pageColor="#5fff65" />
        </RelativeLayout>
```

### implement the InfinitePagerAdapter
Similar as the implement of BaseAdapter.
You need to overide the getView and getItemCount(not getCount) mehtod.

``` java
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

```

### setup in activity or fragment.

``` java
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        //
        MockPagerAdapter pagerAdapter = new MockPagerAdapter(this);
        pagerAdapter.setDataList(MockDataGenerator.getViewPagerData());
        mViewPager.setAdapter(pagerAdapter);
        mViewPager.setAutoScrollTime(5000);
        mViewPager.startAutoScroll();
        mLineIndicator.setViewPager(mViewPager);
        //
      }

    @Override
    public void onStart() {
        super.onStart();
        if (mViewPager != null)
            mViewPager.startAutoScroll();
    }

    @Override
    public void onStop() {
        if (mViewPager != null)
            mViewPager.stopAutoScroll();
        super.onStop();
    }
```

More You can refer to the sample project.

## License
The MIT License.