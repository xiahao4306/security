package com.jerry.security.core.validate.code.sms;

import com.jerry.security.core.properties.SecurityProperties;
import com.jerry.security.core.validate.code.ValidateCode;
import com.jerry.security.core.validate.code.ValidateCodeGenerator;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * Created with IntelliJ IDEA.
 * User: Jerry
 * Date: 2018/4/27
 * Time: 9:58
 * Description: 默认的短信验证码生成器，因为生成规则改变的可能性不大，所以不需要自己实现。
 */
@Component("smsCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {


    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public ValidateCode generate(ServletWebRequest request) {
        String code = RandomStringUtils.randomNumeric(securityProperties.getCode().getSms().getLength());
        return new ValidateCode(code, securityProperties.getCode().getImage().getExpireIn());
    }
}
