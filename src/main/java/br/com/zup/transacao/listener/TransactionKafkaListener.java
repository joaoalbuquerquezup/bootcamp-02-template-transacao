package br.com.zup.transacao.listener;

import br.com.zup.transacao.events.TransactionEvent;
import br.com.zup.transacao.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManager;

@Component
public class TransactionKafkaListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionKafkaListener.class);

    private final EntityManager entityManager;
    private final TransactionTemplate txTemplate;

    public TransactionKafkaListener(EntityManager entityManager,
                                    TransactionTemplate txTemplate) {
        this.entityManager = entityManager;
        this.txTemplate = txTemplate;
    }

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void listen(TransactionEvent transactionEvent) {
        Transaction transaction = transactionEvent.toModel();

        txTemplate.execute(txStatus -> {
            this.entityManager.persist(transaction);
            return txStatus;
        });

        LOGGER.info("Transação salva: {}", transaction.toString());
    }
}
