package spase.suchkov.quiz;

import android.app.Dialog;
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

import androidx.appcompat.app.AppCompatActivity;

public class Level2 extends AppCompatActivity {
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

        //Утанавливаем картинку в диалоговое окно - Начало
        ImageView previewimg =  dialog.findViewById(R.id.previewimg); //previewimg
        previewimg.setImageResource(R.drawable.previewimgtwo);
        //Утанавливаем картинку в диалоговое окно - Конец

        //Устанавливаем описание задания начало
        TextView textdescription = dialog.findViewById(R.id.textdescription);
        textdescription.setText(R.string.leveltwo);
        //Устанавливаем описание задания конец


        //Кнопка закрытия диалогового окна
        TextView btclose = (TextView)dialog.findViewById(R.id.btnclose);
        btclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Обрабатывание кнопки Закрытия начало
                try{
                    //Вернтьсся назад к выбору уровня начало
                    Intent intent = new Intent(Level2.this, GameLevels.class);
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
                    Intent intent = new Intent(Level2.this, GameLevels.class);//Создали намерение для перехода
                    startActivity(intent); //Старт намерения
                    finish(); //Закрыть этот класс
                } catch (Exception e){
                }
                //Конец конструкции
            }
        });

        //Массив для прогреса игры начало

        final int[] progress ={R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5,
                R.id.point6, R.id.point7, R.id.point8, R.id.point9, R.id.point10,
                R.id.point11, R.id.point12, R.id.point13, R.id.point14, R.id.point15,
                R.id.point16, R.id.point17, R.id.point18, R.id.point19, R.id.point20
        };


        //Массив для прогреса игры конец

        //Подключаем анимацию начало
        final Animation a = AnimationUtils.loadAnimation(Level2.this,R.anim.alpha);

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

                    if (numLeft>numRight){ //Если левая картинка больше
                        if (count<20){
                            count = count+1;
                        }
                        //Закрашиваем прогрес серым цветом начало
                            for (int i=0; i<20; i++){
                                TextView tv = findViewById(progress[i]);
                                tv.setBackgroundResource(R.drawable.style_points);
                            }
                        //Закрашиваем прогрес серымцветом конец
                        //Определяем правильные ответы и закрашиваем зеленым начало
                        for (int i=0; i<count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //Определяем правильные ответы и закрашиваем зеленым конец
                    }else{ //Если левая картинка меньше
                        if (count>0) {
                            if (count==1){
                                count=0;
                            } else
                                count=count-2;
                        }

                        //Закрашиваем прогрес серым цветом начало
                        for (int i=0; i<19; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //Закрашиваем прогрес серымцветом конец
                        //Определяем правильные ответы и закрашиваем зеленым начало
                        for (int i=0; i<count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //Определяем правильные ответы и закрашиваем зеленым конец

                    }
                    //Если отпустили палец конец

                    if (count==20) {
                        //Выход из уровня
                    } else {

                        numLeft = random.nextInt(10); //Генерируем случайное число от 0 до 9
                        img_left.setImageResource(array.images1[numLeft]);  //Достаем из масива картинку
                        img_left.startAnimation(a);

                        textLeft.setText(array.texts1[numLeft]); //Достаем из масива текст

                        numRight = random.nextInt(10); //Генерируем случайное число от 0 до 9
                        //Цикл с предусловием проверяющий равенство чисел начало
                        while (numLeft==numRight){
                            numRight = random.nextInt(10);
                        }
                        //Цикл с предусловием проверяющий равенство чисел конец

                        img_right.setImageResource(array.images1[numRight]); //Достаем из масива картинку
                        img_right.startAnimation(a);
                        textRight.setText(array.texts1[numRight]); //Достаем из масива текст

                        img_right.setEnabled(true);

                    }

                }
                //Усовие касания картинк конец
                return true;
            }
        });
        //Обрабатываем нажатие на левую картинку конец




        //Обрабатываем нажатие на правую картинку начало
        img_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                //Усовие касания картинк начало

                if (event.getAction()==MotionEvent.ACTION_DOWN) {
                    //Если коснулся картинки начало
                    img_left.setEnabled(false);
                    if (numRight>numLeft) {
                        img_right.setImageResource(R.drawable.img_true);
                    } else {
                        img_right.setImageResource(R.drawable.img_false);
                    }

                } else if  (event.getAction()==MotionEvent.ACTION_UP){
                    //Если отпустили палец начало

                    if (numRight>numLeft){ //Если правая картинка больше
                        if (count<20){
                            count = count+1;
                        }
                        //Закрашиваем прогрес серым цветом начало
                        for (int i=0; i<20; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //Закрашиваем прогрес серымцветом конец
                        //Определяем правильные ответы и закрашиваем зеленым начало
                        for (int i=0; i<count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //Определяем правильные ответы и закрашиваем зеленым конец
                    }else{ //Если левая картинка меньше
                        if (count>0) {
                            if (count==1){
                                count=0;
                            } else
                                count=count-2;
                        }

                        //Закрашиваем прогрес серым цветом начало
                        for (int i=0; i<19; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //Закрашиваем прогрес серымцветом конец
                        //Определяем правильные ответы и закрашиваем зеленым начало
                        for (int i=0; i<count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //Определяем правильные ответы и закрашиваем зеленым конец

                    }
                    //Если отпустили палец конец

                    if (count==20) {
                        //Выход из уровня
                    } else {

                        numLeft = random.nextInt(10); //Генерируем случайное число от 0 до 9
                        img_left.setImageResource(array.images1[numLeft]);  //Достаем из масива картинку
                        img_left.startAnimation(a);

                        textLeft.setText(array.texts1[numLeft]); //Достаем из масива текст

                        numRight = random.nextInt(10); //Генерируем случайное число от 0 до 9
                        //Цикл с предусловием проверяющий равенство чисел начало
                        while (numLeft==numRight){
                            numRight = random.nextInt(10);
                        }
                        //Цикл с предусловием проверяющий равенство чисел конец

                        img_right.setImageResource(array.images1[numRight]); //Достаем из масива картинку
                        img_right.startAnimation(a);
                        textRight.setText(array.texts1[numRight]); //Достаем из масива текст

                        img_left.setEnabled(true);

                    }

                }
                //Усовие касания картинк конец
                return true;
            }
        });
        //Обрабатываем нажатие на правую картинку конец



    }

    //Системная кнопка Назад начало
    @Override
    public void onBackPressed(){
        try{
            Intent intent = new Intent(Level2.this, GameLevels.class);
            startActivity(intent);
            finish();
        } catch (Exception e){
        }
    }
    //Системная кнопка Назад конец
}
