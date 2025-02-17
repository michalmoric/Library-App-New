package MoricCorp.Library_App.contract;

import MoricCorp.Library_App.domain.model.Book;

public class BookReadModel {
    private String title;
    private String genre;
    private int yearNum;
    private String serialNum;
    private int inStockNum;

    public BookReadModel(Book source){
        title = source.getTitle();
        genre = source.getGenre();
        yearNum = source.getYearNum();
        serialNum = source.getSerialNum();
        inStockNum = source.getInStockNum();
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

    

}
