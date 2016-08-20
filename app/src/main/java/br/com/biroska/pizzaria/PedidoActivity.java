package br.com.biroska.pizzaria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import br.com.biroska.pizzaria.constant.Constant;
import br.com.biroska.pizzaria.enums.PizzaEnum;

public class PedidoActivity extends AppCompatActivity {

    private TextView mensagemValor;
    private CheckBox checkBorda;
    private RadioGroup radioGroup;
    private RadioButton selectedRadio;
    private PizzaEnum pizza;
    private Double precoCobrado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        radioGroup = (RadioGroup) findViewById( R.id.radiosPizza );
        checkBorda = (CheckBox) findViewById( R.id.borda );

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

//        radioGroup = (RadioGroup) findViewById( R.id.radiosPizza );

        int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();

        selectedRadio = (RadioButton) findViewById( checkedRadioButtonId );

//        checkBorda = (CheckBox) findViewById( R.id.borda );

        pizza = PizzaEnum.getEnum(selectedRadio.getText().toString());

        precoCobrado = pizza.getPreco();

        if ( checkBorda.isChecked() ){
            precoCobrado += Constant.BORDA;
        }

        mensagemValor = (TextView) findViewById( R.id.valorPedido );
        mensagemValor.setText( getResources().getString( R.string.valorPedido ) + precoCobrado );
    }
}
