package com.friendsofgroot.app.dto;

import com.friendsofgroot.app.models.PostEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link PostEntity} entity
 */
@Data
public class PostEntityDto implements Serializable {
    private final Long id;
    private final String did;
    private final String date;
    private final String author;
    private final String monthOrder;
    private final String cat3;
    private final String title;
    private final String post;
    private final String blogcite;
    private final String username;
}