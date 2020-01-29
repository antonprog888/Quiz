package spase.suchkov.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Level1 extends AppCompatActivity {
    Dialog dialog;
    private Object Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);
        //Создаем переменую text levels
        TextView text_levels = findViewById(R.id.text_levels);
        text_levels.setText(R.string.level1); //установили текст

        final ImageView img_left = findViewById(R.id.img_left);
        //Код который скругляет углы левой картинки
        img_left.setClipToOutline(true);
        final ImageView img_right = findViewById(R.id.img_right);
        //Код который скругляет углы правой картинки
        img_right.setClipToOutline(true);

        //Развернуть игру на весь экран начало
        Window w = getWindow();
        //  w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Развернуть игру на весь экран конец
        //Вызов диалогового окна в конце меню
        dialog = new Dialog(this);//создаем диалоговое окно
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); //Скрываем заголовок диалогового окна
        dialog.setContentView(R.layout.previewdialog); //Путь к макету диалогового окна
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //прозрачный фон диалогового окна
        dialog.setCancelable(false); //Окно нельзя закрыть кнопкой назад

        //Кнопка закрытия диалогового окна
        TextView btclose = (TextView)dialog.findViewById(R.id.btnclose);
        btclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Обрабатывание кнопки Закрытия начало
                try{
                    //Вернтьсся назад к выбору уровня начало
                    Intent intent = new Intent(Level1.this, GameLevels.class);
                    startActivity(intent); //Старт намериния
                    finish(); //Закрыть класс

                    //Вернтьсся назад к выбору уровня конец
                } catch (Exception e){
                }
                dialog.dismiss(); //Закрываем диалоговое окно
                //Обрабатывание кнопки Закрытия конец

            }
        });

        //Кнопка Продолжить начало

        Button btncontinue = dialog.findViewById(R.id.btncontinue);
        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    dialog.dismiss();
                }catch(Exception e){

                }
            }
        });

        //Кнопка Продолжить конец
        dialog.show(); //показать диалоговое окно


        Button button_back = findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Команда для кнопки назад
                //Начало конструкции
                try{
                    Intent intent = new Intent(Level1.this, GameLevels.class);//Создали намерение для перехода
                    startActivity(intent); //Старт намерения
                    finish(); //Закрыть этот класс
                } catch (Exception e){
                }
                //Конец конструкции
            }
        });

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
