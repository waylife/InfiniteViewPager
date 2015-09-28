# InfiniteViewpager
https://github.com/waylife/InfiniteViewPager

[中文](/README_ZH.MD)
[English](/README.MD)
## 功能
   - 自动滑动到下一页
   - 平滑的滑到首页以及到尾页.
   - View重用，不用担心内存泄露
   - 支持指示器(对[ViewpagerIncicator](https://github.com/JakeWharton/ViewPagerIndicator)做了一定修改)
   - 调用ViewPager.setCurrentItem()不卡顿, 比[常用的解放方案好](http://stackoverflow.com/a/17424525/1872596)

## 演示
    Demo
    ![Sample demo](/ScreenCapture/preview_s2.gif)
    搜狗市场(http://app.sogou.com/detail/311558) (游戏banner)
    ![Appmall game banner](/ScreenCapture/preview_s1.gif)

## 使用
几乎跟viewpager一样. 以下是步骤.

### 在xml布局中定义

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

### 继承InfinitePagerAdapter
跟继承BaseAdapter类似.
需要重写getView以及getItemCount（不是getCount）方法

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

### 设置activity或者fragment.

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

更多可以参考sample项目.

## License
The MIT License.