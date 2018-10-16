package com.gt.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.sql.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author cqf
 * @since 2018-09-11
 */
@Data
@Accessors(chain = true)
@TableName("member")
public class Member extends Model<Member> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 昵称
     */
	@TableField("nick_name")
	private String nickName;
    /**
     * 用户头像
     */
	@TableField("avatar_url")
	private String avatarUrl;
    /**
     * 1时是男性，值为2时是女性，值为0时是未知
     */
	private Integer gender;
    /**
     * 用户所在城市
     */
	private String city;
    /**
     * 用户所在省份
     */
	private String province;
    /**
     * 用户唯一标识
     */
	private String openid;
    /**
     * 电话号码
     */
	private String phone;
    /**
     * 1-小程序2-h5
     */
	private Integer source;
    /**
     * 数据是否有效1是0否
     */
	private Integer status;
    /**
     * 会员等级0普通
     */
	private Integer grade;
	/**
	 * 创建时间
	 */
	@TableField("creat_time")
	private Date creatTime;



	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
