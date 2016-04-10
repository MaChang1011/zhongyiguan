package com.zyt.chat.vo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.List;
import com.zyt.chat.JerseyUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.glassfish.jersey.client.JerseyWebTarget;

public class ClientSecretCredential
  extends Credential
{
  private static JerseyWebTarget CLIENT_TOKEN_TARGET = null;
  private static final String GRANT_TYPE = "client_credentials";
  
  public ClientSecretCredential(String clientID, String clientSecret, String role)
  {
    super(clientID, clientSecret);
    if (role.equals("appAdmin")) {
      CLIENT_TOKEN_TARGET = 
      
        EndPoints.TOKEN_APP_TARGET.resolveTemplate("org_name", com.zyt.chat.comm.ChatConstants.APPKEY.split("#")[0]).resolveTemplate("app_name", com.zyt.chat.comm.ChatConstants.APPKEY.split("#")[1]);
    }
  }
  
  protected Credential.GrantType getGrantType()
  {
    return Credential.GrantType.CLIENT_CREDENTIALS;
  }
  
  public Token getToken()
  {
    if ((this.token == null) || (this.token.isExpired())) {
      try
      {
        ObjectNode objectNode = this.factory.objectNode();
        objectNode.put("grant_type", "client_credentials");
        objectNode.put("client_id", this.tokenKey1);
        objectNode.put("client_secret", this.tokenKey2);
        List<NameValuePair> headers = new ArrayList();
        headers.add(new BasicNameValuePair("Content-Type", 
          "application/json"));
        
        ObjectNode tokenRequest = JerseyUtils.sendRequest(
          getTokenRequestTarget(), objectNode, null, 
          "POST", headers);
        if (tokenRequest.get("error") != null) {
          throw new RuntimeException(
            "Some errors occurred while fetching a token by grant_type[client_credentials] client_id[" + 
            
            this.tokenKey1 + "]" + 
            " and client_secret[" + this.tokenKey2 + "] .");
        }
        String accessToken = tokenRequest.get("access_token").asText();
        
        Long expiredAt = Long.valueOf(System.currentTimeMillis() + 
          tokenRequest.get("expires_in").asLong() * 1000L);
        
        this.token = new Token(accessToken, expiredAt);
      }
      catch (Exception e)
      {
        throw new RuntimeException(
          "Some errors occurred while fetching a token by grant_type[client_credentials] client_id[" + 
          
          this.tokenKey1 + "]" + " and client_secret[" + 
          this.tokenKey2 + "] .");
      }
    }
    return this.token;
  }
  
  protected JerseyWebTarget getTokenRequestTarget()
  {
    return CLIENT_TOKEN_TARGET;
  }
}
