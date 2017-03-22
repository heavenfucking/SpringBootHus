package com.hus.web.controller.wechat;
import com.hus.common.consts.App;
import com.hus.common.consts.Url;
import com.hus.web.utils.HttpClientUtil;
import io.swagger.annotations.Api;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhu on 2017/3/15.
 */
@Api(value = "wechat_api", description = "微信相关Api", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
@Controller
public class WechatAuthController {

     Logger logger = Logger.getLogger(WechatAuthController.class);
    /**
     * 微信回调处理(获取用户openId)
     * @author               朱昊
     * @param code           微信返回，用于获取授权的access token
     * @param state          随机字符，用作校验
     */
    @RequestMapping(Url.Wechat.CALL_BACK)
    @ResponseBody
    public Object callBack(String code, String state, HttpServletRequest request)
    {
         if(StringUtils.isBlank(code))
             return "faild!";
         String accessTokenRes = HttpClientUtil.sendPostRequest(String.format(Url.Wechat.AUTH_ACCESS_TOKEN_URL,
                 App.Wechat.APPID, App.Wechat.APPSECRET, code), null, HttpClientUtil.REQUEST_PARAM_DATA_TYPE_POST);
        JSONObject accessTokenJson = JSONObject.fromObject(accessTokenRes);
        //授权失败
        if (accessTokenJson.containsKey("errcode")) {
            String errcode = accessTokenJson.get("errcode").toString();
            String errmsg = accessTokenJson.get("errmsg").toString();
            logger.error("use weixin login err, code " + code + ", errcode " + errcode + ", errmsg " + errmsg);
        }else {
            request.getSession().setAttribute(App.Session.WECHAT_USER_OPEN_ID, accessTokenJson.getString("openid"));
            request.getSession().setAttribute(App.Session.WECHAT_USER_ACCESS_TOKEN, "access_token");
        }
        return accessTokenJson;
    }
}
