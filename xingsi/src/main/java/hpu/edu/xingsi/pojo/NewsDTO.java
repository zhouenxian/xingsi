package hpu.edu.xingsi.pojo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author zhou'en'xian
 * @date 2020/9/2  16:02
 */


@ApiModel
public class NewsDTO implements Serializable {
    public NewsDTO() {
    }
    @ApiModelProperty(name = "id",value = "新闻id",dataType = "int",notes = "新闻id号",example = "1")
    private Integer id;
    @ApiModelProperty(name = "author",value = "新闻作者",required = true,dataType = "string",notes = "新闻作者",example = "王五")
    private  String author;
    @ApiModelProperty(name = "title",value = "新闻标题",required = true,dataType = "string",notes = "新闻标题",example = "快来看!假期一块学习！")
    private String title;
    @ApiModelProperty(name = "thumb",value = "新闻封面图片url地址",required = true,dataType = "string",example = "http:39.101.140.225:8080/ss.jpg")
    private  String thumb;
    @ApiModelProperty(name = "head",value = "新闻中心句",required = true,dataType = "string",notes = "新闻中心句",example = "行思工作室开展暑期培训活动")
    private String head;
    @ApiModelProperty(name = "content",value = "新闻内容",required = true,dataType = "string",notes = "新闻html文本",example = "<html><p>java</p></html>")
    private String content;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getThumb() {
        return thumb;
    }

    public String getHead() {
        return head;
    }

    public String getContent() {
        return content;
    }

    public NewsDTO(Integer id, String author, String title, String thumb, String head, String content) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.thumb = thumb;
        this.head = head;
        this.content = content;
    }

    @Override
    public String toString() {
        return "NewsDTO{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", thumb='" + thumb + '\'' +
                ", head='" + head + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
