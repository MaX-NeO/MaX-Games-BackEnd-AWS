package com.spring.maxgames.PostModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "post")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String posttitle;
	private String postcontent;
	private int postauthorid;
	private String postsource;
	private String postimgurl;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPosttitle() {
		return posttitle;
	}
	public void setPosttitle(String posttitle) {
		this.posttitle = posttitle;
	}
	public String getPostcontent() {
		return postcontent;
	}
	public void setPostcontent(String postcontent) {
		this.postcontent = postcontent;
	}
	public int getPostauthorid() {
		return postauthorid;
	}
	public void setPostauthorid(int postauthorid) {
		this.postauthorid = postauthorid;
	}
	public String getPostsource() {
		return postsource;
	}
	public void setPostsource(String postsource) {
		this.postsource = postsource;
	}
	public String getPostimgurl() {
		return postimgurl;
	}
	public void setPostimgurl(String postimgurl) {
		this.postimgurl = postimgurl;
	}



}
