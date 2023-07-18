package com.friendsofgroot.app.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@MappedSuperclass
public class BaseModel implements Serializable {
        @Serial
        private static final long serialVersionUID = 1L;

        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id" )
        private Integer id;

        @CreationTimestamp
        @Column(name = "date_created", nullable = false, updatable = false)
        private Date dateCreated;


        @Column(name = "updated_at")
        @UpdateTimestamp
        private Timestamp updatedAt;

        @UpdateTimestamp
        @Column(name = "last_updated")
        private LocalDateTime lastUpdated;

}
