package br.com.smartbot.testesmartbot.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "coin_five_min")
public class CoinFiveMinEntity {

    @Id
    private Integer id;
    private String timeInterval = "5 Minutes";
    private LocalDateTime dateTimeCoin;
    private Float openValue;
    private Float lowValue;
    private Float highValue;
    private Float closeValue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(String timeInterval) {
        this.timeInterval = timeInterval;
    }

    public LocalDateTime getDateTimeCoin() {
        return dateTimeCoin;
    }

    public void setDateTimeCoin(LocalDateTime dateTimeCoin) {
        this.dateTimeCoin = dateTimeCoin;
    }

    public Float getOpenValue() {
        return openValue;
    }

    public void setOpenValue(Float openValue) {
        this.openValue = openValue;
    }

    public Float getLowValue() {
        return lowValue;
    }

    public void setLowValue(Float lowValue) {
        this.lowValue = lowValue;
    }

    public Float getHighValue() {
        return highValue;
    }

    public void setHighValue(Float highValue) {
        this.highValue = highValue;
    }

    public Float getCloseValue() {
        return closeValue;
    }

    public void setCloseValue(Float closeValue) {
        this.closeValue = closeValue;
    }
}
