package br.com.zup.transacao.controller;

import br.com.zup.transacao.projection.TransactionListProjection;
import br.com.zup.transacao.repository.TransactionRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("card")
public class ListTransactionsController {

    private final TransactionRepository transactionRepository;

    public ListTransactionsController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @GetMapping("/{cardId}/transaction")
    public ResponseEntity<List<TransactionListProjection>> list (@PathVariable String cardId) {

        Sort sort = Sort.by(Sort.Direction.DESC, "madeAt");
        PageRequest page = PageRequest.of(0, 10, sort);

        // Atention: This projection based on Spring Data JPA Interfaces always brings the ids of the relationships
        var transactionProjectedList = transactionRepository.findAllProjectedByCard_ReferenceId(cardId, page);

        return ResponseEntity.ok(transactionProjectedList);
    }
}
