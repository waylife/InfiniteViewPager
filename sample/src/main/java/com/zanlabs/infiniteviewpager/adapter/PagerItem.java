package com.zanlabs.infiniteviewpager.adapter;


import java.io.Serializable;

/**
 * Created by RxRead on 2015/9/24.
 */
public class PagerItem implements Serializable {
	private int position;
	private String name;
	private String imageUrl;
	private String desc;

	public void setPosition(int position) {
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
