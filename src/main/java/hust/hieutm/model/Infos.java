package hust.hieutm.model;

public class Infos {
    private int id;
    private String name;
    private String profile;
    private String avatar;
    private String email;
    private int phone;
    private String about;
    private String introTitle;
    private String introSubtitle;

    public Infos() {
    }

    public Infos(String name, String profile, String avatar, String email, int phone, String about, String introTitle, String introSubtitle) {
        this.name = name;
        this.profile = profile;
        this.avatar = avatar;
        this.email = email;
        this.phone = phone;
        this.about = about;
        this.introTitle = introTitle;
        this.introSubtitle = introSubtitle;
    }

    public Infos(int id, String name, String profile, String avatar, String email, int phone, String about, String introTitle, String introSubtitle) {
        this.id = id;
        this.name = name;
        this.profile = profile;
        this.avatar = avatar;
        this.email = email;
        this.phone = phone;
        this.about = about;
        this.introTitle = introTitle;
        this.introSubtitle = introSubtitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getIntroTitle() {
        return introTitle;
    }

    public void setIntroTitle(String introTitle) {
        this.introTitle = introTitle;
    }

    public String getIntroSubtitle() {
        return introSubtitle;
    }

    public void setIntroSubtitle(String introSubtitle) {
        this.introSubtitle = introSubtitle;
    }

    @Override
    public String toString() {
        return "Infos{" +
                "name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", about='" + about + '\'' +
                ", introTitle='" + introTitle + '\'' +
                ", introSubtitle='" + introSubtitle + '\'' +
                '}';
    }
}
