package com.gt.service;


import com.gt.entity.Member;
import com.gt.utils.ServerResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cqf
 * @since 2018-09-11
 */
public interface IMemberService {

    public ServerResponse insertMemberInfor(Member member) throws Exception;

    /**
     * 获取粉丝信息
     * @param openid
     * @return
     */
    public Member queryByOpenid(String openid) throws Exception;

	
}
