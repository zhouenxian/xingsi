package hpu.edu.xingsi.pojo;


/**
 * @author zhou'en'xian
 * @date 2020/9/6  11:06
 */

public class HistoryYearDTO {
    private Integer id;
    private String year;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HistoryYearDTO(Integer id, String year, String description) {
        this.id = id;
        this.year = year;
        this.description = description;
    }

    public HistoryYearDTO() {
    }

    @Override
    public String toString() {
        return "HistoryYearDTO{" +
                "id=" + id +
                ", year='" + year + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
