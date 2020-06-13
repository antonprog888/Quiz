package spase.suchkov.quiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class  GameLevels extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelevels);

        //Сохранение начало
        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
        final int level = save.getInt("Level", 1);
        //Сохранение конец

        //Спрятать строку состояния
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        //Кнопка к переходу выбора уровня
        Button button_back = (Button) findViewById(R.id.button_back);

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Команда для кнопки назад
                //Начало конструкции
                try{
                    Intent intent = new Intent(GameLevels.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e){
                }
                //Конец конструкции
            }
        });

        //Кнопка для перехода на первый уровень начало
        TextView textView1 = findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if (level>=1) {
                        Intent intent = new Intent(GameLevels.this, Level1.class);
                        startActivity(intent);
                        finish();
                    } else {
                        //пусто
                    }
                }catch(Exception e){
                }
            }
        });

        //Кнопка для перехода на первый уровень конец

        //Кнопка для перехода на второй уровень начало
        TextView textView2 = findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if (level>=2) {
                        Intent intent = new Intent(GameLevels.this, Level2.class);
                        startActivity(intent);
                        finish();
                    } else {
                        //пусто
                    }
                }catch(Exception e){
                }
            }
        });
        //Кнопка для перехода на второй уровень конец

        //Кнопка для перехода на третий уровень начало
        TextView textView3 = findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if (level>=3) {
                        Intent intent = new Intent(GameLevels.this, Level3.class);
                        startActivity(intent);
                        finish();
                    } else {
                        //пусто
                    }
                }catch(Exception e){
                }
            }
        });
        //Кнопка для перехода на третий уровень конец

        //Кнопка для перехода на четвертый уровень начало
        TextView textView4 = findViewById(R.id.textView4);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if (level>=4) {
                        Intent intent = new Intent(GameLevels.this, Level4.class);
                        startActivity(intent);
                        finish();
                    } else {
                    //пусто
                    }
            }catch(Exception e){
                }
            }
        });
        //Кнопка для перехода на четвертый уровень конец


        //Кнопка для перехода на пятый уровень начало
        TextView textView5 = findViewById(R.id.textView5);
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if (level>=5) {
                        Intent intent = new Intent(GameLevels.this, Level5.class);
                        startActivity(intent);
                        finish();
                    } else {
                        //пусто
                    }
                }catch(Exception e){
                }
            }
        });
        //Кнопка для перехода на пятый уровень конец

        final int [] x={
                R.id.textView1,
                R.id.textView2,
                R.id.textView3,
                R.id.textView4,
                R.id.textView5,
                R.id.textView6,
                R.id.textView7,
                R.id.textView8,
                R.id.textView9,
                R.id.textView10,
                R.id.textView11,
                R.id.textView12,
                R.id.textView13,
                R.id.textView14,
                R.id.textView15,
                R.id.textView16,
                R.id.textView17,
                R.id.textView18,
                R.id.textView19,
                R.id.textView20,
                R.id.textView21,
                R.id.textView22,
                R.id.textView23,
                R.id.textView24,
                R.id.textView25,
                R.id.textView26,
                R.id.textView27,
                R.id.textView28,
                R.id.textView29,
                R.id.textView30
        };
      //  Drawable d1 = getResources().getDrawable(R.drawable.style_btn_black95);
      //  Drawable d2 = getResources().getDrawable(R.drawable.style_btn_black60);
        for(int i=0; i<30; i++){
            TextView tv = findViewById(x[i]);
            if (i<level) {
                tv.setText(""+(i+1));
               // tv.setBackground(getResources().getDrawable(R.drawable.style_btn_black95));
            }else
            {
              //  tv.setBackground(getResources().getDrawable(R.drawable.style_btn_black60));
            }
        }
    }





    //Системная кнопка Назад начало
    @Override
    public void onBackPressed(){
        try{
            Intent intent = new Intent(GameLevels.this, MainActivity.class);
            startActivity(intent);
            finish();
        } catch (Exception e){
        }
    }
    //Системная кнопка Назад конец


}
