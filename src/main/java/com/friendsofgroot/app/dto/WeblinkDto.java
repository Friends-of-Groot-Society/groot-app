package com.friendsofgroot.app.dto;

import lombok.Data;

import java.io.Serializable;


@Data
public class WeblinkDto implements Serializable {
    private static long serialVersionUID = 1L;
    private final long id;
    private final String url;
    private final String host;
    private final String htmlPage;
}
