package com.kgc.wechatorder.wechat.dao;

import com.kgc.wechatorder.wechat.pojo.UserToken;
import org.apache.ibatis.annotations.Mapper;

/**
 * token DAO层
 * Created By Ivan_ldp@163.com on 2019/9/10 16:15
 */
@Mapper
public interface UserTokenMapper {
    /**
     * 按userId查询用户token信息
     * @param userId
     * @return
     */
    UserToken queryByUserId(Integer userId);

    /**
     * 按token查询用户token信息
     * @param token
     * @return
     */
    UserToken queryByToken(String token);

    /**
     * 增加token信息
     * @param userToken
     * @return
     */
    int save(UserToken userToken);

    /**
     * 更新token信息
     * @param userToken
     * @return
     */
    int update(UserToken userToken);


}
