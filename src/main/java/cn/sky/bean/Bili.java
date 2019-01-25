package cn.sky.bean;

public class Bili {
    private boolean is_completed;
    private Long total_bytes;
    private Long downloaded_bytes;
    private String title;
    private String type_tag;
    private String cover;
    private int prefered_video_quality;
    private Long guessed_total_bytes;
    private Long total_time_milli;
    private int danmaku_count;
    private Long time_update_stamp;
    private Long time_create_stamp;
    private Long avid;
    private int spid;
    private int seasion_id;
    private PageData page_data;

    public boolean isIs_completed() {
        return is_completed;
    }

    public void setIs_completed(boolean is_completed) {
        this.is_completed = is_completed;
    }

    public Long getTotal_bytes() {
        return total_bytes;
    }

    public void setTotal_bytes(Long total_bytes) {
        this.total_bytes = total_bytes;
    }

    public Long getDownloaded_bytes() {
        return downloaded_bytes;
    }

    public void setDownloaded_bytes(Long downloaded_bytes) {
        this.downloaded_bytes = downloaded_bytes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType_tag() {
        return type_tag;
    }

    public void setType_tag(String type_tag) {
        this.type_tag = type_tag;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public int getPrefered_video_quality() {
        return prefered_video_quality;
    }

    public void setPrefered_video_quality(int prefered_video_quality) {
        this.prefered_video_quality = prefered_video_quality;
    }

    public Long getGuessed_total_bytes() {
        return guessed_total_bytes;
    }

    public void setGuessed_total_bytes(Long guessed_total_bytes) {
        this.guessed_total_bytes = guessed_total_bytes;
    }

    public Long getTotal_time_milli() {
        return total_time_milli;
    }

    public void setTotal_time_milli(Long total_time_milli) {
        this.total_time_milli = total_time_milli;
    }

    public int getDanmaku_count() {
        return danmaku_count;
    }

    public void setDanmaku_count(int danmaku_count) {
        this.danmaku_count = danmaku_count;
    }

    public Long getTime_update_stamp() {
        return time_update_stamp;
    }

    public void setTime_update_stamp(Long time_update_stamp) {
        this.time_update_stamp = time_update_stamp;
    }

    public Long getTime_create_stamp() {
        return time_create_stamp;
    }

    public void setTime_create_stamp(Long time_create_stamp) {
        this.time_create_stamp = time_create_stamp;
    }

    public Long getAvid() {
        return avid;
    }

    public void setAvid(Long avid) {
        this.avid = avid;
    }

    public int getSpid() {
        return spid;
    }

    public void setSpid(int spid) {
        this.spid = spid;
    }

    public int getSeasion_id() {
        return seasion_id;
    }

    public void setSeasion_id(int seasion_id) {
        this.seasion_id = seasion_id;
    }

    public PageData getPage_data() {
        return page_data;
    }

    public void setPage_data(PageData page_data) {
        this.page_data = page_data;
    }

    @Override
    public String toString() {
        return "{" +
                "is_completed:" + is_completed +
                ", total_bytes:" + total_bytes +
                ", downloaded_bytes:" + downloaded_bytes +
                ", title:'" + title + '\'' +
                ", type_tag:'" + type_tag + '\'' +
                ", cover:'" + cover + '\'' +
                ", prefered_video_quality:" + prefered_video_quality +
                ", guessed_total_bytes:" + guessed_total_bytes +
                ", total_time_milli:" + total_time_milli +
                ", danmaku_count:" + danmaku_count +
                ", time_update_stamp:'" + time_update_stamp + '\'' +
                ", time_create_stamp:'" + time_create_stamp + '\'' +
                ", avid:" + avid +
                ", spid:" + spid +
                ", seasion_id:" + seasion_id +
                ", page_data:" + page_data +
                '}';
    }
}
