package hpu.edu.xingsi.Enum;

import lombok.Getter;

/**
 * @author zhou'en'xian
 * @date 2020/8/31  11:50
 */
@Getter
public enum ServerUrlEnum {
    SERVER_URL_ENUM("http://114.116.249.190:8888/")
    ;
    private String url;

    ServerUrlEnum(String url){
        this.url=url;
    }
}
