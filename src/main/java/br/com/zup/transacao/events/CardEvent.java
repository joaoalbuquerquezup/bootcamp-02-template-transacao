package br.com.zup.transacao.events;

import br.com.zup.transacao.model.Card;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CardEvent {

    private String id;
    private String email;

    public Card toModel() {
        return new Card(id, email);
    }
}
