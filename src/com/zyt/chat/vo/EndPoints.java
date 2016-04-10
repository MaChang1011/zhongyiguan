package com.zyt.chat.vo;


import com.zyt.chat.JerseyUtils;
import com.zyt.chat.comm.ChatConstants;
import org.glassfish.jersey.client.JerseyClient;
import org.glassfish.jersey.client.JerseyWebTarget;

public abstract interface EndPoints
{
  public static final JerseyClient CLIENT = JerseyUtils.getJerseyClient(true);
  public static final JerseyWebTarget ROOT_TARGET = CLIENT.target("https://" + 
    ChatConstants.API_SERVER_HOST + "/");
  public static final JerseyWebTarget APPLICATION_TEMPLATE = ROOT_TARGET.path("{org_name}").path(
    "{app_name}");
  public static final JerseyWebTarget TOKEN_APP_TARGET = APPLICATION_TEMPLATE.path("token");
  public static final JerseyWebTarget USERS_TARGET = APPLICATION_TEMPLATE.path("users");
  public static final JerseyWebTarget USERS_ADDFRIENDS_TARGET = APPLICATION_TEMPLATE
    .path("users").path("{ownerUserName}").path("contacts")
    .path("users").path("{friendUserName}");
  public static final JerseyWebTarget MESSAGES_TARGET = APPLICATION_TEMPLATE.path("messages");
  public static final JerseyWebTarget CHATMESSAGES_TARGET = APPLICATION_TEMPLATE
    .path("chatmessages");
  public static final JerseyWebTarget CHATGROUPS_TARGET = APPLICATION_TEMPLATE.path("chatgroups");
  public static final JerseyWebTarget CHATFILES_TARGET = APPLICATION_TEMPLATE.path("chatfiles");
}

