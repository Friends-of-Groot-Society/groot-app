package com.friendsofgroot.app.models.dto;

import com.opencsv.bean.CsvBindByName;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

/**
*
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChainCSVRecord  implements Serializable {

    static long serialVersionUID = 1L;

    @CsvBindByName(column = "chain_id")
    private UUID chainId;

    @CsvBindByName(column = "count.x")
    private Integer version;

    @CsvBindByName
    private String name;

    @CsvBindByName
    private  Symbol symbol;

    @CsvBindByName
    private String description;

    @CsvBindByName
    private String longDescription;

    @CsvBindByName
    private String iconUrl;

    @CsvBindByName(column = "chain_list_icon")
    private String chainListIcon;

    @CsvBindByName(column = "rpc_url")
    private String rpcUrl;

    @CsvBindByName
    private Integer id;

    @CsvBindByName(column = "block_explorer_url")
    private String blockExplorerUrl;


    @CsvBindByName
    private Float price;

    @CsvBindByName(column = "count.y")
    private String count_y;

    @CsvBindByName
    private String category;


}
