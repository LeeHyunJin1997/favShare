package com.favshare.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity 
@Table(name = "song") 
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@ToString
public class SongEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	String name;
	
	String content;
}
