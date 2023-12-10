package com.spring.maxgames.EventModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "events")
public class Events {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String eventtitle;
	private String eventcontent;
	private int eventauthorid;
	private String eventsource;
	private String eventimgurl;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEventtitle() {
		return eventtitle;
	}
	public void setEventtitle(String eventtitle) {
		this.eventtitle = eventtitle;
	}
	public String getEventcontent() {
		return eventcontent;
	}
	public void setEventcontent(String eventcontent) {
		this.eventcontent = eventcontent;
	}
	public int getEventauthorid() {
		return eventauthorid;
	}
	public void setEventauthorid(int eventauthorid) {
		this.eventauthorid = eventauthorid;
	}
	public String getEventsource() {
		return eventsource;
	}
	public void setEventsource(String eventsource) {
		this.eventsource = eventsource;
	}
	public String getEventimgurl() {
		return eventimgurl;
	}
	public void setEventimgurl(String eventimgurl) {
		this.eventimgurl = eventimgurl;
	}

	


}
