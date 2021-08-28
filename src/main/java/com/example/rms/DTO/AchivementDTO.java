package com.example.rms.DTO;

import java.util.Date;

public class AchivementDTO {
     Integer achievements_id;
     Date time_achi;
     String name_achi;
     String image;
      Integer profile_id;

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

    public Integer getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(Integer profile_id) {
        this.profile_id = profile_id;
    }
}
