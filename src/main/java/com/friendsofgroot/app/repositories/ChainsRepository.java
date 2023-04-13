package com.friendsofgroot.app.repositories;

import com.friendsofgroot.app.dto.ChartData;
import com.friendsofgroot.app.dto.TimeChartData;
import com.friendsofgroot.app.models.Chain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChainsRepository extends JpaRepository<Chain, Integer> {


    List<Chain> findByCategory(String category);

    @Query(nativeQuery=true, value="SELECT name as label, " +
            "COUNT(*) as value " +
            "FROM chain " +
            "GROUP BY name")
    public List<ChartData> getChainStatus();

    @Query(nativeQuery=true, value="SELECT name as chainName, start_date as startDate, end_date as endDate"
            + " FROM chain WHERE start_date is not null")
    public List<TimeChartData> getTimeData();

    List<Chain> findByName(String name);

}