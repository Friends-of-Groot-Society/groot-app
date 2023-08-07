package com.friendsofgroot.app.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 *
 */
@Data
@Entity
@AttributeOverrides({
        @AttributeOverride(
                name = "walletAddress.address",
                column = @Column(name = "wallet_address")
        ),
        @AttributeOverride(
                name = "walletAddress.chain",
                column = @Column(name = "wallet_chain")
        ),
        @AttributeOverride(
                name = "walletAddress.iconUrl",
                column = @Column(name = "wallet_icon_url")
        ),
        @AttributeOverride(
                name = "walletAddress.blockExplorerUrl",
                column = @Column(name = "wallet_block_explorer_url")
        ),

        @AttributeOverride(
                name = "nftContractAddress.address",
                column = @Column(name = "nft_contract_address")
        ),
        @AttributeOverride(
                name = "nftContractAddress.chain",
                column = @Column(name = "nft_contract_chain")
        ),
        @AttributeOverride(
                name = "nftContractAddress.iconUrl",
                column = @Column(name = "nft_contract_icon_url")
        ),
        @AttributeOverride(
                name = "nftContractAddress.blockExplorerUrl",
                column = @Column(name = "nft_contract_block_explorer_url")
        )
})
public class ChainOrderHeader extends BaseModel {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false )
    private UUID id;

    @ManyToOne
    private User user;

    @Embedded
    private ErcAddress nftContractAddress;   // ERC-721

    @Embedded
    private ErcAddress walletAddress;  // ERC-20

    @Enumerated(EnumType.STRING)
    private ChainOrderStatus chainOrderStatus;

    @OneToMany(mappedBy = "chainOrderHeader", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<ChainOrderLine>  chainOrderLines;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "chainOrderHeader")
    private ChainOrderWallet chainOrderWallet;

    public ChainOrderWallet getOrderApproval() {
        return chainOrderWallet;
    }

    public void setOrderApproval(ChainOrderWallet chainOrderWallet) {
        this.chainOrderWallet = chainOrderWallet;
        chainOrderWallet.setChainOrderHeader(this);
    }

    public void addOrderLine(ChainOrderLine chainOrderLine) {
        if (chainOrderLines == null) {
            chainOrderLines = new HashSet<>();
        }

        chainOrderLines.add(chainOrderLine);
        chainOrderLine.setChainOrderHeader(this);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ErcAddress getWalletAddress() {
        return walletAddress;
    }

    public void setWalletAddress(ErcAddress walletAddress) {
        this.walletAddress = walletAddress;
    }

    public ErcAddress getNftContractAddress() {
        return nftContractAddress;
    }

    public void setNftContractAddress(ErcAddress nftContractAddress) {
        this.nftContractAddress = nftContractAddress;
    }

    public ChainOrderStatus getOrderStatus() {
        return chainOrderStatus;
    }

    public void setOrderStatus(ChainOrderStatus chainOrderStatus) {
        this.chainOrderStatus = chainOrderStatus;
    }

    public Set<ChainOrderLine> getOrderLines() {
        return chainOrderLines;
    }

    public void setOrderLines(Set<ChainOrderLine> chainOrderLines) {
        this.chainOrderLines = chainOrderLines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChainOrderHeader)) return false;
        if (!super.equals(o)) return false;

        ChainOrderHeader that = (ChainOrderHeader) o;

        if (getUser() != null ? !getUser().equals(that.getUser()) : that.getUser() != null)
            return false;
        if (getWalletAddress() != null ? !getWalletAddress().equals(that.getWalletAddress()) : that.getWalletAddress() != null)
            return false;
        if (getNftContractAddress() != null ? !getNftContractAddress().equals(that.getNftContractAddress()) : that.getNftContractAddress() != null)
            return false;
        if (getOrderStatus() != that.getOrderStatus()) return false;
        return getOrderLines() != null ? getOrderLines().equals(that.getOrderLines()) : that.getOrderLines() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getUser() != null ? getUser().hashCode() : 0);
        result = 31 * result + (getWalletAddress() != null ? getWalletAddress().hashCode() : 0);
        result = 31 * result + (getNftContractAddress() != null ? getNftContractAddress().hashCode() : 0);
        result = 31 * result + (getOrderStatus() != null ? getOrderStatus().hashCode() : 0);
        result = 31 * result + (getOrderLines() != null ? getOrderLines().hashCode() : 0);
        return result;
    }

}
