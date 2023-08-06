package com.friendsofgroot.app.service;

import com.opencsv.bean.CsvToBeanBuilder;
import com.friendsofgroot.app.models.dto.ChainCSVRecord;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

/**
*
 */
@Service
public class ChainCsvServiceImpl implements ChainCsvService {
    @Override
    public List<ChainCSVRecord> convertCSV(File csvFile) {

        try {
            List<ChainCSVRecord> chainCSVRecords = new CsvToBeanBuilder<ChainCSVRecord>(new FileReader(csvFile))
                    .withType(ChainCSVRecord.class)
                    .build().parse();
            return chainCSVRecords;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}