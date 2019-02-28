package com.silent.configs;

import org.apache.catalina.connector.Connector;
import org.apache.commons.lang3.StringUtils;
import org.apache.coyote.http11.Http11NioProtocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.File;

/**
 * \* User: silent
 * \* Date: 05/11/18 Time: 16:47
 * \* Description: 配置兼容http访问和https访问
 * \* https 支持开启双向认证
 * \
 */
@SuppressWarnings("Duplicates")
@Configuration
public class TomcatTwoConnectorConfig {
    private static final Logger logger = LoggerFactory.getLogger(TomcatTwoConnectorConfig.class);

    @Value("${spring.profiles.active}")
    private String environment;

    /**
     * https 认证的基础信息
     */
    @Value("${https.server.port}")
    private Integer port;
    @Value("${https.server.ssl.key-store}")
    private String keyStore;
    @Value("${https.server.ssl.key-password}")
    private String keyPassword;
    @Value("${https.server.ssl.key-store-password}")
    private String keyStorePassword;

    /**
     * https 双向认证配置信息
     */
    @Value("${https.server.ssl.trust-store}")
    private String trustStore;
    @Value("${https.server.ssl.trust-store-password}")
    private String trustStorePassword;
    @Value("${https.server.ssl.client-auth}")
    private String clientAuth;


    @Bean
    public TomcatServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        // 添加https的连接
        if (environment.equals("local")) {
            tomcat.addAdditionalTomcatConnectors(createStandardConnector());
        }
        if (environment.equals("dev")) {
            tomcat.addAdditionalTomcatConnectors(createStandardConnector());
        }
        //docker 打包使用
        if (environment.equals("prod") || environment.equals("test")) {
            tomcat.addAdditionalTomcatConnectors(createStandardConnectorDocker());
        }
        return tomcat;
    }

    /**
     * 配置https认证信息接口,支持开启双向认证
     * 注意:打成jar包无法读取resource下边的文件
     */
    private Connector createStandardConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
        try {
            File keystore = new ClassPathResource(keyStore).getFile();
            connector.setScheme("https");
            connector.setSecure(true);
            connector.setPort(port);
            protocol.setSSLEnabled(true);
            //此处需要设置keystore的绝对路径,相对路径无法读取
            protocol.setKeystoreFile(keystore.getAbsolutePath());
            protocol.setKeystorePass(keyStorePassword);
            protocol.setKeyPass(keyPassword);
            // 配置双向认证 优先判断是否开启双向认证
            if (StringUtils.isNotBlank(clientAuth) && clientAuth.equals("true")) {
                File keyTrustStore = new ClassPathResource(trustStore).getFile();
                protocol.setClientAuth(clientAuth);
                protocol.setTruststoreFile(keyTrustStore.getAbsolutePath());
                protocol.setTruststorePass(trustStorePassword);
            }
            return connector;
        } catch (Exception ex) {
            throw new IllegalStateException("can't access keystore: [" + "keystore" + "] or truststore: [" + "keystore" + "]", ex);
        }
    }

    /**
     * 配置https认证信息接口,支持开启双向认证
     * 注意:打成jar包无法读取resource下边的文件
     */
    private Connector createStandardConnectorDocker() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
        try {
            connector.setScheme("https");
            connector.setSecure(true);
            connector.setPort(port);
            protocol.setSSLEnabled(true);
            //此处需要设置keystore的绝对路径,相对路径无法读取
            protocol.setKeystoreFile(keyStore);
            protocol.setKeystorePass(keyStorePassword);
            protocol.setKeyPass(keyPassword);
            // 配置双向认证 优先判断是否开启双向认证
            if (StringUtils.isNotBlank(clientAuth) && clientAuth.equals("true")) {
                protocol.setClientAuth(clientAuth);
                protocol.setTruststoreFile(trustStore);
                protocol.setTruststorePass(trustStorePassword);
            }
            return connector;
        } catch (Exception ex) {
            throw new IllegalStateException("can't access keystore: [" + "keystore" + "] or truststore: [" + "keystore" + "]", ex);
        }
    }

}
