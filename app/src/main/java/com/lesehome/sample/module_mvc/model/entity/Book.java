package com.lesehome.sample.module_mvc.model.entity;

import com.lesehome.carrot.recycler.modularadapter.IItemEntity;

public class Book implements IItemEntity {
	private String name;
	private double price;
	private String author;
	private String description;
	private String content;

	public Book() {
		super();
	}

	public Book(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public Book(String name, double price, String author, String description, String content) {
		super();
		this.name = name;
		this.price = price;
		this.author = author;
		this.content = content;
		this.description= description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
