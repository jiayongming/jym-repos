package com.model;

import java.io.Serializable;

import lombok.Data;
@Data
public class Person implements Serializable{
	private static final long serialVersionUID = -5683256056792995125L;
	private Integer id ;
	private String name ;
	private Integer age ;
}
