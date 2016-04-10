package com.zyt.api.doctor;

import java.util.List;
import java.util.Map;
import com.zyt.api.BaseApi;
import com.zyt.base.ApiResult;
import com.zyt.base.PageQuery;
import com.zyt.bo.doctor.CommentBo;
import com.zyt.entity.doctor.CommentEntity;
import com.zyt.service.doctor.ICommentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/api/comment"})
public class CommentApi
  extends BaseApi
{
  @Autowired
  private ICommentManager commentManager;
  
  @ResponseBody
  @RequestMapping(value={"/list/{userId}/{start}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public List<CommentBo> list(@PathVariable String userId, @PathVariable int start)
  {
    PageQuery<CommentBo> page = getPageQuery(start);
    page.getCondition().put("userId", userId);
    PageQuery<CommentBo> result = this.commentManager.findPage(page);
    return result.getList();
  }
  
  @ResponseBody
  @RequestMapping(value={"/post"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public ApiResult post(@ModelAttribute CommentEntity entity)
  {
    return this.commentManager.save(entity);
  }
}
