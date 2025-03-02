package top.wuhao.contentservice.dto;


public class UserDTO {
    private int id;
    private String user_name;
    private String avatar_url;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return user_name;
    }

    public void setUserName(String userName) {
        this.user_name = userName;
    }

    public String getAvatarUrl() {
        return avatar_url;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatar_url = avatarUrl;
    }

    @Override
    public String toString() {
        return "UserDTO{id=" + id + ", userName='" + user_name + "', avatarUrl='" + avatar_url + "'}";
    }
}

