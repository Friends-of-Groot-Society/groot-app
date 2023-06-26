package com.friendsofgroot.app.repositories;

import com.friendsofgroot.app.dto.ChartData;
import com.friendsofgroot.app.dto.TimeChartData;
import com.friendsofgroot.app.models.Chain;
import com.friendsofgroot.app.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(collectionResourceRel="chain", path = "chain")
public interface ChainsRepository extends JpaRepository<Chain, Integer> {

    Page<Chain> findAll(Pageable pageable);


    List<Chain> findByCategory(String category);

    @Query(value = "SELECT * FROM CHAIN c WHERE c.NAME LIKE '%?1%' OR c.SYMBOL LIKE '%?1%'", nativeQuery = true)
    List<Chain> search(String keyword);


    @Query(nativeQuery=true, value="SELECT NAME as label, " +
            "COUNT(*) as value " +
            "FROM chain " +
            "GROUP BY NAME")
    public List<ChartData> getChainNames(); //ChartData is a custom class

    @Query(value = "SELECT category as label, " +
            "COUNT(*) as value " +
            "FROM chain " +
            "GROUP BY category", nativeQuery = true)
    public List<ChartData> getChainCategories(); //ChartData is a custom class`


//    @Query("SELECT name as chainName, start_date as startDate, end_date as endDate"
//            + " FROM chain WHERE start_date is not null")
//    public List<TimeChartData> getTimeData();

    List<Chain> findByName(String name);

}