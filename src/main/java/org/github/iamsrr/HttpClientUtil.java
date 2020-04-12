package org.github.iamsrr;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * @Explain:
 * @Description:
 * @Author: Shihy
 * @Date: 2020-04-07 17:04:43
 */
public class HttpClientUtil {
    public static int time_out = 0;

    public static JSONObject get(String url, String charset) {
        String result = getResult(url, time_out, charset);
        if (null == result) {
            return null;
        }
        return JSONObject.parseObject(result);
    }

    public static <T> T get(String url, Class<T> clazz, String charset) {
        String result = getResult(url, time_out, charset);
        if (null == result) {
            return null;
        }
        T t = JSONObject.parseObject(result, clazz);
        return t;
    }

    public static JSONObject get(String url) {
        String result = getResult(url, time_out, null);
        if (null == result) {
            return null;
        }
        return JSONObject.parseObject(result);
    }

    public static <T> T get(String url, Class<T> clazz) {
        String result = getResult(url, time_out, null);
        if (null == result) {
            return null;
        }
        T t = JSONObject.parseObject(result, clazz);
        return t;
    }

    public static boolean getBooleanResult(String url) {
        String result = getResult(url, time_out, null);
        if (null == result) {
            return false;
        }
        return true;
    }

    public static void getNotResult(String url) {
        getResult(url, time_out, null);
    }

    public static <T> T post(String url, Class<T> clazz, String charset) {
        String result = postResult(url, time_out, charset);
        T t = JSONObject.parseObject(result, clazz);
        return t;
    }

    public static JSONObject post(String url, String charset) {
        String result = postResult(url, time_out, charset);
        return JSONObject.parseObject(result);
    }

    public static <T> T post(String url, Class<T> clazz) {
        String result = postResult(url, time_out, null);
        T t = JSONObject.parseObject(result, clazz);
        return t;
    }

    public static JSONObject post(String url) {
        String result = postResult(url, time_out, null);
        return JSONObject.parseObject(result);
    }

    public static <T> T postWithJson(String url, JSONObject jsonObj, Class<T> clazz, String charset) {
        String result = postWithJsonResult(url, jsonObj, time_out, charset);
        T t = JSONObject.parseObject(result, clazz);
        return t;
    }

    public static JSONObject postWithJson(String url, JSONObject jsonObj, String charset) {
        String result = postWithJsonResult(url, jsonObj, time_out, charset);
        return JSONObject.parseObject(result);
    }

    public static <T> T postWithJson(String url, JSONObject jsonObj, Class<T> clazz) {
        String result = postWithJsonResult(url, jsonObj, time_out, null);
        T t = JSONObject.parseObject(result, clazz);
        return t;
    }

    public static JSONObject postWithJson(String url, JSONObject jsonObj) {
        String result = postWithJsonResult(url, jsonObj, time_out, null);
        return JSONObject.parseObject(result);
    }

    private static String getResult(String url, int secode, String charset) {
        String jsonStr = null;
        HttpGet httpGet = null;
        try {
            HttpClient httpClient = new DefaultHttpClient();
            // 设置超时时间
            if (secode != 0) {
                httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, secode * 1000);
                httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, secode * 1000);
            }
            httpGet = new HttpGet(url);
            HttpResponse response = httpClient.execute(httpGet);
            // 检验返回码
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                if (charset != null) {
                    jsonStr = EntityUtils.toString(response.getEntity(), charset);
                } else {
                    jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (httpGet != null) {
                try {
                    httpGet.releaseConnection();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return jsonStr;
    }

    private static String postResult(String url, int secode, String charset) {
        HttpPost httpPost = null;
        String jsonStr = null;
        try {
            HttpClient httpClient = new DefaultHttpClient();
            // 设置超时时间
            if (secode != 0) {
                httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, secode * 1000);
                httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, secode * 1000);
            }
            httpPost = new HttpPost(url);
            HttpResponse response = httpClient.execute(httpPost);
            // 检验返回码
            int statusCode = response.getStatusLine().getStatusCode();
            if (charset != null) {
                jsonStr = EntityUtils.toString(response.getEntity(), charset);
            } else {
                jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (httpPost != null) {
                try {
                    httpPost.releaseConnection();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return jsonStr;
    }

    private static String postWithJsonResult(String url, JSONObject jsonObj, int secode, String charset) {
        HttpPost httpPost = null;
        String jsonStr = null;
        try {
            HttpClient httpClient = new DefaultHttpClient();
            // 设置超时时间
            if (secode != 0) {
                httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, secode * 1000);
                httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, secode * 1000);
            }
            httpPost = new HttpPost(url);
            // 构造消息头
            httpPost.setHeader("Content-type", "application/json; charset=utf-8");
            httpPost.setHeader("Connection", "Close");
            // 构建消息实体
            StringEntity entity = new StringEntity(jsonObj.toString(), Charset.forName("UTF-8"));
            entity.setContentEncoding("UTF-8");
            // 发送Json格式的数据请求
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            HttpResponse response = httpClient.execute(httpPost);
            // 检验返回码
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                if (charset != null) {
                    jsonStr = EntityUtils.toString(response.getEntity(), charset);
                } else {
                    jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (httpPost != null) {
                try {
                    httpPost.releaseConnection();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return jsonStr;
    }

    /**
     * 从网络Url中下载文件
     *
     * @param client_url
     * @throws IOException
     */
    public static byte[] downLoadFromUrl(String client_url) throws IOException {
        URL url = new URL(client_url);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(5 * 1000);
        conn.setRequestProperty("Accept-Encoding", "identity");
        conn.connect();
        InputStream inputStream = conn.getInputStream();
        int count = conn.getContentLength();//获取远程资源长度
        byte[] bytes = new byte[count];
        int readCount = 0;
        while (readCount < count) {//循环读取数据
            readCount += inputStream.read(bytes, readCount, count - readCount);
        }
        return bytes;
    }
}
