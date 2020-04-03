package org.github.iamsrr.httpkit.http;

import org.apache.http.HttpHost;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.SocketConfig;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.github.iamsrr.httpkit.http.request.BasicParameterRequest;
import org.github.iamsrr.httpkit.http.request.BasicUriRequest;
import org.github.iamsrr.httpkit.http.request.RequestBase;

import java.net.URI;

/**
 * Http工具类
 * 提供get, post, put, delete请求
 * 支持连接池管理,参数可自行配置,此连接池为全局对象,请不要关闭
 */
public class HttpKit {

    /**
     * TLS协议
     */
    public static final String TLS = "TLS";
    /**
     * http请求连接池
     */
    private static final PoolingHttpClientConnectionManager POOL_MANAGER = new PoolingHttpClientConnectionManager();
    private static final HttpKit KIT = new HttpKit();

    private HttpKit() {
    }

    /**
     * 设置默认连接配置
     *
     * @param defaultConnectionConfig 连接配置
     * @return
     */
    public static HttpKit setDefaultConnectionConfig(final ConnectionConfig defaultConnectionConfig) {
        POOL_MANAGER.setDefaultConnectionConfig(defaultConnectionConfig);
        return KIT;
    }

    /**
     * 设置默认最大路由数
     *
     * @param max 最大路由数
     * @return
     */
    public static HttpKit setDefaultMaxPerRoute(final int max) {
        POOL_MANAGER.setDefaultMaxPerRoute(max);
        return KIT;
    }

    /**
     * 设置连接配置
     *
     * @param host             Http主机
     * @param connectionConfig 连接配置
     * @return
     */
    public static HttpKit setConnectionConfig(final HttpHost host, final ConnectionConfig connectionConfig) {
        POOL_MANAGER.setConnectionConfig(host, connectionConfig);
        return KIT;
    }

    /**
     * 获取默认Socket配置
     *
     * @return
     */
    public static SocketConfig getDefaultSocketConfig() {
        return POOL_MANAGER.getDefaultSocketConfig();
    }

    /**
     * 设置默认Socket配置
     *
     * @param defaultSocketConfig Socket配置
     * @return
     */
    public static HttpKit setDefaultSocketConfig(final SocketConfig defaultSocketConfig) {
        POOL_MANAGER.setDefaultSocketConfig(defaultSocketConfig);
        return KIT;
    }

    /**
     * 创建post请求
     *
     * @param url 请求地址
     * @return
     */
    public static RequestBase post(String url) {
        return new BasicParameterRequest(new HttpPost(url), POOL_MANAGER);
    }

    /**
     * 创建get请求
     *
     * @param url 请求地址
     * @return
     */
    public static RequestBase get(String url) {
        return new BasicUriRequest(new HttpGet(url), POOL_MANAGER);
    }

    /**
     * 创建put请求
     *
     * @param url 请求地址
     * @return
     */
    public static RequestBase put(String url) {
        return new BasicParameterRequest(new HttpPut(url), POOL_MANAGER);
    }

    /**
     * 创建delete请求
     *
     * @param url 请求地址
     * @return
     */
    public static RequestBase delete(String url) {
        return new BasicUriRequest(new HttpDelete(url), POOL_MANAGER);
    }

    /**
     * 创建post请求
     *
     * @param uri 请求地址
     * @return
     */
    public static RequestBase post(URI uri) {
        return post(uri.toString());
    }

    /**
     * 创建get请求
     *
     * @param uri 请求地址
     * @return
     */
    public static RequestBase get(URI uri) {
        return get(uri.toString());
    }

    /**
     * 创建put请求
     *
     * @param uri 请求地址
     * @return
     */
    public static RequestBase put(URI uri) {
        return put(uri.toString());
    }

    /**
     * 创建delete请求
     *
     * @param uri 请求地址
     * @return
     */
    public static RequestBase delete(URI uri) {
        return delete(uri.toString());
    }

    /**
     * 创建post请求
     *
     * @param url 请求地址
     * @return
     */
    public static RequestBase post(String url, RequestBase request) {
        return new BasicParameterRequest(new HttpPost(url), request, POOL_MANAGER);
    }

    /**
     * 创建get请求
     *
     * @param url 请求地址
     * @return
     */
    public static RequestBase get(String url, RequestBase request) {
        return new BasicUriRequest(new HttpGet(url), request, POOL_MANAGER);
    }

    /**
     * 创建put请求
     *
     * @param url 请求地址
     * @return
     */
    public static RequestBase put(String url, RequestBase request) {
        return new BasicParameterRequest(new HttpPut(url), request, POOL_MANAGER);
    }

    /**
     * 创建delete请求
     *
     * @param url 请求地址
     * @return
     */
    public static RequestBase delete(String url, RequestBase request) {
        return new BasicUriRequest(new HttpDelete(url), request, POOL_MANAGER);
    }

    /**
     * 创建post请求
     *
     * @param uri 请求地址
     * @return
     */
    public static RequestBase post(URI uri, RequestBase request) {
        return post(uri.toString(), request);
    }

    /**
     * 创建get请求
     *
     * @param uri 请求地址
     * @return
     */
    public static RequestBase get(URI uri, RequestBase request) {
        return get(uri.toString(), request);
    }

    /**
     * 创建put请求
     *
     * @param uri 请求地址
     * @return
     */
    public static RequestBase put(URI uri, RequestBase request) {
        return put(uri.toString(), request);
    }

    /**
     * 创建delete请求
     *
     * @param uri 请求地址
     * @return
     */
    public static RequestBase delete(URI uri, RequestBase request) {
        return delete(uri.toString(), request);
    }
}
