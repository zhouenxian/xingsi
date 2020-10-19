package hpu.edu.xingsi.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zhou'en'xian
 * @date 2020/9/13  9:47
 */
@Data
@TableName("history_year")
public class HistoryYearDO implements Serializable {
    @TableId("history_year_id")
    private Integer historyYearId;
    @TableField("year")
    private String year;
    @TableField("description")
    private String description;
}
