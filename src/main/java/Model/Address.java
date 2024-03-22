package Model;

import lombok.Data;

@Data
public class Address {
    private String nome, cep, logradouro, complemento, bairro, localidade, uf, ibge, gia, ddd, siafi;
}
