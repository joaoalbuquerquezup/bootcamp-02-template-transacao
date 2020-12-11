package br.com.zup.transacao.repository;

import br.com.zup.transacao.model.Transaction;
import br.com.zup.transacao.projection.TransactionListProjection;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TransactionRepository extends PagingAndSortingRepository<Transaction, UUID> {

    List<TransactionListProjection> findAllProjectedByCard_ReferenceId(String cardId, Pageable pageable);
}
