package com.friendsofgroot.mapllistener.dto;

import com.friendsofgroot.mapllistener.models.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * A Dto for the {@link PostEntity} entity
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostEntityDto implements Serializable {
    private Long id;
    private String did;
    private String date;
    private String author;
    private String monthOrder;
    private String cat3;

//    @NotEmpty
//    @Size(min = 10, message="Post title should have at least 10 characters")
    private String title;

//    @NotEmpty
    private String post;
    private String blogcite;

    private String username;

    private Long categoryId;

//    private Set<CommentDto> comments;
}
