package br.com.biroska.pizzaria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import br.com.biroska.pizzaria.constant.Constant;
import br.com.biroska.pizzaria.enums.PizzaEnum;
import br.com.biroska.pizzaria.model.FormaPagamento;
import br.com.biroska.pizzaria.service.FormaPagamentoBO;

public class PedidoActivity extends AppCompatActivity {

    private Spinner spinner;
    private TextView mensagemValor;
    private CheckBox checkBorda;
    private RadioGroup radioGroup;
    private RadioButton selectedRadio;

    private PizzaEnum pizza;
    private Double precoCobrado;
    private List<FormaPagamento> lista;
    private FormaPagamentoBO bo = new FormaPagamentoBO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        radioGroup = (RadioGroup) findViewById( R.id.radiosPizza );
        checkBorda = (CheckBox) findViewById( R.id.borda );
        spinner = (Spinner) findViewById( R.id.spinnerFormaPagamento );

        lista = bo.listaFormasPagamento();

        ArrayAdapter<FormaPagamento> adapter =
                new ArrayAdapter<FormaPagamento>(this, android.R.layout.simple_spinner_item, lista);
        spinner.setAdapter(adapter);


        radioGroup.setOnCheckedChangeListener( new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged( RadioGroup group, int checkedId ) {

                RadioButton radioPizza = ( RadioButton ) findViewById( checkedId );

                if ( PizzaEnum.MUSSARELA.name().equalsIgnoreCase( radioPizza.getText().toString() ) ){
                    checkBorda.setChecked( false );
                    checkBorda.setEnabled( false );
                } else {
                    checkBorda.setEnabled( true );
                }
            }
        });
    }

    public void calcular( View view ){

        FormaPagamento formaPagamento = null;

        int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();

        selectedRadio = (RadioButton) findViewById( checkedRadioButtonId );

        formaPagamento = (FormaPagamento) spinner.getSelectedItem();

        pizza = PizzaEnum.getEnum(selectedRadio.getText().toString());

        precoCobrado = pizza.getPreco();

        if ( checkBorda.isChecked() ){
            precoCobrado += Constant.BORDA;
        }

        mensagemValor = (TextView) findViewById( R.id.valorPedido );
        mensagemValor.setText( getResources().getString( R.string.valorPedido ) + precoCobrado );

        mensagemValor = (TextView) findViewById( R.id.formaPagamento );
        mensagemValor.setText( getResources().getString( R.string.formaPagamento ) + formaPagamento.getNome() );
    }
}
