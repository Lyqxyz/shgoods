package com.shgoods.goods.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.hibernate.validator.constraints.EAN;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.servlet.Filter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@PropertySource(value = {"classpath:Druid.properties"})
@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DruidDataSource druidDataSource(){

        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }



    @Bean
    public PlatformTransactionManager platformTransactionManager(){

        DataSourceTransactionManager manager = new DataSourceTransactionManager(druidDataSource());

        return manager;
    }

    @Bean
    public ServletRegistrationBean statViewServlet(){

        StatViewServlet statViewServlet = new StatViewServlet();

        Map<String,String> init= new HashMap<>();

        init.put("loginUsername","admin");

        init.put("loginPassword","123456");

        ServletRegistrationBean<StatViewServlet> statViewServletServletRegistrationBean = new ServletRegistrationBean<>(statViewServlet);

        statViewServletServletRegistrationBean.setUrlMappings(Arrays.asList("/druid/*"));

        statViewServletServletRegistrationBean.setInitParameters(init);

        return  statViewServletServletRegistrationBean;
    }
    @Bean
    public FilterRegistrationBean webStatFilter(){


        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();

        WebStatFilter webStatFilter = new WebStatFilter();

        filterFilterRegistrationBean.setFilter(webStatFilter);

        Map<String,String> init= new HashMap<>();

        init.put("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        filterFilterRegistrationBean.setInitParameters(init);

        filterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));


        return filterFilterRegistrationBean;

    }


}
