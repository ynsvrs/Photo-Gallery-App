package observer.models;

public class Photo {
    private String id, title, category;
    public Photo(String id, String title, String category) {
        this.id = id; this.title = title; this.category = category;
    }
    public String getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String t) { this.title = t; }
}