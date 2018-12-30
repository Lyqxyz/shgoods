package com.shgoods.goods.config;


import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DefaultFastJsonConfig {

    @Bean
    public FastJsonConfig fastJsonConfig(){

        FastJsonConfig fastJsonConfig = new FastJsonConfig();

        fastJsonConfig.setSerializerFeatures(
                        SerializerFeature.WriteNullStringAsEmpty,
//                        SerializerFeature.WriteNullNumberAsZero,
                        SerializerFeature.WriteNullListAsEmpty
        );


        return  fastJsonConfig;

    }

}
