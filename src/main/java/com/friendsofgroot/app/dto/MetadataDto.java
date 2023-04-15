package com.friendsofgroot.app.dto;

import com.friendsofgroot.app.dto.AttributeDto;
import com.friendsofgroot.app.dto.NftDto;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link Metadata} entity
 */
public record MetadataDto(String name, String description, String image, NftDto nft,
                          List<AttributeDto> attributes) implements Serializable {
}