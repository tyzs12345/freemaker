package com.tian.demo.model;

import java.io.Serializable;

public class Parameter
  implements Serializable
{
  private int id;
  private String paramName;
  private String paramValue;
  private String discription;

  public int getId()
  {
    return this.id;
  }
  public String getParamName() {
    return this.paramName;
  }
  public String getParamValue() {
    return this.paramValue;
  }
  public String getDiscription() {
    return this.discription;
  }

  public void setId(int id)
  {
    this.id = id;
  }
  public void setParamName(String paramName) {
    this.paramName = paramName;
  }
  public void setParamValue(String paramValue) {
    this.paramValue = paramValue;
  }
  public void setDiscription(String discription) {
    this.discription = discription;
  }
}