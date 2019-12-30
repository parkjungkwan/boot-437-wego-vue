package com.wego.web.article;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import lombok.Data;
@Data
@Entity
@Component
@Table(name="ARTICLE")
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")@NotNull 
	private Long id;
	@Column(name="USERID") @NotNull
	private String userid;
	@Column(name="COMMENTS") 
	private String comments;
	@Column(name="TITLE") @NotNull
	private String title;
	@Column(name="CONTENTS") @NotNull
	private String content;
	@Column(name="IMG") 
	private String img;
	@Column(name="BOARDTYPE") @NotNull
	private String boardtype;
	@Column(name="RATING") 
	private String rating;
	@Temporal(TemporalType.DATE)
	@Column(name="REGDATE") @NotNull
	private Date regdate;
}
