package com.friendsofgroot.app.dataLoader;

import com.friendsofgroot.app.models.Chain;
import com.friendsofgroot.app.models.User;
import com.friendsofgroot.app.models.dto.ChainCSVRecord;
import com.friendsofgroot.app.models.dto.Symbol;
import com.friendsofgroot.app.repositories.ChainRepository;
import com.friendsofgroot.app.repositories.UserRepository;
import com.friendsofgroot.app.service.ChainCsvService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
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
    private final ChainRepository chainRepository;
    private final UserRepository userRepository;
    private final ChainCsvService chainCsvService;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        loadChainData();
        loadCsvData();
        loadUserData();
    }

    private void loadCsvData() throws FileNotFoundException {
        if (chainRepository.count() < 10){
            File file = ResourceUtils.getFile("classpath:csvdata/chains.csv");

            List<ChainCSVRecord> recs = chainCsvService.convertCSV(file);

            recs.forEach(chainCSVRecord -> {
                Symbol symbol = switch (chainCSVRecord.getSymbol()) {
                    case "American Pale Lager" -> Symbol.LAGER;
                    case "American Pale Ale (APA)", "American Black Ale", "Belgian Dark Ale", "American Blonde Ale" ->
                            Symbol.ALE;
                    case "American IPA", "American Double / Imperial IPA", "Belgian IPA" -> Symbol.IPA;
                    case "American Porter" -> Symbol.PORTER;
                    case "Oatmeal Stout", "American Stout" -> Symbol.STOUT;
                    case "Saison / Farmhouse Ale" -> Symbol.SAISON;
                    case "Fruit / Vegetable Chain", "Winter Warmer", "Berliner Weissbier" -> Symbol.WHEAT;
                    case "English Pale Ale" -> Symbol.PALE_ALE;
                    default -> Symbol.PILSNER;
                };

                chainRepository.save(Chain.builder()
                                .chainName(StringUtils.abbreviate(chainCSVRecord.getChain(), 50))
                                .symbol(symbol)
                                .price(BigDecimal.TEN)
                                .upc(chainCSVRecord.getRow().toString())
                                .quantityOnHand(chainCSVRecord.getCount())
                        .build());
            });
        }
    }

    private void loadChainData() {
        if (chainRepository.count() == 0){
            Chain chain1 = Chain.builder()
                    .chainName("Galaxy Cat")
                    .symbol(Symbol.PALE_ALE)
                    .upc("12356")
                    .price(new BigDecimal("12.99"))
                    .quantityOnHand(122)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            Chain chain2 = Chain.builder()
                    .chainName("Crank")
                    .symbol(Symbol.PALE_ALE)
                    .upc("12356222")
                    .price(new BigDecimal("11.99"))
                    .quantityOnHand(392)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            Chain chain3 = Chain.builder()
                    .chainName("Sunshine City")
                    .symbol(Symbol.IPA)
                    .upc("12356")
                    .price(new BigDecimal("13.99"))
                    .quantityOnHand(144)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            chainRepository.save(chain1);
            chainRepository.save(chain2);
            chainRepository.save(chain3);
        }

    }

    private void loadUserData() {

        if (userRepository.count() == 0) {
            User user1 = User.builder()
                    .id(UUID.randomUUID())
                    .name("User 1")
                    .version(1)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            User user2 = User.builder()
                    .id(UUID.randomUUID())
                    .name("User 2")
                    .version(1)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            User user3 = User.builder()
                    .id(UUID.randomUUID())
                    .name("User 3")
                    .version(1)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            userRepository.saveAll(Arrays.asList(user1, user2, user3));
        }

    }


}
