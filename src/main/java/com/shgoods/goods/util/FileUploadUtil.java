package com.shgoods.goods.util;

import com.shgoods.goods.exception.FileUploadException;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Component
public final class FileUploadUtil {

    @Value("${file.uploadFolder}")
    private  String uploadFolder;

    @Value("${file.staticAccessPath}")
    private  String statiCaccessPath;

    @Value("${file.types}")
    private List<String> types;

    private String USERIMAGE="userImage";

    private String GOODSIMAGE="goodsImage";

    private String BOOKIMAGE="bookImage";

    private long maxSize=500*1024;

    private long minSize=50*1024;

    public boolean checkType(String type){

        if ("".equals(type)||type==null){

            return false;
        }
        return this.types.contains(type);
    }

    public boolean checkSize(long size){

        if(size>=minSize&&size<=maxSize){

            return true;
        }
        return false;

    }

    /**
     * 文件夹名(example image/20190103)
     * @return
     * @throws IOException
     */
    public String filePath() throws IOException{

        String imgPath=uploadFolder+"image/";
        File file = new File(imgPath);
        if(!file.exists()){
            FileUtils.forceMkdir(file);
        }
        DateTimeFormatter yyyYmmdd = DateTimeFormatter.ofPattern("YYYYMMdd");

        String format = yyyYmmdd.format(LocalDateTime.now());

        String u = imgPath+format;

        File file1= new File(u);

        if(!file1.exists()){
            FileUtils.forceMkdir(file1);
        }
        return u;
    }


    public void upload(MultipartFile multipartFile) throws IOException {

        if(multipartFile==null){

            throw new FileUploadException("图片上传失败");
        }
        if(multipartFile.isEmpty()){

            throw new FileUploadException("图片不能为空");
        }
        String originalFilename = multipartFile.getOriginalFilename();

        String contentType = multipartFile.getContentType();

        long size = multipartFile.getSize();

        boolean b = this.checkSize(size);

        if(!b){
            throw new FileUploadException("图片超出大小");
        }

        boolean b1 = this.checkType(contentType);
        if(!b1){

            throw new FileUploadException("图片格式不正确");
        }

    }


}
