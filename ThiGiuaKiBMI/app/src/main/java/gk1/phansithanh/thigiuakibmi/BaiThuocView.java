package gk1.phansithanh.thigiuakibmi;

public class BaiThuocView {
    private String anhBaiThuoc, tenBaiThuoc, thoiGian;

    public BaiThuocView(String anhBaiThuoc, String tenBaiThuoc, String thoiGian) {
        this.anhBaiThuoc = anhBaiThuoc;
        this.tenBaiThuoc = tenBaiThuoc;
        this.thoiGian = thoiGian;
    }

    public String getAnhBaiThuoc() {
        return anhBaiThuoc;
    }

    public void setAnhBaiThuoc(String anhBaiThuoc) {
        this.anhBaiThuoc = anhBaiThuoc;
    }

    public String getTenBaiThuoc() {
        return tenBaiThuoc;
    }

    public void setTenBaiThuoc(String tenBaiThuoc) {
        this.tenBaiThuoc = tenBaiThuoc;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }
}
