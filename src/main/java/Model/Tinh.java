package Model;

public class Tinh {
    private String matp;
    private String name;
    private String type;
    private String slug;

    public Tinh(String matp, String name, String type, String slug) {
        this.matp = matp;
        this.name = name;
        this.type = type;
        this.slug = slug;
    }

    public Tinh() {
    }

    public String getMatp() {
        return matp;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getSlug() {
        return slug;
    }

    public void setMatp(String matp) {
        this.matp = matp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}
