package top.wuhao.contentservice.VO;



public class AuthorVO {
    private int id;
    private String user_name;  // 修改字段名为 user_name
    private String avatar_url; // 修改字段名为 avatar_url

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
}

