package com.friendsofgroot.app.dto;

import com.friendsofgroot.app.models.Metadata;

import java.io.Serializable;

/**
 * A DTO for the {@link Attribute} entity
 */
public record AttributeDto(int attrid, String valu, String trait_type, MetadataDto metadata) implements Serializable {
}