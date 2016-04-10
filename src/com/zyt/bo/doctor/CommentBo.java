package com.zyt.bo.doctor;

import com.zyt.base.BaseEntity;

public class CommentBo
  extends BaseEntity
{
  private String comment;
  private int commentLevel;
  private String nickname;
  private String head;
  
  public String getComment()
  {
    return this.comment;
  }
  
  public int getCommentLevel()
  {
    return this.commentLevel;
  }
  
  public String getNickname()
  {
    return this.nickname;
  }
  
  public String getHead()
  {
    return this.head;
  }
  
  public void setComment(String comment)
  {
    this.comment = comment;
  }
  
  public void setCommentLevel(int commentLevel)
  {
    this.commentLevel = commentLevel;
  }
  
  public void setNickname(String nickname)
  {
    this.nickname = nickname;
  }
  
  public void setHead(String head)
  {
    this.head = head;
  }
  
  public String toString()
  {
    return "CommentBo(comment=" + getComment() + ", commentLevel=" + getCommentLevel() + ", nickname=" + getNickname() + ", head=" + getHead() + ")";
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof CommentBo)) {
      return false;
    }
    CommentBo other = (CommentBo)o;
    if (!other.canEqual(this)) {
      return false;
    }
    Object this$comment = getComment();Object other$comment = other.getComment();
    if (this$comment == null ? other$comment != null : !this$comment.equals(other$comment)) {
      return false;
    }
    if (getCommentLevel() != other.getCommentLevel()) {
      return false;
    }
    Object this$nickname = getNickname();Object other$nickname = other.getNickname();
    if (this$nickname == null ? other$nickname != null : !this$nickname.equals(other$nickname)) {
      return false;
    }
    Object this$head = getHead();Object other$head = other.getHead();return this$head == null ? other$head == null : this$head.equals(other$head);
  }
  
  protected boolean canEqual(Object other)
  {
    return other instanceof CommentBo;
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;Object $comment = getComment();result = result * 59 + ($comment == null ? 0 : $comment.hashCode());result = result * 59 + getCommentLevel();Object $nickname = getNickname();result = result * 59 + ($nickname == null ? 0 : $nickname.hashCode());Object $head = getHead();result = result * 59 + ($head == null ? 0 : $head.hashCode());return result;
  }
}
