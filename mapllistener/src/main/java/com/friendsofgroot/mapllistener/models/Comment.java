package com.friendsofgroot.mapllistener.models;


import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "comments")
public class Comment  extends BaseModel {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // MUST BE AUTO; IDENTITY NO-GO with ORACLE
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String email;
    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private PostEntity post;
}
