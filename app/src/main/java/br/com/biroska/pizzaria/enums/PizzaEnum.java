package br.com.biroska.pizzaria.enums;

import android.text.TextUtils;

/**
 * Created by Notebook on 18/08/2016.
 */
public enum PizzaEnum {

    CALABRESA(15.0),
    MUSSARELA(10.0),
    PORTUGUESA(20.0);

    private Double preco;

    PizzaEnum(Double preco) {
        this.preco = preco;
    }

    public Double getPreco() {
        return preco;
    }

    public static PizzaEnum getEnum( String enumName ){

        if (TextUtils.isEmpty( enumName )){
            return null;
        }

        for ( PizzaEnum item  :  PizzaEnum.values() ) {
            if ( item.name().equalsIgnoreCase( enumName ) ){
                return item;
            }
        }

        return null;
    }
}
