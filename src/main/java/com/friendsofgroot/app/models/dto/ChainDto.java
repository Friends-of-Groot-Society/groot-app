package com.friendsofgroot.app.models.dto;

import com.friendsofgroot.app.models.Chain;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * A Dto for the {@link Chain} entity
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChainDto implements Serializable {
    static long serialVersionUID = 1L;
    private UUID chainId;
    private Integer version;

    @NotBlank
    @NotNull
    private String name;
    @NotNull
    private Symbol symbol;
    private String description;
    private String longDescription;
    private String iconUrl;
    private String category;
    private String chainListIcon;
    private String rpcUrl;
    private Integer id;
    private String blockExplorerUrl;

    private LocalDateTime createdDate;
    private LocalDateTime updateDate;
}
