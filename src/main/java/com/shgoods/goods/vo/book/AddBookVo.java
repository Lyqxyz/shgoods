package com.shgoods.goods.vo.book;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author lyq
 */
@Data
public class AddBookVo {

    @NotNull(message = "书名解析异常")
    @NotBlank(message = "书名不能为空")
    private String bookName;

    @NotNull(message = "ISBN解析异常")
    @NotBlank(message = "ISBN书名不能为空")
    private String bookIsbn;

    private String bookAuthor;

    private String bookPublish;

    private Double bookOriginalPrice;

    @NotNull(message = "售价解析异常")
    @Min(value = 0,message = "售价不能是负数")
    private Double bookSellingPrice;

    @Max(value = 999,message = "数量不能超过999")
    @Min(value = 1,message = "数量不能小于1")
    private Integer bookCount;

    @Max(value = 10,message = "新旧不能超过10")
    @Min(value = 1,message = "新旧不能小于1")
    private Integer bookNao;

    private String bookDes;

    private Integer bookState;

    private String cid;

}
