package hpu.edu.xingsi.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zhou'en'xian
 * @date 2020/9/13  11:23
 */
@Data
@TableName("history_person")
public class HistoryPersonDO implements Serializable {
    @TableId(value = "history_person_id",type = IdType.AUTO)
    private Integer historyPersonId;
    @TableField("name")
    private String name;
    @TableField("grade")
    private String grade;
    @TableField("job")
    private String job;
    @TableField("year_id")
    private Integer yearId;
    @TableField("weight")
    private Integer weight;
    @TableField("comment")
    private String  comment;

}
