package com.friendsofgroot.app.dataLoader;

import com.friendsofgroot.app.models.Chain;
import com.friendsofgroot.app.models.User;
import com.friendsofgroot.app.models.dto.ChainCSVRecord;
import com.friendsofgroot.app.models.dto.Symbol;
import com.friendsofgroot.app.repositories.ChainsRepository;
import com.friendsofgroot.app.repositories.UsersRepository;
import com.friendsofgroot.app.service.ChainCsvService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 *
 */
@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {
    @Autowired
    private   ChainsRepository chainRepository;
    @Autowired
    private   UsersRepository usersRepository;
    @Autowired
    private   ChainCsvService chainCsvService;

    public BootstrapData(ChainsRepository chainRepository, UsersRepository usersRepository, ChainCsvService chainCsvService) {
        this.chainRepository = chainRepository;
        this.usersRepository = usersRepository;
        this.chainCsvService = chainCsvService;
    }
//    @Transactional
    @Override
    public void run(String... args) throws Exception {
//        loadChainData();
//        loadCsvData();
//        loadUserData();
    }

    private void loadCsvData() throws FileNotFoundException {
        if (chainRepository.count() < 1) {
            File file = ResourceUtils.getFile("classpath:data/chains.csv");

            List<ChainCSVRecord> recs = chainCsvService.convertCSV(file);

            recs.forEach(chainCSVRecord -> {
                Symbol symbol = switch (chainCSVRecord.getSymbol().toString()) {
                    case "ETH", "Ethereum" -> Symbol.ETH;
                    case "BTC", "Wrapped Bitcoin", "Bitcoin" -> Symbol.BTC;
                    case "MATIC", "ChainLink", "Ethereum from Polygon", "Polygon" -> Symbol.MATIC;
                    case "PLS", "Pulsechain", "Hex from Pulsechain" -> Symbol.PLS;
                    case "SOL", "Solana Chain", "Solana" -> Symbol.SOL;
                    case "BNB", "Binance Chain" -> Symbol.BNB;
                    case "AVAX", "avalanche", "Avalanche Mainnet", "Avalanche" -> Symbol.AVAX;
                    case "XRP", "xrp", "Ripple" -> Symbol.XRP;
                    default -> Symbol.ETH;
                };

                chainRepository.save(Chain.builder()
                        .name(StringUtils.abbreviate(chainCSVRecord.getName(), 250))
                        .symbol(symbol)
                        .description(chainCSVRecord.getDescription())
                        .longDescription(chainCSVRecord.getLongDescription())
                        .iconUrl(chainCSVRecord.getIconUrl())
                        .category(chainCSVRecord.getCategory())
                        .chainListIcon(chainCSVRecord.getChainListIcon())
                        .rpcUrl(chainCSVRecord.getRpcUrl())
                        .id(chainCSVRecord.getId())
                        .blockExplorerUrl(chainCSVRecord.getBlockExplorerUrl())
                        .dateCreated(new Date(2021, 10, 10))
                        .createdDate(LocalDateTime.now())
                        .lastUpdated(LocalDateTime.now())
                        .updatedAt(new Timestamp(System.currentTimeMillis()))
                        .build());
            });
        }
    }

    private void loadChainData() {
        Chain chain = chainRepository.count() == 0 ? null : chainRepository.findAll().get(0);
        if (chain != null) {
            Chain pls = Chain.builder()
                    .name("Pulsechain")
                    .symbol(Symbol.PLS)
                    .chainListIcon("https://www.cryptocompare.com/media/37746251/eth.png")
                    .rpcUrl("https://www.cryptocompare.com/media/37746251/eth.png")
                    .blockExplorerUrl("https://www.cryptocompare.com/media/37746251/eth.png")
                    .category("Smart Contract")
                    .longDescription("Ethereum is a decentralized platform that runs smart contracts: applications that run exactly as programmed without any possibility of downtime, censorship, fraud or third-party interference.")
                    .description("Ethereum is a decentralized platform that runs smart contracts: applications that run exactly as programmed without any possibility of downtime, censorship, fraud or third-party interference.")
                    .iconUrl("https://www.cryptocompare.com/media/37746251/eth.png")
                    .dateCreated(Date.valueOf(LocalDate.now()))
                    .createdDate(LocalDateTime.now())
                    .lastUpdated(LocalDateTime.now())
                    .updatedAt(Timestamp.valueOf(LocalDateTime.now()))
                    .id(12356)
                    .build();

            Chain eth = Chain.builder()
                    .name("Ethereum")
                    .symbol(Symbol.ETH)
                    .chainListIcon("https://www.cryptocompare.com/media/37746251/eth.png")
                    .rpcUrl("https://www.cryptocompare.com/media/37746251/eth.png")
                    .blockExplorerUrl("https://www.cryptocompare.com/media/37746251/eth.png")
                    .category("Smart Contract")
                    .longDescription("Ethereum is a decentralized platform that runs smart contracts: applications that run exactly as programmed without any possibility of downtime, censorship, fraud or third-party interference.")
                    .description("Ethereum is a decentralized platform that runs smart contracts: applications that run exactly as programmed without any possibility of downtime, censorship, fraud or third-party interference.")
                    .iconUrl("https://www.cryptocompare.com/media/37746251/eth.png")
                    .dateCreated(Date.valueOf(LocalDate.now()))
                    .createdDate((LocalDateTime.now()))
                    .lastUpdated(LocalDateTime.now())
                    .updatedAt(Timestamp.valueOf(LocalDateTime.now()))
                    .id(12356)
                    .build();

            Chain sol = Chain.builder()
                    .name("Solana")
                    .symbol(Symbol.SOL)
                    .id(12356)
                    .chainListIcon("https://www.cryptocompare.com/media/37746251/eth.png")
                    .rpcUrl("https://www.cryptocompare.com/media/37746251/eth.png")
                    .blockExplorerUrl("https://www.cryptocompare.com/media/37746251/eth.png")
                    .category("Smart Contract")
                    .longDescription("Ethereum is a decentralized platform that runs smart contracts: applications that run exactly as programmed without any possibility of downtime, censorship, fraud or third-party interference.")
                    .description("Ethereum is a decentralized platform that runs smart contracts: applications that run exactly as programmed without any possibility of downtime, censorship, fraud or third-party interference.")
                    .iconUrl("https://www.cryptocompare.com/media/37746251/eth.png")
                    .dateCreated(Date.valueOf(LocalDate.now()))
                    .createdDate(LocalDateTime.now())
                    .lastUpdated(LocalDateTime.now())
                    .updatedAt(Timestamp.valueOf(LocalDateTime.now()))
                    .id(12356)
                    .build();

            Chain matic = Chain.builder()
                    .chainId(UUID.randomUUID())
                    .version(1)
                    .name("Polygon")
                    .symbol(Symbol.MATIC)
                    .chainListIcon("https://www.cryptocompare.com/media/37746251/eth.png")
                    .rpcUrl("https://www.cryptocompare.com/media/37746251/eth.png")
                    .blockExplorerUrl("https://www.cryptocompare.com/media/37746251/eth.png")
                    .category("Smart Contract")
                    .longDescription("Ethereum is a decentralized platform that runs smart contracts: applications that run exactly as programmed without any possibility of downtime, censorship, fraud or third-party interference.")
                    .description("Ethereum is a decentralized platform that runs smart contracts: applications that run exactly as programmed without any possibility of downtime, censorship, fraud or third-party interference.")
                    .iconUrl("https://www.cryptocompare.com/media/37746251/eth.png")
                    .dateCreated(Date.valueOf(LocalDate.now()))
                    .createdDate(LocalDateTime.now())
                    .lastUpdated(LocalDateTime.now())
                    .updatedAt(Timestamp.valueOf(LocalDateTime.now()))
                    .id(12356)
                    .build();

            Chain btc = Chain.builder()
                    .chainId(UUID.randomUUID())
                    .version(1)
                    .name("Bitcoin")
                    .symbol(Symbol.BTC)
                    .chainListIcon("https://www.cryptocompare.com/media/37746251/eth.png")
                    .rpcUrl("https://www.cryptocompare.com/media/37746251/eth.png")
                    .blockExplorerUrl("https://www.cryptocompare.com/media/37746251/eth.png")
                    .category("Smart Contract")
                    .longDescription("Ethereum is a decentralized platform that runs smart contracts: applications that run exactly as programmed without any possibility of downtime, censorship, fraud or third-party interference.")
                    .description("Ethereum is a decentralized platform that runs smart contracts: applications that run exactly as programmed without any possibility of downtime, censorship, fraud or third-party interference.")
                    .iconUrl("https://www.cryptocompare.com/media/37746251/eth.png")
                    .dateCreated(Date.valueOf(LocalDate.now()))
                    .createdDate(LocalDateTime.now())
                    .lastUpdated(LocalDateTime.now())
                    .updatedAt(Timestamp.valueOf(LocalDateTime.now()))
                    .id(12356)
                    .build();


            chainRepository.save(pls);
            chainRepository.save(eth);
            chainRepository.save(sol);
            chainRepository.save(matic);
            chainRepository.save(btc);
        }

    }

    private void loadUserData() {

        if (usersRepository.count() == 0) {
            User user1 = User.builder()
                    .userId((int) Math.floor(Math.random() * 100))
                    .username("thomasm1.maestas@gmail.com")
                    .email("thomasm1.maestas@gmail.com")
                    .build();

            User user2 = User.builder()
                    .userId((int) Math.floor(Math.random() * 100))
                    .username("thomasm2.maestas@gmail.com")
                    .email("thomasm2.maestas@gmail.com")
                    .build();

            User user3 = User.builder()
                    .userId((int) Math.floor(Math.random() * 100))
                    .username("thomasm3.maestas@gmail.com")
                    .email("thomasm3.maestas@gmail.com")
                    .build();

            usersRepository.save(user1);
            usersRepository.save(user2);
            usersRepository.save(user3);
            usersRepository.saveAll(Arrays.asList(user1, user2, user3));
        }

    }


}
