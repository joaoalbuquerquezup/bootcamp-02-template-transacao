package br.com.zup.transacao.events;

import br.com.zup.transacao.model.Card;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Optional;
import java.util.function.Function;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CardEvent {

    private String id;
    private String email;

    public Card toModel(Function<String, Optional<Card>> cardLoader) {
        Optional<Card> optionalCard = cardLoader.apply(this.id);
        return optionalCard.orElse(new Card(id, email));
    }

}
