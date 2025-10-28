package clc65.ithanhphan.onthigiuaki;

public class infoActi {
    private String title, time, image;

    public infoActi(String title, String time, String image) {
        this.title = title;
        this.time = time;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
