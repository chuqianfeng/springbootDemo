package com.gt.dao.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.gt.entity.Member;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author cqf
 * @since 2018-09-11
 */
@Component
public interface MemberDAO extends BaseMapper<Member> {

    Member selectByOpenId(@Param("openId") String openId) throws Exception;


}