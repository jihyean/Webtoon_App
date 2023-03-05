package com.sample.dbtest;
//데이터베이스에서 가져올 정보들을 정의함
public class Item {

    int C_id; //int 형으로 정의
    String C_title;
    String C_info;
    String C_img;
    String C_href;
    String C_notice;
    String C_date;

    public Item() {
    }

    public Item(int C_id, String C_title, String C_info, String C_img, String C_href, String C_notice, String C_date) {
        this.C_id = C_id; //this를 사용하여 대치(Place_id자체는 많기 때문)
        this.C_title = C_title;
        this.C_info = C_info;
        this.C_img = C_img;
        this.C_href = C_href;
        this.C_notice = C_notice;
        this.C_date = C_date;
    }

    //Placed_id 등등의 변수를 데이터베이스에서 가져오는 함수를 만든것(get은 가져오고 set으로 대입)
    public int getC_id() {
        return C_id;
    }
    public void setC_id(int Place_id) {
        this.C_id = C_id;
    }

    public String getC_title() {
        return C_title;
    }
    public void setC_title(String C_title) {
        this.C_title = C_title;
    }

    public String getC_info() {
        return C_info;
    }
    public void setC_info(String C_info) {
        this.C_title = C_info;
    }

    public String getC_img() {
        return C_img;
    }
    public void setC_img(String C_img) {
        this.C_img = C_img;
    }

    public String getC_href() {
        return C_href;
    }
    public void setC_href(String C_href) {
        this.C_href = C_href;
    }

    public String getC_notice() {
        return C_notice;
    }
    public void setC_notice(String C_notice) {
        this.C_notice = C_notice;
    }

    public String getC_date() {
        return C_date;
    }
    public void setC_date(String C_date) {
        this.C_date = C_date;
    }

}
