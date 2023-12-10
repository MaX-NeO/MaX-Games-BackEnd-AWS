package com.spring.maxgames.DataModel;

import com.spring.maxgames.AuthModel.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Data {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String gamename;
	private int releaseyear;
	private String gamedeveloper;
	private String gametype;
	private float gameratings;
	private float gameprice;
	private String gamecover;
	private String gamedesc;
	private String coverurl1;
	private String coverurl2;
	private String coverurl3;
	private boolean gameisenabled;
	private boolean gameispinned;
    @ManyToOne
    @JoinColumn(name = "auth_id")
    private User auth;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getGamename() {
		return gamename;
	}
	public void setGamename(String gamename) {
		this.gamename = gamename;
	}
	public int getReleaseyear() {
		return releaseyear;
	}
	public void setReleaseyear(int releaseyear) {
		this.releaseyear = releaseyear;
	}
	public String getGamedeveloper() {
		return gamedeveloper;
	}
	public void setGamedeveloper(String gamedeveloper) {
		this.gamedeveloper = gamedeveloper;
	}
	public String getGametype() {
		return gametype;
	}
	public void setGametype(String gametype) {
		this.gametype = gametype;
	}
	public float getGameratings() {
		return gameratings;
	}
	public void setGameratings(float gameratings) {
		this.gameratings = gameratings;
	}
	public float getGameprice() {
		return gameprice;
	}
	public void setGameprice(float gameprice) {
		this.gameprice = gameprice;
	}
	public String getGamecover() {
		return gamecover;
	}
	public void setGamecover(String gamecover) {
		this.gamecover = gamecover;
	}
	public String getGamedesc() {
		return gamedesc;
	}
	public void setGamedesc(String gamedesc) {
		this.gamedesc = gamedesc;
	}
	public String getCoverurl1() {
		return coverurl1;
	}
	public void setCoverurl1(String coverurl1) {
		this.coverurl1 = coverurl1;
	}
	public String getCoverurl2() {
		return coverurl2;
	}
	public void setCoverurl2(String coverurl2) {
		this.coverurl2 = coverurl2;
	}
	public String getCoverurl3() {
		return coverurl3;
	}
	public void setCoverurl3(String coverurl3) {
		this.coverurl3 = coverurl3;
	}
	public User getAuth() {
		return auth;
	}
	public void setAuth(User auth) {
		this.auth = auth;
	}
	public boolean isGameisenabled() {
		return gameisenabled;
	}
	public void setGameisenabled(boolean gameisenabled) {
		this.gameisenabled = gameisenabled;
	}
	public boolean isGameispinned() {
		return gameispinned;
	}
	public void setGameispinned(boolean gameispinned) {
		this.gameispinned = gameispinned;
	}



}
