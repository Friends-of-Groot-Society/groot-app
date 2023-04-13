package com.friendsofgroot.app.exception;

import lombok.*;

import java.io.Serializable;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ErrorDetailsDto implements Serializable {
    static long serialVersionUID = 1L;
    private Date timestamp;
    private String message;
    private String details;


}