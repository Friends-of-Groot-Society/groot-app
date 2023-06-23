package com.friendsofgroot.app.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@MappedSuperclass
public class BaseModel implements Serializable {
        @Serial
        private static final long serialVersionUID = 1L;

        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id" )
        @Id
        private int id;

        @Version
        private Integer version;

        // DATE
        @Column(name = "date_created", nullable = false, updatable = false)
        private Date dateCreated;

        @Column(name = "last_updated")
        private Date lastUpdated;


        // TIMESTAMP
        @Column(name = "created_at", nullable = false, updatable = false)
        @CreationTimestamp
        private Timestamp createdAt;

        @Column(name = "updated_at")
        @UpdateTimestamp
        private Timestamp updatedAt;

}
