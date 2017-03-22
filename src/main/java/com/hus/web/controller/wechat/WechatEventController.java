package com.hus.web.controller.wechat;

import com.hus.common.consts.Url;
import com.hus.web.utils.SignUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhu on 2017/3/14.
 */
@Controller
public class WechatEventController {
    /**
     *
     * @param signature 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数
     * @param timestamp 时间戳
     * @param nonce     随机数
     * @param echostr   随机字符串
     * @return
     */
    @RequestMapping(value = Url.Wechat.CORE_SERVICE, method = RequestMethod.GET)
    @ResponseBody
    public String chectToken(@RequestParam(value = "signature") String signature,
                             @RequestParam(value = "timestamp") String timestamp,
                             @RequestParam(value = "nonce") String nonce,
                             @RequestParam(value = "echostr") String echostr) {
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            return echostr;
        }
        return "failed!";
    }
}
