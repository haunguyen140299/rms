package com.example.rms.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="achievements")
public class Achievements {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer achievements_id;
    private Date time_achi;
    private String name_achi;
    private String image;
    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    public Achievements() {

    }

    public Integer getAchievements_id() {
        return achievements_id;
    }

    public void setAchievements_id(Integer achievements_id) {
        this.achievements_id = achievements_id;
    }

    public Date getTime_achi() {
        return time_achi;
    }

    public void setTime_achi(Date time_achi) {
        this.time_achi = time_achi;
    }

    public String getName_achi() {
        return name_achi;
    }

    public void setName_achi(String name_achi) {
        this.name_achi = name_achi;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Achievements(Integer achievements_id, Date time_achi, String name_achi, String image, Profile profile) {
        this.achievements_id = achievements_id;
        this.time_achi = time_achi;
        this.name_achi = name_achi;
        this.image = image;
        this.profile = profile;
    }
}