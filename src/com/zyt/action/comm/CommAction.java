package com.zyt.action.comm;

import com.zyt.base.BaseAction;
import com.zyt.entity.system.UserEntity;
import com.zyt.kits.UploadKit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping({"/comm"})
public class CommAction
  extends BaseAction
{
  @ResponseBody
  @RequestMapping({"/upload"})
  public String uploadImg(@RequestParam MultipartFile file)
  {
    return UploadKit.upload(this.request, String.valueOf(getUser().getId()), 
      file);
  }
}
