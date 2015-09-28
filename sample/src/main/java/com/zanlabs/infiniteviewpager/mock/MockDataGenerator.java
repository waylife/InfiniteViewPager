package com.zanlabs.infiniteviewpager.mock;

import com.zanlabs.infiniteviewpager.adapter.PagerItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RxRead on 2015/9/24.
 */
public class MockDataGenerator {
    public static List<PagerItem> getViewPagerData(){
        List<PagerItem> list=new ArrayList<>();
        PagerItem item=null;
        for(int i=0;i<8;i++){
            item=new PagerItem();
            item.setDesc("Description:"+i);
            item.setName("Name:"+i);
            item.setPosition(i);
            int index=i%3;
            if(index==1){
                item.setImageUrl("http://p3.123.sogoucdn.com/imgu/2015/09/20150924151622_720.jpg");
            }else if(index==2){
                item.setImageUrl("http://p8.123.sogoucdn.com/imgu/2015/09/20150924151358_518.png");
            }else{
                item.setImageUrl("http://p6.123.sogoucdn.com/imgu/2015/09/20150921184131_208.png");
            }
            list.add(item);
        }
        return list;
    }
}
