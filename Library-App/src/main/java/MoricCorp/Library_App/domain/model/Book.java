package MoricCorp.Library_App.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String genre;

    private int yearNum;

    private String serialNum;

    private int inStockNum;

    private boolean isDeleted = false;

    


    public Book() {
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public int getYearNum() {
        return yearNum;
    }
    public void setYearNum(int year) {
        this.yearNum = year;
    }
    public String getSerialNum() {
        return serialNum;
    }
    public void setSerialNum(String serialNo) {
        this.serialNum = serialNo;
    }
    public int getInStockNum() {
        return inStockNum;
    }
    public void setInStockNum(int inStockNo) {
        this.inStockNum = inStockNo;
    }
    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    

}
