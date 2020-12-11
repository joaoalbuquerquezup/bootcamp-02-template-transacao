package br.com.zup.transacao.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, unique = true, nullable = false)
    private UUID id;

    private BigDecimal value;

    @NotNull
    @OneToOne(optional = false, cascade = CascadeType.PERSIST)
    private Store storeEvent;

    @NotNull
    @OneToOne(optional = false, cascade = CascadeType.PERSIST)
    private Card cardEvent;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime madeAt;

    @NotBlank
    @Column(nullable = false)
    private String referenceId;

    /**
     * Hibernate usage only
     */
    @Deprecated
    protected Transaction() { }

    public Transaction(BigDecimal value,
                       @NotNull Store storeEvent,
                       @NotNull Card cardEvent,
                       @NotNull LocalDateTime madeAt,
                       @NotBlank String referenceId) {
        this.value = value;
        this.storeEvent = storeEvent;
        this.cardEvent = cardEvent;
        this.madeAt = madeAt;
        this.referenceId = referenceId;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "value=" + value +
                ", referenceId='" + referenceId + '\'' +
                '}';
    }
}
