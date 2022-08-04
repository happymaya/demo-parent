package cn.happymaya.zuul.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author superhsc
 */
@Configuration
public class FilterConfiguration {
    @Bean
    public PreRequestLogFilter preRequestLogFilter() {
        return new PreRequestLogFilter();
    }
}
