package cn.happymaya.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * The application for the config server.
 * @author fangang
 */
@SpringBootApplication
@EnableConfigServer
@ImportResource(locations={"classpath:applicationContext-*.xml"})
public class ConfigApplication {

    /**
     * @param args the arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
    }

}

