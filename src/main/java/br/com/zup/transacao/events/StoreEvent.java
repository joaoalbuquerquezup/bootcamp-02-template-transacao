package br.com.zup.transacao.events;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class StoreEvent {

    @JsonProperty(value = "nome")
    private String name;

    @JsonProperty(value = "cidade")
    private String city;

    @JsonProperty(value = "endereco")
    private String address;

}
