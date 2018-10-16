package com.gt.controller;

import com.alibaba.fastjson.JSONObject;
import com.gt.entity.Member;
import com.gt.service.IMemberService;
import com.gt.utils.CommonUtil;
import com.gt.utils.ServerResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created by Administrator on 2018/9/6.
 */


@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {

    private Logger logger = Logger.getLogger(TestController.class);//记录日志

    @Autowired
    private IMemberService memberService;



    /**
     * 插入粉丝 信息
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/18IS2018/insertMemberInfo")
    public void insertMemberInfo(HttpServletRequest request, HttpServletResponse response,  Member member) throws IOException{
        ServerResponse sp = ServerResponse.createByFail();
        try{
            System.out.println(member);
            logger.error("进入/18IS2018/insertMemberInfo，参数为："+JSONObject.toJSONString(member));
            sp = memberService.insertMemberInfor(member);


        }catch (Exception e){
            e.printStackTrace();
            CommonUtil.write(response,sp);
        }

    }


}
