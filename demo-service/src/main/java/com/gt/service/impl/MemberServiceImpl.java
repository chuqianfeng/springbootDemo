package com.gt.service.impl;

import com.gt.dao.mapper.MemberDAO;
import com.gt.entity.Member;
import com.gt.service.IMemberService;
import com.gt.utils.CommonUtil;
import com.gt.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cqf
 * @since 2018-09-11
 */
@Service
public class MemberServiceImpl  implements IMemberService {
    
    @Autowired
    private MemberDAO memberDao;


    @Override
    public ServerResponse insertMemberInfor(Member member) throws Exception{
        Member oldMember = memberDao.selectByOpenId(member.getOpenid());
        if(CommonUtil.isNotEmpty(oldMember)){
            oldMember.setGender(member.getGender());
            oldMember.setAvatarUrl(member.getAvatarUrl());
            oldMember.setNickName(member.getNickName());
            oldMember.setNickName(member.getNickName());
            oldMember.setProvince(member.getProvince());
            memberDao.updateById(oldMember);
        }else {
             memberDao.insert(member);
        }
        return ServerResponse.createBySuccss();
    }

    @Override
    public Member queryByOpenid(String openid) throws Exception{
        Member member = memberDao.selectByOpenId(openid);
        if(CommonUtil.isEmpty(member)){
            member = new Member();
        }
        return member;
    }
}
