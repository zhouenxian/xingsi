package hpu.edu.xingsi.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author zhou'en'xian
 * @date 2020/9/30  10:54
 */
@Component
public class ParseHtmlUtil {
    /**
     * 接受html字符串，解析找出img标签中所有的图片url地址,储存在集合中，返回集合
     * @param html
     * @return list
     */
    public List<String> parseHtmlImg(String html){
        List<String>list=new ArrayList<>();
        Document doc = Jsoup.parse(html);
        Elements elements = doc.select("img[src]");
        for(Element element:elements){
           Attributes attributes = element.attributes();
           Iterator<Attribute> iterator = attributes.iterator();
           for(;iterator.hasNext();){
               Attribute attribute=iterator.next();
               String value = attribute.getValue();
               list.add(value);
           }
       }
        return list;
    }
}
