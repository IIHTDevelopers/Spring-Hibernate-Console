package com.assessment.hibernate.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="book")
public class Book implements Serializable{
	@Transient
	private static final long serialVersionUID = 3667779253735136971L;
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="BOOKID")
	private long bookId;
	@Column(name="TITLE")
	private String title;
	@Column(name="PRICE")
	private double price;
	@Column(name="VOLUME")
	private Integer volume;
	@Column(name="PUBLISHDATE")
	private String publishDate;
	
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Integer getVolume() {
		return volume;
	}
	public void setVolume(Integer volume) {
		this.volume = volume;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String localDate) {
		this.publishDate = localDate;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", price=" + price + ", volume=" + volume
				+ ", publishDate=" + publishDate + "]";
	}
	
}
