package com.zyt.chat.vo;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import org.glassfish.jersey.client.JerseyWebTarget;

public abstract class Credential
{
  protected String grantType;
  protected String tokenKey1;
  protected String tokenKey2;
  protected JsonNodeFactory factory = new JsonNodeFactory(false);
  protected Token token;
  protected abstract JerseyWebTarget getTokenRequestTarget();
  
  protected abstract GrantType getGrantType();
  
  public Credential() {}
  
  public static enum GrantType 
  {
    CLIENT_CREDENTIALS;
  }
  
  public Credential(String tokenKey1, String tokenKey2)
  {
    this.tokenKey1 = tokenKey1;
    this.tokenKey2 = tokenKey2;
  }
  
  public Credential(Token token)
  {
    this.token = token;
  }
  
  public abstract Token getToken();
  
  public String toString()
  {
    return 
      "Credentials [grantType=" + this.grantType + ", tokenKey1=" + this.tokenKey1 + ", tokenKey2=" + this.tokenKey2 + ", token=" + this.token + "]";
  }
  
  public int hashCode()
  {
    int prime = 31;
    int result = 1;
    result = 31 * result + (this.grantType == null ? 0 : this.grantType.hashCode());
    result = 31 * result + (this.token == null ? 0 : this.token.hashCode());
    result = 31 * result + (this.tokenKey1 == null ? 0 : this.tokenKey1.hashCode());
    result = 31 * result + (this.tokenKey2 == null ? 0 : this.tokenKey2.hashCode());
    return result;
  }
  
  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Credential other = (Credential)obj;
    if (this.grantType == null)
    {
      if (other.grantType != null) {
        return false;
      }
    }
    else if (!this.grantType.equals(other.grantType)) {
      return false;
    }
    if (this.token == null)
    {
      if (other.token != null) {
        return false;
      }
    }
    else if (!this.token.equals(other.token)) {
      return false;
    }
    if (this.tokenKey1 == null)
    {
      if (other.tokenKey1 != null) {
        return false;
      }
    }
    else if (!this.tokenKey1.equals(other.tokenKey1)) {
      return false;
    }
    if (this.tokenKey2 == null)
    {
      if (other.tokenKey2 != null) {
        return false;
      }
    }
    else if (!this.tokenKey2.equals(other.tokenKey2)) {
      return false;
    }
    return true;
  }
}
