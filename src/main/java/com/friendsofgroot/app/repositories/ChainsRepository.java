package com.friendsofgroot.app.repositories;

import com.friendsofgroot.app.models.dto.Symbol;
import com.friendsofgroot.app.models.dto.ChartData;
import com.friendsofgroot.app.models.Chain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource(collectionResourceRel="chain", path = "chain")
public interface ChainsRepository extends JpaRepository<Chain, UUID> {

    Page<Chain> findAll(Pageable pageable);


    List<Chain> findByCategory(String category);

    @Query(value = "SELECT * FROM CHAIN c WHERE c.NAME LIKE '%?1%' OR c.SYMBOL LIKE '%?1%'", nativeQuery = true)
    List<Chain> search(String keyword);

    // SQL Query
    @Query(nativeQuery=true, value="SELECT NAME as label, " +
            "COUNT(*) as value " +
            "FROM chain " +
            "GROUP BY NAME")
    public List<ChartData> getNames(); //ChartData is a custom class

    // SQL Query
    @Query(value = "SELECT category as label, " +
            "COUNT(*) as value " +
            "FROM chain " +
            "GROUP BY category", nativeQuery = true)
    public List<ChartData> getChainCategories(); //ChartData is a custom class`


//    @Query("SELECT name as chainName, start_date as startDate, end_date as endDate"
//            + " FROM chain WHERE start_date is not null")
//    public List<TimeChartData> getTimeData();

    List<Chain> findByName(String name);

    Page<Chain> findAllByChainNameIsLikeIgnoreCase(String chainName, Pageable pageable);

    Page<Chain> findAllBySymbol(Symbol symbol, Pageable pageable);

    Page<Chain> findAllByChainNameIsLikeIgnoreCaseAndSymbol(String chainName, Symbol symbol, Pageable pageable);


    Chain findChainByChainId(UUID chainId);
}
