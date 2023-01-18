package com.friendsofgroot.app.dto;


import com.friendsofgroot.app.mapper.PostEntityMapper;
import com.friendsofgroot.app.models.Comment;
import com.friendsofgroot.app.models.CommentDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mapstruct.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostEntityResponse {
    private List<PostEntityDto> content;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;


}
