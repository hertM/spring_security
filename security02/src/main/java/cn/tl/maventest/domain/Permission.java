package cn.tl.maventest.domain;

/**
 *
 * 权限
 *
 */
public class Permission {


    private Integer id;
    private String pername;
    private String pertag;


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getPername() {
        return pername;
    }

    public void setPername(String pername) {
        this.pername = pername;
    }

    public String getPertag() {
        return pertag;
    }

    public void setPertag(String pertag) {
        this.pertag = pertag;
    }


    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", pername='" + pername + '\'' +
                ", pertag='" + pertag + '\'' +
                '}';
    }
}
