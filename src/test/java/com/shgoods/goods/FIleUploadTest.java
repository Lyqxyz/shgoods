package com.shgoods.goods;


import com.shgoods.goods.util.FileUploadUtil;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FIleUploadTest {

    @Autowired
    private FileUploadUtil fileUploadUtil;

    @Value("${file.types}")
    private List<String> types;


    @Test
    public void test1() throws IOException {



    }

    @Test
    public void test2(){

        DateTimeFormatter yyyYmmdd = DateTimeFormatter.ofPattern("YYYYMMdd");

        String format = yyyYmmdd.format(LocalDateTime.now());

        System.out.println(format);


    }

}
