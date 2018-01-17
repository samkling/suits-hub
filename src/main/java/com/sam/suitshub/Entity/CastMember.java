package com.sam.suitshub.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
@Table(name = "castmember")
public class CastMember implements Serializable {
    //private static final long serialVersionUID = -3009157732242241606L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "job")
    private String job;

    protected CastMember() {
    }

    public CastMember(long id, String name, String job){
        this.id = id;
        this.name = name;
        this.job = job;
    }

    public CastMember(String name, String job) {
        this.name = name;
        this.job = job;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
