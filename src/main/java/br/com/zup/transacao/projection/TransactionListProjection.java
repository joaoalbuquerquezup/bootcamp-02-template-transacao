package br.com.zup.transacao.projection;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface TransactionListProjection {

    BigDecimal getValue();

    LocalDateTime getMadeAt();

    CardListProjection getCard();

    StoreListProjection getStore();

}
