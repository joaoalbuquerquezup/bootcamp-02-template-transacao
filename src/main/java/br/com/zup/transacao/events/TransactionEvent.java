package br.com.zup.transacao.events;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionEvent {

    private String id;

    @JsonProperty("valor")
    private BigDecimal value;

    @JsonProperty("estabelecimento")
    private StoreEvent storeEvent;

    @JsonProperty("cartao")
    private CardEvent cardEvent;

    @JsonProperty("efetivadaEm")
    private LocalDateTime madeAt;
}
