package com.assessment.hibernate.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="subject")
public class Subject implements Serializable{
	@Transient
	private static final long serialVersionId = 1L;
	@Id
//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SUBJECTID")
	private long subjectId;
	@Column(name="SUBTITLE")
	private String subTitle;
	@Column(name="DURATIONINHOURS")
	private int durationInHours;
	@ElementCollection
	@JoinTable(name="SUBJECT_BOOK", 
	joinColumns=@JoinColumn(name="SUBJECT_ID")
	,inverseJoinColumns=@JoinColumn(name="BOOK_ID"))
	private Set<Book> references=new HashSet<Book>();	
	
	public long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public int getDurationInHours() {
		return durationInHours;
	}
	public void setDurationInHours(int durationInHours) {
		this.durationInHours = durationInHours;
	}
	public Set<Book> getReferences() {
		return references;
	}
	public void setReferences(Set<Book> references) {
		this.references = references;
	}
	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subTitle=" + subTitle + ", durationInHours=" + durationInHours
				+  "]";
	}
	
}


