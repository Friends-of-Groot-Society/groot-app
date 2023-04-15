package com.friendsofgroot.app.repositories;

import com.friendsofgroot.app.dto.ChartData;
import com.friendsofgroot.app.dto.TimeChartData;
import com.friendsofgroot.app.models.Chain;
import com.friendsofgroot.app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ChainsRepository extends JpaRepository<Chain, Integer> {


    List<Chain> findByCategory(String category);

    @Query(value = "SELECT * FROM CHAIN c WHERE c.NAME LIKE '%?1%' OR c.SYMBOL LIKE '%?1%'", nativeQuery = true)
    List<Chain> search(String keyword);


    @Query(nativeQuery=true, value="SELECT NAME as label, " +
            "COUNT(*) as value " +
            "FROM chain " +
            "GROUP BY NAME")
    public List<ChartData> getChainNames(); //ChartData is a custom class

    @Query(nativeQuery=true, value="SELECT category as label, " +
            "COUNT(*) as value " +
            "FROM chain " +
            "GROUP BY category")
    public List<ChartData> getChainCategories(); //ChartData is a custom class`


    @Query(nativeQuery=true, value="SELECT name as chainName, start_date as startDate, end_date as endDate"
            + " FROM chain WHERE start_date is not null")
    public List<TimeChartData> getTimeData();

    List<Chain> findByName(String name);

}