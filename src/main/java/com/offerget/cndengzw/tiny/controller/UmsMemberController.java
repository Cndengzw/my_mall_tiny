package com.offerget.cndengzw.tiny.controller;

import com.offerget.cndengzw.tiny.common.api.CommonResult;
import com.offerget.cndengzw.tiny.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 会员登录注册管理Controller
 * @author Deng Zhiwen
 * @date 2020/8/1 15:23
 */
@RestController
@Api(tags = "UmsMemberController", description = "会员登录注册管理")
@RequestMapping("/sso")
public class UmsMemberController {

    @Autowired
    private UmsMemberService memberService;

    @ApiOperation("获取验证码")
    @GetMapping("getAuthCode")
    public CommonResult getAuthCode(@RequestParam String telephone) {
        return memberService.generateAuthCode(telephone);
    }

    @ApiOperation("判断验证码是否正确")
    @PostMapping("verifyAuthCode")
    public CommonResult updatePassword(@RequestParam String telephone,
                                       @RequestParam String authCode) {
        return memberService.verifyAuthCode(telephone,authCode);
    }
}
