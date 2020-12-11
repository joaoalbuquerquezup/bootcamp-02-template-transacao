package br.com.zup.transacao.listener;

import br.com.zup.transacao.events.TransactionEvent;
import br.com.zup.transacao.model.Card;
import br.com.zup.transacao.model.Transaction;
import br.com.zup.transacao.repository.CardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.function.Function;

@Component
public class TransactionKafkaListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionKafkaListener.class);

    private final CardRepository cardRepository;
    private final EntityManager entityManager;

    public TransactionKafkaListener(CardRepository cardRepository,
                                    EntityManager entityManager) {
        this.cardRepository = cardRepository;
        this.entityManager = entityManager;
    }

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    @Transactional
    public void listen(TransactionEvent transactionEvent) {

        Function<String, Optional<Card>> cardLoader = this.cardRepository::findByReferenceId;
        Transaction transaction = transactionEvent.toModel(cardLoader);
        this.entityManager.persist(transaction);

        LOGGER.info("Transação salva: {}", transaction);
    }
}
