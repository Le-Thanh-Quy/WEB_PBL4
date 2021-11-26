package Model.BEAN;

public class XaPhuong {
    public String xaid;
    public String name;
    public String type;
    public String maqh;

    public XaPhuong(String xaid, String name, String type, String maqh) {
        this.xaid = xaid;
        this.name = name;
        this.type = type;
        this.maqh = maqh;
    }

    public XaPhuong() {
    }

    public String getXaid() {
        return xaid;
    }

    public void setXaid(String xaid) {
        this.xaid = xaid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMaqh() {
        return maqh;
    }

    public void setMaqh(String maqh) {
        this.maqh = maqh;
    }
}
