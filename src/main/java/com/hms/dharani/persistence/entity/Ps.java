package com.hms.dharani.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long oneva;
    private String twova;
    private String threeva;
    private String fourva;

    public Ps() {
    }

    public Ps(long oneva, String twova, String threeva, String fourva) {
        this.oneva = oneva;
        this.twova = twova;
        this.threeva = threeva;
        this.fourva = fourva;
    }

    public long getOneva() {
        return oneva;
    }

    public void setOneva(long oneva) {
        this.oneva = oneva;
    }

    public String getTwova() {
        return twova;
    }

    public void setTwova(String twova) {
        this.twova = twova;
    }

    public String getThreeva() {
        return threeva;
    }

    public void setThreeva(String threeva) {
        this.threeva = threeva;
    }

    public String getFourva() {
        return fourva;
    }

    public void setFourva(String fourva) {
        this.fourva = fourva;
    }
}
