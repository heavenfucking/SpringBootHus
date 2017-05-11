package com.hus;

import com.hus.common.consts.App;
import com.hus.common.consts.Url;
import com.hus.common.utils.MyX509TrustManagerUtil;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() throws Exception{
				String s = "{\"button\":[{\"name\":\"休闲娱乐\",\"sub_button\":[{\"type\":\"click\",\"name\":\"笑话大全\",\"key\":\"m_joke\"},{\"type\":\"click\",\"name\":\"内涵段子\",\"key\":\"m_duanzi\"},{\"type\":\"click\",\"name\":\"爆笑图片\",\"key\":\"m_laughImg\"}]},{\"name\":\"实用工具\",\"sub_button\":[{\"type\":\"click\",\"name\":\"天气查询\",\"key\":\"m_weather\"},{\"type\":\"click\",\"name\":\"公交查询\",\"key\":\"m_bus\"},{\"type\":\"click\",\"name\":\"功能菜单\",\"key\":\"m_sysmenu\"}]},{\"name\":\"消息示例\",\"sub_button\":[{\"type\":\"click\",\"name\":\"关于企特\",\"key\":\"m_about\"},{\"type\":\"click\",\"name\":\"图文消息\",\"key\":\"m_imgmsg\"},{\"type\":\"click\",\"name\":\"音乐消息\",\"key\":\"m_musicmsg\"}]}]}";
         // System.out.println(s);
		getNormalMenuList();
	}

	/**
	 * 获取微信默认菜单
	 * @author 张进军
	 * @date Jan 27, 2016 11:39:58 AM
	 * @param storeId    门店标识
	 * @return   微信默认菜单
	 */
	private boolean getNormalMenuList() throws Exception{

		String url = Url.Wechat.CREATE_NORMAL_MENU_URL.replace("ACCESS_TOKEN", getAccessToken());
		JSONObject resultJson = httpRequest(url, "POST", "  {\n" +
				"     \"button\":[\n" +
				"      {\n" +
				"           \"name\":\"自助服务\",\n" +
				"           \"sub_button\":[\n" +
				"           {\n" +
				"               \"type\":\"view\",\n" +
				"               \"name\":\"高校学生选课系统学生登录\",\n" +
				"               \"url\":\"http://17157bv023.51mypc.cn/hus/wechat/enter\"\n" +
				"            }]\n" +
				"       }]\n" +
				" }");
		return  false;
	}

	/**
	 * 获取accessToken
	 */
	public  String getAccessToken() throws Exception {
		String url = Url.Wechat.GET_ACCESSTOKEN;
		url = url.replace("APPID", App.Wechat.APPID);
		url = url.replace("APPSECRET", App.Wechat.APPSECRET);
		JSONObject json = httpRequest(url, "GET", null);
		String accessToken = json.getString("access_token");
		return accessToken;

	}
	/**
	 * HTTPS 请求方式
	 * @author 朱昊
	 * @date 2015年8月10日 下午11:47:59
	 * @param requestUrl 请求链接
	 * @param requestMethod 请求方式
	 * @param outputStr 请求数据
	 * @return 返回json
	 */
	public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {
		JSONObject jsonObject = null;
		StringBuffer buffer = new StringBuffer();
		try {
			TrustManager[] tm = { new MyX509TrustManagerUtil() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			SSLSocketFactory ssf = sslContext.getSocketFactory();
			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url
					.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);
			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			httpUrlConn.setRequestMethod(requestMethod);
			if ("GET".equalsIgnoreCase(requestMethod)) {
				httpUrlConn.connect();
			}
			if (null != outputStr) {
				OutputStream outputStream = httpUrlConn.getOutputStream();
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);
			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
			jsonObject = JSONObject.fromObject(buffer.toString());
		}
		catch (Exception ce) {
			ce.printStackTrace();
		}
		System.out.println(jsonObject.toString());
		return jsonObject;
	}

}
