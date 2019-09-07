package com.kgc.wechatorder.mall.pojo;

import java.util.Date;

/**
 * 评论表
 */
public class Comment {
    private int userId;//关联用户主键
    private String content;//评论内容
    private String uploadPicPath;//上传图片路径
    private Date createTime;//创建时间

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUploadPicPath() {
        return uploadPicPath;
    }

    public void setUploadPicPath(String uploadPicPath) {
        this.uploadPicPath = uploadPicPath;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "userId=" + userId +
                ", content='" + content + '\'' +
                ", uploadPicPath='" + uploadPicPath + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
