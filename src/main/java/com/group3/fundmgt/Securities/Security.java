package com.group3.fundmgt.Securities;

import javax.persistence.*;

@Entity
@Table
public class Security {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer securityId;

    @Column(nullable = false)
    private String symbol;

    public Security(Integer securityId, String symbol) {
        this.securityId = securityId;
        this.symbol = symbol;
    }

    public Security(String symbol) {
        this.symbol = symbol;
    }

    public Security() {

    }

    public Integer getSecurityId() {
        return securityId;
    }

    public void setSecurityId(Integer securityId) {
        this.securityId = securityId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "Security{" +
                "securityId=" + securityId +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}
