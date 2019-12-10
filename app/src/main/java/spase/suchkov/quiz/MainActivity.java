package spase.suchkov.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private long backPressedTime;

    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Спрятать строку состояния
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button buttonStart = (Button) findViewById(R.id.buttonStart);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            try{
                Intent intent = new Intent(MainActivity.this, GameLevels.class);
                startActivity(intent);
                finish();
            } catch (Exception e){

            }
            }
        });

    }

//Системная кнопка назад начало
// Ctrl+O

    @Override
    public void onBackPressed() {
        if (backPressedTime+2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        }else{
            backToast = Toast.makeText(getBaseContext(),"Нажмите еще раз чтобы выйти",Toast.LENGTH_SHORT) ;
            backToast.show();

        }

        backPressedTime = System.currentTimeMillis();
    }

//Системная кнопка назад конец
}
