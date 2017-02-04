package com.gemantic.wealth.application.model;

public class RecommendWithBLOBs extends Recommend {
    private String backupImg;

    private String comment;

    public String getBackupImg() {
        return backupImg;
    }

    public void setBackupImg(String backupImg) {
        this.backupImg = backupImg == null ? null : backupImg.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}