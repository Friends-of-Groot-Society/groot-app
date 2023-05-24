package app.mapl.models;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;


import jakarta.persistence.*;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "NFT_REF")
public class NftRef extends BaseModel   {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    private String name;
    private String owner;
    private Integer email_id;
    private Integer address_id;
    private Integer chain_id;

    private Integer nft_id;

}