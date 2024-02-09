package g313.bashmachenkov.lab04;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox[] chk = new CheckBox[4];
    EditText[] num = new EditText[4];
    EditText[] nums = new EditText[4];
    float[]   price = new float[4];
    RadioButton[] radio = new RadioButton[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Oncal(View v){
        try {
            chk[0] = findViewById(R.id.Apple_checkBox);
            chk[1] = findViewById(R.id.Strawberry_checkBox);
            chk[2] = findViewById(R.id.Blueberry_checkBox);
            chk[3] = findViewById(R.id.Potatoes_checkBox);


            num[0] = findViewById(R.id.Apple_text);
            num[1] = findViewById(R.id.Straw_text);
            num[2] = findViewById(R.id.Blue_text);
            num[3] = findViewById(R.id.POtato_text);


            nums[0] = findViewById(R.id.apple_price);
            nums[1] = findViewById(R.id.Straw_price);
            nums[2] = findViewById(R.id.Blue_price);
            nums[3] = findViewById(R.id.Potatoes_price);

            for (int i = 0; i<chk.length;i++){
                if(chk[i].isChecked()){
                    price[i] =Float.parseFloat(nums[i].getText().toString());
                }
            }

            radio[0] = findViewById(R.id.Window);
            radio[1] = findViewById(R.id.Toast);

            float sum = 0.0f;
            String rep = "";

            for (int i = 0; i < chk.length; i++) {
                if (chk[i].isChecked())
                {
                    if(Integer.parseInt(num[i].getText().toString()) >= 0 && price[i] >= 0)
                    {
                        sum += (Integer.parseInt(num[i].getText().toString())) * (Integer.parseInt(num[i].getText().toString()) * price[i]);
                        rep += String.format("%d: %d x %s = %d x %.2f = 0.2f\n",
                                i,Integer.parseInt(num[i].getText().toString()),chk[i].getText().toString(),
                                Integer.parseInt(num[i].getText().toString()),price[i],Integer.parseInt(num[i].getText().toString()) * price[i]);
                    }
                    else
                    {
                        Toast.makeText(this, "Неверные значения", Toast.LENGTH_SHORT).show();
                        sum = 0;
                        break;
                    }
                }
            }
            rep += String.format("total - %.0f", sum);

            if (sum != 0)
            {
                if(radio[0].isChecked()){
                    AlertDialog.Builder bld = new AlertDialog.Builder(this);
                    AlertDialog dlg = bld.create();
                    dlg.setIcon(R.drawable.logo1);
                    dlg.setTitle("Result");
                    dlg.setMessage(rep);
                    dlg.show();
                }
                else{
                    Toast.makeText(this, rep, Toast.LENGTH_SHORT).show();
                }
            }
        }
        catch (Exception exception) {
            Toast.makeText(this, exception.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}