package com.lesehome.sample.model.entity;


/**
 * 蛇
 */
public class Snake extends Animal {

  private String race;//种族

  public Snake(String name, String race) {
    super(name);
    this.race = race;
  }

  public String getRace() {
    return race;
  }

  public void setRace(String race) {
    this.race = race;
  }
}
