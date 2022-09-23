package com.testjp.TestApp.form;

public class UserForm {

    private int id;
    private String name;
    private String championType;
    private int hp;
  
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
}
