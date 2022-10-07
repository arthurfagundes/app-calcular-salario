package br.ulbra.appcalculasalario;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class SalarioActivity extends AppCompatActivity {
    EditText edtsalario;
    RadioGroup radiogroup1;
    Button btcalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtsalario = findViewById(R.id.edtsalario);
        radiogroup1 = findViewById(R.id.radiogroup1);
        btcalc = findViewById(R.id.btcalc);

        btcalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double salario = Double.parseDouble(edtsalario.getText().toString());
                int op = radiogroup1.getCheckedRadioButtonId();
                double novo_salario = 0;

                if (op == R.id.rdbt30)
                    novo_salario = salario + (salario * 0.3);
                else if (op == R.id.rdbt45)
                    novo_salario = salario + (salario * 0.45);
                else if (op == R.id.rdbt50)
                    novo_salario = salario + (salario * 0.5);
                else
                    novo_salario = salario + (salario * 0.75);

                AlertDialog.Builder dialogo = new AlertDialog.Builder(SalarioActivity.this);
                dialogo.setTitle("Novo salário");
                dialogo.setMessage("Seu novo salário é: R$" + String.valueOf(novo_salario));
                dialogo.setNeutralButton("OK", null);
                dialogo.show();
            }
        });
    }
}