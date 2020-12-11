package br.com.zup.transacao.events;

import br.com.zup.transacao.model.Card;
import br.com.zup.transacao.model.Store;
import br.com.zup.transacao.model.Transaction;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.function.Function;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
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

    public Transaction toModel(Function<String, Optional<Card>> cardLoader) {
        Store store = storeEvent.toModel();
        Card card = cardEvent.toModel(cardLoader);

        return new Transaction(value, store, card, madeAt, id);
    }
}
