package com.lesehome.sample.model.entity;


/**
 *壁虎
 */
public class Gecko extends Animal {

  private String race;//种族

  public Gecko(String name, String race) {
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
