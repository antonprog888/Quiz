package spase.suchkov.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class Level1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        //Развернуть игру на весь экран начало
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        //Развернуть игру на весь экран конец
    }

    //Системная кнопка Назад начало
    @Override
    public void onBackPressed(){
        try{
            Intent intent = new Intent(Level1.this, GameLevels.class);
            startActivity(intent);
            finish();
        } catch (Exception e){
        }
    }
    //Системная кнопка Назад конец

}
