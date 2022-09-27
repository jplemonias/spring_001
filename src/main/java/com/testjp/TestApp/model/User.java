package com.testjp.TestApp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private int id;
    private String name;
    private String championType;
    private int hp;
    

    public User(){
        this("Default Name");
    }
    
    public User(String name){
        this(5, name, "Wawa", 10);
    }

    public User(int id, String name, String championType, int hp){
        this.id = id;
        this.name = name;
        this.championType = championType;
        this.hp = hp;
    }
  
    public int getId()
    {
      return id;
    }
    public void setId(int id)
    {
      this.id = id;
    }
  
    public String getName()
    {
      return name;
    }
    public void setName(String name)
    {
      this.name = name;
    }
  
    public String getChampionType()
    {
      return championType;
    }
    public void setChampionType(String championType)
    {
      this.championType = championType;
    }
  
    public int getHp()
    {
      return hp;
    }
    
    public void setHp(int hp)
    {
      this.hp = hp;
    }

    @Override
    public String toString() {
        return "Le/La champion.ne s'appel " + name +
          ", avec " + hp + "points de vie " +
          "et est un.e "+ championType;
    }
}
