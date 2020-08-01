package com.offerget.cndengzw.tiny.service;

import com.offerget.cndengzw.tiny.common.api.CommonResult;

/**
 * @author Deng Zhiwen
 * @date 2020/8/1 15:23
 */
public interface UmsMemberService {

    /**
     * 生成验证码
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     */
    CommonResult verifyAuthCode(String telephone, String authCode);
}
