package br.com.zup.transacao.events;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StoreEvent {

    @JsonProperty(value = "nome")
    private String name;

    @JsonProperty(value = "cidade")
    private String city;

    @JsonProperty(value = "endereco")
    private String address;

}
