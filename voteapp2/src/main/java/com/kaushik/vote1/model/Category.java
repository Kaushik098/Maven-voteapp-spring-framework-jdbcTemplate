package com.kaushik.vote1.model;

public class Category {
	  
	private int id;
    private String name;
	
    public Category(int id, String name) {
		// TODO Auto-generated constructor stub
    	this.id = id;
    	this.name = name;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
	
       
}
