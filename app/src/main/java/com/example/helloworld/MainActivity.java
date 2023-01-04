package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

        private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*o R é de procura na pasta res, logo, procure o id editValor na pasta R, com o elemento EditText
        EditText valorDigitado = findViewById(R.id.editValor);
        valorDigitado.getText(); // pegando o valor digitado
         */

        this.mViewHolder.editValor = findViewById(R.id.editValor);
        this.mViewHolder.textDolar = findViewById(R.id.textDolar);
        this.mViewHolder.textEuro = findViewById(R.id.textEuro);
        this.mViewHolder.buttonCalculate = findViewById(R.id.buttonCalculate);
        this.mViewHolder.clearData = findViewById(R.id.clearData);

        this.mViewHolder.buttonCalculate.setOnClickListener(this);
        this.mViewHolder.clearData.setOnClickListener(this);

        this.clearValues();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonCalculate) {
            String value = this.mViewHolder.editValor.getText().toString(); //getText pega o valor digitado
                if ("".equals(value)){
                    //mostrando mensagem ao usuário
                    Toast.makeText(this, this.getString(R.string.informe_valor), Toast.LENGTH_LONG).show();
                    //Toast.LENGH_LONG mostra a mensagem por longo tempo, e show é para mostrar
                }
                else{
                    Double real = Double.valueOf(value);
                    this.mViewHolder.textDolar.setText(String.format("%.2f", (real/5.45)));
                    this.mViewHolder.textEuro.setText(String.format("%.2f", (real/5.78)));

                }
        }if(view.getId() == R.id.clearData){
            this.clearValues();
        }
    }
    private void clearValues(){
        this.mViewHolder.textDolar.setText("");
        this.mViewHolder.textEuro.setText("");
        this.mViewHolder.editValor.setText("");

    }


    private static class ViewHolder{
        EditText editValor;
        TextView textDolar;
        TextView textEuro;
        Button buttonCalculate;
        Button clearData;

    }
}