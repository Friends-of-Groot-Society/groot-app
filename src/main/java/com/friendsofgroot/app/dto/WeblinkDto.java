package com.friendsofgroot.app.dto;

import com.friendsofgroot.app.models.User;
import lombok.*;

import java.io.Serializable;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WeblinkDto implements Serializable {
    private static long serialVersionUID = 1L;
    private long id;

    private String title;
    private String profileUrl;
    private String ownerEmail;
    private String url;
    private String host;
    private String htmlPage;

    private String downloadStatus;
    private String web3Link;
}
