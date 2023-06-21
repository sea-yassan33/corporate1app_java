package com.example.corporate1app;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="owner")
public class Owner {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column
  private long id;

  @Column(length = 50, nullable = false)
  private String name;

  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
}
