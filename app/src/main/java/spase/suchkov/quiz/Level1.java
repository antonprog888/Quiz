package spase.suchkov.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.slice.SliceItem;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Level1 extends AppCompatActivity {
    Dialog dialog;

    public int numLeft; //переменая для левой картики + текст
    public int numRight; //переменая для правой картинки + текст
    Array array = new Array(); //Создали новый объект из класса Array
    Random random = new Random(); //Для генерации случайных чисел
    public int count = 0; //Счетчик правильных ответов

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

        //Путь к левой TextView
        final TextView textLeft = findViewById(R.id.text_left);
        //Путь к правой TextView
        final TextView textRight = findViewById(R.id.text_right);



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

        //Подключаем анимацию начало
        final Animation a = AnimationUtils.loadAnimation(Level1.this,R.anim.alpha);

        //Подключаем анимацию конец
        numLeft = random.nextInt(10); //Генерируем случайное число от 0 до 9
        img_left.setImageResource(array.images1[numLeft]);  //Достаем из масива картинку
        textLeft.setText(array.texts1[numLeft]); //Достаем из масива текст

        numRight = random.nextInt(10); //Генерируем случайное число от 0 до 9
        //Цикл с предусловием проверяющий равенство чисел начало
        while (numLeft==numRight){
            numRight = random.nextInt(10);
        }
        //Цикл с предусловием проверяющий равенство чисел конец

        img_right.setImageResource(array.images1[numRight]); //Достаем из масива картинку
        textRight.setText(array.texts1[numRight]); //Достаем из масива текст

        //Обрабатываем нажатие на левую картинку начало
        img_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                //Усовие касания картинк начало

                if (event.getAction()==MotionEvent.ACTION_DOWN) {
                    //Если коснулся картинки начало
                  img_right.setEnabled(false);
                  if (numLeft>numRight) {
                      img_left.setImageResource(R.drawable.img_true);
                  } else {
                      img_left.setImageResource(R.drawable.img_false);
                  }

                } else if  (event.getAction()==MotionEvent.ACTION_UP){
                    //Если отпустили палец начало

                }
                //Усовие касания картинк конец
                return true;
            }
        });
        //Обрабатываем нажатие на левую картинку конец

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
