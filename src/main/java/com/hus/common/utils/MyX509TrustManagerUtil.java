package com.hus.common.utils;

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * 证书信任管理器（用于https请求）
 */
public class MyX509TrustManagerUtil implements X509TrustManager {

    /**
     * @param chain c
     * @param authType t
     * @throws CertificateException 异常
     */
    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
    }

    /**
     * @param chain c
     * @param authType t
     * @throws CertificateException 异常
     */
    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
    }

    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}