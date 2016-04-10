package com.zyt.chat;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

class JerseyUtils$1
  implements HostnameVerifier
{
  public boolean verify(String hostname, SSLSession session)
  {
    return true;
  }
}
