package com.cms.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by raviagrawal on 23/03/17.
 */
@Getter @Setter
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Temporal(value = TemporalType.TIMESTAMP)
    protected Date created;

    @Temporal(value = TemporalType.TIMESTAMP)
    protected Date lastModified;

    @PrePersist
    @PreUpdate
    void setPreDefaultValues(){
        if(created == null){
            created = new Date();
        }
        lastModified = new Date();
    }

}
