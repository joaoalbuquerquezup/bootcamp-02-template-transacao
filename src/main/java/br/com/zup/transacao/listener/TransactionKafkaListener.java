package br.com.zup.transacao.listener;

import br.com.zup.transacao.events.TransactionEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransactionKafkaListener {

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void listen(TransactionEvent transactionEvent) {
        System.out.println(transactionEvent);
    }
}
