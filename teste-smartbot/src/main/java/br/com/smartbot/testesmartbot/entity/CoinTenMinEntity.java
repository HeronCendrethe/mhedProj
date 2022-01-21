package br.com.smartbot.testesmartbot.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "coin_ten_min")
public class CoinTenMinEntity {

    @Id
    private Integer id;
    private String timeInterval = "10";
    private LocalDateTime dateTimeCoin;
    private BigDecimal openValue;
    private BigDecimal lowValue;
    private BigDecimal highValue;
    private BigDecimal closeValue;

    public CoinTenMinEntity() {
    }
}
