package com.friendsofgroot.mapllistener.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A Dto for the {@link Comment} entity
 */
@Data
public class CommentDto implements Serializable {
    private final long id;
    private final String name;
    private final String email;
    private final String body;
    private final PostEntityDto post;
}
