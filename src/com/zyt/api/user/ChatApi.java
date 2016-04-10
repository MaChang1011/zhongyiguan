package com.zyt.api.user;

import java.util.List;
import java.util.Map;
import com.zyt.api.BaseApi;
import com.zyt.base.ApiResult;
import com.zyt.base.PageQuery;
import com.zyt.entity.doctor.AnswerEntity;
import com.zyt.service.chat.IChatManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/api/chat"})
public class ChatApi
  extends BaseApi
{
  @Autowired
  private IChatManager chatManager;
  
  @ResponseBody
  @RequestMapping(value={"/delete"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public ApiResult delete(@RequestParam String userid)
  {
    return this.chatManager.delete("u" + userid);
  }
  
  @ResponseBody
  @RequestMapping(value={"/list/{diagnoseId}/{start}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public List<AnswerEntity> getMsg(@PathVariable String diagnoseId, @PathVariable int start)
  {
    PageQuery<AnswerEntity> page = getPageQuery(start);
    page.getCondition().put("diagnoseId", diagnoseId);
    PageQuery<AnswerEntity> result = this.chatManager.findMsgPage(page);
    return result.getList();
  }
  
  @ResponseBody
  @RequestMapping(value={"/login"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public ApiResult login(@RequestParam String userid, @RequestParam String mobile)
  {
    return this.chatManager.login(userid, mobile);
  }
  
  @ResponseBody
  @RequestMapping(value={"/modify"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public ApiResult modify(@RequestParam String userid, @RequestParam String mobile)
  {
    return this.chatManager.modifyPassword(userid, mobile);
  }
  
  @ResponseBody
  @RequestMapping(value={"/register"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public ApiResult register(@RequestParam String userid, @RequestParam String mobile, @RequestParam String nickname)
  {
    return this.chatManager.register(userid, mobile, nickname);
  }
  
  @ResponseBody
  @RequestMapping(value={"/post"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public ApiResult sendMsg(@RequestParam String msg, @RequestParam String from, @RequestParam String target)
  {
    return this.chatManager.sendMsg(msg, from, target);
  }
}
