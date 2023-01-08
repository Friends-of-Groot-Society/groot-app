package com.friendsofgroot.app.dto;

import com.friendsofgroot.app.models.PostEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link PostEntity} entity
 */
@Data
public class PostEntityDto implements Serializable {
    private long id;
    private String did;
    private String date;
    private String author;
    private String monthOrder;
    private String cat3;
    private String title;
    private String post;
    private String blogcite;
    private String username;
}