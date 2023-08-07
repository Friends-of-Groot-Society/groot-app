package com.friendsofgroot.app.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.*;
import java.lang.reflect.Array;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "NFT_REF")
public class NftRef extends BaseModel   {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    private String name;
    private String owner;
    private String email;
    private String address;
    private String chain;

    @CreationTimestamp
    @Column(name = "created_date", nullable = false, updatable = false)
    private Date dateCreated;

    @CreationTimestamp
    @Column(name = "date_created", nullable = false, updatable = false)
    private LocalDateTime createdDate;


    @UpdateTimestamp
    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updatedAt;
}
