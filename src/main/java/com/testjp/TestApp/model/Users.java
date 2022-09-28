package com.testjp.TestApp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
// import javax.persistence.GeneratedValue;

@Entity
public class Users {
    @Id
    private int id;
    private String name;
    private String champion;
    private int hp;
    

    public Users(){
        this("Default Name");
    }
    
    public Users(String name){
        this(5, name, "Wawa", 10);
    }

    public Users(int id, String name, String champion, int hp){
        this.id = id;
        this.name = name;
        this.champion = champion;
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
  
    public String getchampion()
    {
      return champion;
    }
    public void setchampion(String champion)
    {
      this.champion = champion;
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
          "et est un.e "+ champion;
    }
}
