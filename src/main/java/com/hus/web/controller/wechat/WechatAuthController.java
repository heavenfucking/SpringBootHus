package com.hus.web.controller.wechat;
import com.hus.common.consts.App;
import com.hus.common.consts.Url;
import com.hus.common.consts.View;
import com.hus.common.utils.MyX509TrustManagerUtil;
import com.hus.web.utils.HttpClientUtil;
import io.swagger.annotations.Api;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;

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
//    @ResponseBody
    public ModelAndView callBack(String code, String state, HttpServletRequest request)
    {
         if(StringUtils.isBlank(code)){
             request.setAttribute("error_tips", "获取openId失败");
             return new ModelAndView(View.Error.ERROR_PAGE_VIEW);
         }
         String accessTokenRes = HttpClientUtil.sendPostRequest(String.format(Url.Wechat.AUTH_ACCESS_TOKEN_URL,
                 App.Wechat.APPID, App.Wechat.APPSECRET, code), null, HttpClientUtil.REQUEST_PARAM_DATA_TYPE_POST);
        JSONObject accessTokenJson = JSONObject.fromObject(accessTokenRes);
        //授权失败
        if (accessTokenJson.containsKey("errcode")) {
            String errcode = accessTokenJson.get("errcode").toString();
            String errmsg = accessTokenJson.get("errmsg").toString();
            logger.error("use weixin login err, code " + code + ", errcode " + errcode + ", errmsg " + errmsg);
            request.setAttribute("error_tips", "获取openId失败");
            return new ModelAndView(View.Error.ERROR_PAGE_VIEW);
        }
        request.getSession().setAttribute(App.Session.WECHAT_USER_OPEN_ID, accessTokenJson.getString("openid"));
        request.getSession().setAttribute(App.Session.WECHAT_USER_ACCESS_TOKEN, accessTokenJson.getString("access_token"));
//        getNormalMenuList(accessTokenJson.getString("access_token"));
        return new ModelAndView("redirect:/"+Url.Login.WECHAT_USER_LOGIN_URL);
    }

//    /**
//     * 获取微信默认菜单
//     * @author 张进军
//     * @date Jan 27, 2016 11:39:58 AM
//     * @param storeId    门店标识
//     * @return   微信默认菜单
//     */
//    private boolean getNormalMenuList(String accessToken){
//
//
//        JSONObject normalMemu = new JSONObject();
//        String url = Url.Wechat.CREATE_NORMAL_MENU_URL.replace("ACCESS_TOKEN", accessToken);
//        JSONObject resultJson =httpRequest(url, "POST", "{\n" +
//                "     \"button\":[\n" +
//                "     {\t\n" +
//                "          \"type\":\"click\",\n" +
//                "          \"name\":\"今日歌曲\",\n" +
//                "          \"key\":\"V1001_TODAY_MUSIC\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "           \"name\":\"菜单\",\n" +
//                "           \"sub_button\":[\n" +
//                "           {\t\n" +
//                "               \"type\":\"view\",\n" +
//                "               \"name\":\"搜索\",\n" +
//                "               \"url\":\"http://www.soso.com/\"\n" +
//                "            },\n" +
//                "            {\n" +
//                "               \"type\":\"view\",\n" +
//                "               \"name\":\"视频\",\n" +
//                "               \"url\":\"http://v.qq.com/\"\n" +
//                "            },\n" +
//                "            {\n" +
//                "               \"type\":\"click\",\n" +
//                "               \"name\":\"赞一下我们\",\n" +
//                "               \"key\":\"V1001_GOOD\"\n" +
//                "            }]\n" +
//                "       }]\n" +
//                " }");
//        if (resultJson.containsKey("errcode") && resultJson.getInt("errcode") != 0) {
//            return false;
//        }
//        return true;
//    }
//
//    /**
//     * HTTPS 请求方式
//     * @author 高国藩
//     * @date 2015年8月10日 下午11:47:59
//     * @param requestUrl 请求链接
//     * @param requestMethod 请求方式
//     * @param outputStr 请求数据
//     * @return 返回json
//     */
//    public static JSONObject httpRequest(String requestUrl,
//                                         String requestMethod, String outputStr) {
//        JSONObject jsonObject = null;
//        StringBuffer buffer = new StringBuffer();
//        try {
//            TrustManager[] tm = { new MyX509TrustManagerUtil() };
//            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
//            sslContext.init(null, tm, new java.security.SecureRandom());
//            SSLSocketFactory ssf = sslContext.getSocketFactory();
//            URL url = new URL(requestUrl);
//            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url
//                    .openConnection();
//            httpUrlConn.setSSLSocketFactory(ssf);
//            httpUrlConn.setDoOutput(true);
//            httpUrlConn.setDoInput(true);
//            httpUrlConn.setUseCaches(false);
//            httpUrlConn.setRequestMethod(requestMethod);
//            if ("GET".equalsIgnoreCase(requestMethod)) {
//                httpUrlConn.connect();
//            }
//            if (null != outputStr) {
//                OutputStream outputStream = httpUrlConn.getOutputStream();
//                outputStream.write(outputStr.getBytes("UTF-8"));
//                outputStream.close();
//            }
//            InputStream inputStream = httpUrlConn.getInputStream();
//            InputStreamReader inputStreamReader = new InputStreamReader(
//                    inputStream, "utf-8");
//            BufferedReader bufferedReader = new BufferedReader(
//                    inputStreamReader);
//            String str = null;
//            while ((str = bufferedReader.readLine()) != null) {
//                buffer.append(str);
//            }
//            bufferedReader.close();
//            inputStreamReader.close();
//            inputStream.close();
//            inputStream = null;
//            httpUrlConn.disconnect();
//            jsonObject = JSONObject.fromObject(buffer.toString());
//        }
//        catch (Exception ce) {
//            ce.printStackTrace();
//        }
//       // logger.info(jsonObject.toString());
//        return jsonObject;
//    }

}
