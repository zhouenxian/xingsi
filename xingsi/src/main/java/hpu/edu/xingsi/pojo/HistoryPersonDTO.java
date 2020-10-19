package hpu.edu.xingsi.pojo;


import java.io.Serializable;

/**
 * @author zhou'en'xian
 * @date 2020/9/6  16:06
 */
public class HistoryPersonDTO implements Serializable {
    private Integer historyId ;
    private String name;
    private String grade;
    private  String job;

    public Integer getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Integer historyId) {
        this.historyId = historyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public HistoryPersonDTO(Integer historyId, String name, String grade, String job, Integer weight) {
        this.historyId = historyId;
        this.name = name;
        this.grade = grade;
        this.job = job;
        this.weight = weight;
    }

    private Integer weight;

    public HistoryPersonDTO() {
    }
}
