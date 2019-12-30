package com.wego.web.person;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import lombok.Builder;
import lombok.Data;
@Data
@Entity
@Table(name="PERSON",
	   uniqueConstraints={
		@UniqueConstraint(
			columnNames={"USERID"}
		)
	})
@Component
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID") @NotNull
	private Long id;
	@Column(name="USERID") @NotNull
	private String userid;
	@Column(name="PASSWD") @NotNull
	private String passwd;
	@Column(name="NAME") @NotNull
	private String name;
	@Temporal(TemporalType.DATE)
	@Column(name="BIRTHDAY") @NotNull
	private Date birthday;
	@Column(name="MALE") @NotNull
	private boolean male;
	@Column(name="HAK")@NotNull
	private int hak;
	@Column(name="BAN")@NotNull
	private int ban;
	@Column(name="SCORE")@NotNull
	private int score;
	@Column(name="ROLE") @NotNull
	private String role;
	enum Level{HIGH, MID, LOW}
	
	
	@Builder
	public Person( String userid,  String passwd,  String name,  
			Date birthday, boolean male,  int hak,  int ban,  int score) {
		super();
		this.userid = userid;
		this.passwd = passwd;
		this.name = name;
		this.birthday = birthday;
		this.male = male;
		this.hak = hak;
		this.ban = ban;
		this.score = score;
	}
	
	

	
	
	
	
}
