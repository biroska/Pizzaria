package br.com.biroska.pizzaria.service;

import java.util.ArrayList;
import java.util.List;

import br.com.biroska.pizzaria.model.FormaPagamento;

/**
 * Created by Notebook on 20/08/2016.
 */
public class FormaPagamentoBO {

    public List<FormaPagamento> listaFormasPagamento(){

        List<FormaPagamento> lista = new ArrayList<FormaPagamento>();

        lista.add( new FormaPagamento( 1L, "Cartao de Credito" ) );
        lista.add( new FormaPagamento( 2L, "Cartao de Debito" ) );
        lista.add( new FormaPagamento( 3L, "Dinheiro" ) );
        lista.add( new FormaPagamento( 4L, "Vale Refeicao" ) );

        return lista;
    }
}
