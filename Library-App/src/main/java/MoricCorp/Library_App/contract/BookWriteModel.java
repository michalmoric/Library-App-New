package MoricCorp.Library_App.contract;

import MoricCorp.Library_App.domain.model.Book;

public class BookWriteModel {

    private String title;
    private String genre;
    private int yearNum;
    private String serialNum;
    private int inStockNum;

    
    
    public BookWriteModel(String title, String genre, int yearNum, String serialNum, int inStockNum) {
        this.title = title;
        this.genre = genre;
        this.yearNum = yearNum;
        this.serialNum = serialNum;
        this.inStockNum = inStockNum;
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

    public Book toBook(){
        var result = new Book();
        result.setTitle(title);
        result.setGenre(genre);
        result.setYearNum(yearNum);
        result.setSerialNum(serialNum);
        result.setInStockNum(inStockNum);
        return result;
    }
    
}
