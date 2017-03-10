package com.scheduledemo.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

@ImportResource(locations = {"classpath*:spring/*.xml"})
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.scheduledemo.**.*"})
public class AppBoot implements EmbeddedServletContainerCustomizer {
    private static final Logger logger = LoggerFactory.getLogger(AppBoot.class);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AppBoot.class, args);
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
//        container.setPort(Integer.parseInt(System.getProperty("http.port")));
        int port;
        for(int i = 0; i < 10; i++) {
            port = new Random().nextInt(10000) + 10000;
            if(this.checkPortAvailable(port)){
                container.setPort(port);
                return;
            }
        }
        System.exit(1);
    }

    private boolean checkPortAvailable(int port) {
        try (Socket socket = new Socket("localhost", port)) {
            return false;
        } catch (Exception e) {
            logger.warn(e.getLocalizedMessage(), e);
            return true;
        }
    }
}