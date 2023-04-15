package com.friendsofgroot.app.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BaseModel implements Serializable {

        private static final long serialVersionUID = 1L;

        int id;

        @Version
        private Integer version;

        @Column(name = "date_created", nullable = false, updatable = false)
        private Date dateCreated;
        @Column(name = "last_updated")
        private Date lastUpdated;

//        @Column(name = "created_at", nullable = false, updatable = false)
//        @CreationTimestamp
//        private Timestamp createdAt;

        @Column(name = "updated_at")
        @UpdateTimestamp
        private Timestamp updatedAt;

}
