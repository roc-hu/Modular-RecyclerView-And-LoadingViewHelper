package com.lesehome.sample.model.entity;


import com.lesehome.carrot.recycler.modularadapter.IItemEntity;

import java.io.Serializable;

public class Animal implements IItemEntity,Serializable {

  private String name;

  public Animal(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
