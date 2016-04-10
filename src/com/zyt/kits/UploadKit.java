package com.zyt.kits;


import java.io.File;
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.web.multipart.MultipartFile;

import com.zyt.api.BaseApi;

public class UploadKit
{
	//�ļ��ϴ�
  private static String fileUpload(HttpServletRequest request, String userid, MultipartFile multipartFile)
  {
    String rtnPath = "";
    String path = request.getSession().getServletContext()
      .getRealPath("/" + BaseApi.UPLOAD_PATH);
    String userDir = path + "/" + BaseApi.USER_UPLOAD_PATH_PREFIX + userid;
    
    File userDirFile = new File(userDir);
    if (!userDirFile.exists()) {
      userDirFile.mkdir();
    }
    String newName = multipartFile.getOriginalFilename();
    
    File file = new File(userDir, newName);
    try
    {
      multipartFile.transferTo(file);
      rtnPath = BaseApi.UPLOAD_PATH + "/" + 
        BaseApi.USER_UPLOAD_PATH_PREFIX + userid + "/" + newName;
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return rtnPath;
  }
  
  //���ļ��ϴ�
  private static String MultipartFileUpload(HttpServletRequest request, String userid, MultipartFile[] multipartFiles)
  {
    String rtnPath = "";
    String path = request.getSession().getServletContext()
      .getRealPath("/" + BaseApi.UPLOAD_PATH);
    String userDir = path + "/" + BaseApi.USER_UPLOAD_PATH_PREFIX + userid;
    StringBuilder sb = new StringBuilder();
    
    for(int i = 0;i<multipartFiles.length;i++)
    {
    	File userDirFile = new File(userDir);
        if (!userDirFile.exists()) {
          userDirFile.mkdir();
        }
        int pre = (int) System.nanoTime();
        String newName = pre+".jpg";
        File file = new File(userDir, newName);
        try
        {
          multipartFiles[i].transferTo(file);
          rtnPath = BaseApi.UPLOAD_PATH + "/" + 
            BaseApi.USER_UPLOAD_PATH_PREFIX + userid + "/" + newName;
          if(i==multipartFiles.length-1)
		  {
        	sb.append(rtnPath);
        	}
          else
          sb.append(rtnPath).append(",");
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
    }
    return sb.toString();
  }
  
  //ͷ���ϴ�
  private static String fileUpload(HttpServletRequest request, String userid, MultipartFile multipartFile, boolean isHead)
  {
    String rtnPath = "";
    String path = request.getSession().getServletContext()
      .getRealPath("/" + BaseApi.UPLOAD_PATH);
    String userDir = path + "/" + BaseApi.USER_UPLOAD_PATH_PREFIX + userid;
    
    File userDirFile = new File(userDir);
    if (!userDirFile.exists()) {
      userDirFile.mkdir();
    }
    String newName = getName(multipartFile.getOriginalFilename(), isHead);
    
    File file = new File(userDir, newName);
    try
    {
      multipartFile.transferTo(file);
      rtnPath = BaseApi.UPLOAD_PATH + "/" + 
        BaseApi.USER_UPLOAD_PATH_PREFIX + userid + "/" + newName;
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return rtnPath;
  }
  
  private static String getName(String originalFilename, boolean isHead)
  {
    String[] names = originalFilename.split("\\.");
    return (isHead ? "head" : Long.valueOf(System.currentTimeMillis())) + "." + 
    names[(names.length - 1)];
  }
  
  public static String upload(HttpServletRequest request, String userid, MultipartFile multipartFile)
  {
    return fileUpload(request, userid, multipartFile);
  }

  
  public static String filesUpload(HttpServletRequest request, String userid, MultipartFile[] multipartFiles)
  {
    return MultipartFileUpload(request, userid, multipartFiles);
  }
  
  public static String uploadHead(HttpServletRequest request, String userid, MultipartFile multipartFile)
  {
    return fileUpload(request, userid, multipartFile, true);
  }
}
