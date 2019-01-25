package cn.sky.bean;

public class PageData {
    private Long cid;
    private int page;
    private String from;
    private String part;
    private int vid;
    private  boolean has_alias;
    private String weblink;
    private int tid;

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public boolean isHas_alias() {
        return has_alias;
    }

    public void setHas_alias(boolean has_alias) {
        this.has_alias = has_alias;
    }

    public String getWeblink() {
        return weblink;
    }

    public void setWeblink(String weblink) {
        this.weblink = weblink;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "{" +
                "cid:" + cid +
                ", page:" + page +
                ", from:'" + from + '\'' +
                ", part:'" + part + '\'' +
                ", vid:" + vid +
                ", has_alias:" + has_alias +
                ", weblink:'" + weblink + '\'' +
                ", tid:" + tid +
                '}';
    }
}
