package com.jl;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

/**
 * @program: jl
 * @author: JL
 * @create: 2019-11-12 10:24
 * @description:
 **/
public class TestHttpClient {
    /**
     * 1.实例化httpClient对象
     * 2.准备url请求地址 https: //www.baidu.com/
     * 3.封装请求方式对象 GET/POST/PUT/DELETE
     * 4.发起http请求,获取服务器响应.
     * 5.判断返回值状态码信息200
     * 6.从响应对象中获取服务器返回值数据.
     */
    @Test
    public void testGet() throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        String url = "https://www.baidu.com";
        HttpGet get = new HttpGet(url);
        CloseableHttpResponse response = client.execute(get);
        if (response.getStatusLine().getStatusCode() == 200) {
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity, "UTF-8");
            System.out.println(result);

        }

    }
}
