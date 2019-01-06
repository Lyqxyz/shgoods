package com.shgoods.goods;


import net.coobird.thumbnailator.Thumbnailator;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;
import net.coobird.thumbnailator.util.ThumbnailatorUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThumbnailsTest {


    @Test
    public void test1() throws IOException {

        String a ="E://uploadFiles/image/2019-01-06/";
        String path ="E://uploadFiles/image/2019-01-06/a.png";
        Thumbnails.of(path).size(50,50).toFile(a+"5050b.png");

        Thumbnails.of(path).size(2000,2000).toFile(a+"200020000b.png");
        Thumbnails.of(path).scale(1.1).toFile(a+"1.1b.png");

        Thumbnails.of(path).scale(1.1).toFile(a+"1.1b.png");

        Thumbnails.of(path).scale(0.5).toFile(a+"0.5b.png");

        Thumbnails.of(path).scale(1.1).toFiles(Rename.PREFIX_DOT_THUMBNAIL);




    }
}
