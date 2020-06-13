package spase.suchkov.quiz;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

public class Level4 extends AppCompatActivity {
    Dialog dialog;
    Dialog dialogEnd;

    public int numLeft; //переменая для левой картики + текст
    public int numRight; //переменая для правой картинки + текст
    Array array = new Array(); //Создали новый объект из класса Array
    Random random = new Random(); //Для генерации случайных чисел
    public int count = 0; //Счетчик правильных ответов

    private Object Button;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);
        //Создаем переменую text levels
        TextView text_levels = findViewById(R.id.text_levels);
        text_levels.setText(R.string.level4); //установили текст
        text_levels.setTextColor(R.color.black95);

        final ImageView img_left = findViewById(R.id.img_left);
        //Код который скругляет углы левой картинки
        img_left.setClipToOutline(true);


        final ImageView img_right = findViewById(R.id.img_right);
        //Код который скругляет углы правой картинки
        img_right.setClipToOutline(true);

        //Путь к левой TextView
        final TextView textLeft = findViewById(R.id.text_left);
        textLeft.setTextColor(R.color.black95);
        //Путь к правой TextView
        final TextView textRight = findViewById(R.id.text_right);
        textRight.setTextColor(R.color.black95);



        //Развернуть игру на весь экран начало
        Window w = getWindow();
        //  w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Развернуть игру на весь экран конец

        //Устанавливаем Фон начало
        ImageView background = (ImageView)findViewById(R.id.background);
        background.setImageResource(R.drawable.level4);
        //Устанавливаем Фон конец


        //Вызов диалогового окна
        dialog = new Dialog(this);//создаем диалоговое окно
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); //Скрываем заголовок диалогового окна
        dialog.setContentView(R.layout.previewdialog); //Путь к макету диалогового окна
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //прозрачный фон диалогового окна
        dialog.setCancelable(false); //Окно нельзя закрыть кнопкой назад


        //Утанавливаем картинку в диалоговое окно - Начало
        ImageView previewimg =  dialog.findViewById(R.id.previewimg); //previewimg
        previewimg.setImageResource(R.drawable.previewimg4);
        //Утанавливаем картинку в диалоговое окно - Конец

        //Устанавливаем фон диалогового окна - Начало
        LinearLayout dialogfon = dialog.findViewById(R.id.dialogfon);
        dialogfon.setBackgroundResource(R.drawable.previewbackground4);
        //Устанавливаем фон диалогового окна - Конец

        //Устанавливаем описание задания начало
        TextView textdescription = dialog.findViewById(R.id.textdescription);
        textdescription.setText(R.string.levelfour);
        //Устанавливаем описание задания конец


        //Кнопка закрытия диалогового окна
        TextView btclose = (TextView)dialog.findViewById(R.id.btnclose);
        btclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Обрабатывание кнопки Закрытия начало
                try{
                    //Вернтьсся назад к выбору уровня начало
                    Intent intent = new Intent(Level4.this, GameLevels.class);
                    startActivity(intent); //Старт намериния
                    finish(); //Закрыть класс

                    //Вернтьсся назад к выбору уровня конец
                } catch (Exception e){
                }
                dialog.dismiss(); //Закрываем диалоговое окно
                //Обрабатывание кнопки Закрытия конец

            }
        });

        //Кнопка Продолжить начало для диалога в начале уровня

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

        //______________________________________________________
        //Вызов диалогового окна в конце игры
        dialogEnd = new Dialog(this);//создаем диалоговое окно
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE); //Скрываем заголовок диалогового окна
        dialogEnd.setContentView(R.layout.dialogend); //Путь к макету диалогового окна
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //прозрачный фон диалогового окна
        dialogEnd.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.MATCH_PARENT);// Развернуть диалоговое окно на весь экран
        dialogEnd.setCancelable(false); //Окно нельзя закрыть кнопкой назад

        //Устанавливаем фон диалогового окна начало
        LinearLayout dialogfonEnd = (LinearLayout) dialogEnd.findViewById(R.id.dialogfon);
        dialogfonEnd.setBackgroundResource(R.drawable.previewbackground4);
        //Устанавливаем фон диалогового окна конец

        //Интересный факт начало
        TextView textdescriptionEnd = (TextView)dialogEnd.findViewById(R.id.textdescriptionEnd);
        textdescriptionEnd.setText(R.string.levelfourEnd);
        //Интересный факт конец



        //Кнопка закрытия диалогового окна
        TextView btclose2 = (TextView)dialogEnd.findViewById(R.id.btnclose);
        btclose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Обрабатывание кнопки Закрытия начало
                try{
                    //Вернтьсся назад к выбору уровня начало
                    Intent intent = new Intent(Level4.this, GameLevels.class);
                    startActivity(intent); //Старт намериния
                    finish(); //Закрыть класс

                    //Вернтьсся назад к выбору уровня конец
                } catch (Exception e){
                }
                dialogEnd.dismiss(); //Закрываем диалоговое окно
                //Обрабатывание кнопки Закрытия конец

            }
        });

        //Кнопка Продолжить начало

        Button btncontinue2 = dialogEnd.findViewById(R.id.btncontinue);
        btncontinue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(Level4.this, GameLevels .class);
                    startActivity(intent); //Старт намериния
                    finish(); //Закрыть класс
                } catch (Exception e){
                }
                dialogEnd.dismiss(); //Закрываем диалоговое окно
            }
        });

        //Кнопка Продолжить конец

//______________________________________________________



        Button button_back = findViewById(R.id.button_back);
        button_back.setBackgroundResource(R.drawable.button_stroke_black95_press_white);
        button_back.setTextColor(R.color.black95);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Команда для кнопки назад
                //Начало конструкции
                try{
                    Intent intent = new Intent(Level4.this, GameLevels.class);//Создали намерение для перехода
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
        final Animation a = AnimationUtils.loadAnimation(Level4.this,R.anim.alpha);
        //Подключаем анимацию конец

        numLeft = random.nextInt(20); //Генерируем случайное число от 1 до 20
        img_left.setImageResource(array.images4[numLeft]);  //Достаем из масива картинку
        textLeft.setText(array.texts4[numLeft]); //Достаем из масива текст

        numRight = random.nextInt(20); //Генерируем случайное число от 0 до 20
        //Цикл с предусловием проверяющий равенство чисел начало
        while (array.strong[numLeft]==array.strong[numRight]){
            numRight = random.nextInt(20);
        }
        //Цикл с предусловием проверяющий равенство чисел конец

        img_right.setImageResource(array.images4[numRight]); //Достаем из масива картинку
        textRight.setText(array.texts4[numRight]); //Достаем из масива текст

        //Обрабатываем нажатие на левую картинку начало
        img_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                //Усовие касания картинк начало

                if (event.getAction()==MotionEvent.ACTION_DOWN) {
                    //Если коснулся картинки начало
                  img_right.setEnabled(false);
                  if (array.strong[numLeft]>array.strong[numRight]) {
                      img_left.setImageResource(R.drawable.img_true);
                  } else {
                      img_left.setImageResource(R.drawable.img_false);
                  }

                } else if  (event.getAction()==MotionEvent.ACTION_UP){
                    //Если отпустили палец начало

                    if (array.strong[numLeft]>array.strong[numRight]){ //Если левая картинка больше
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

                        //Сохранение начало
                        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
                        final int level = save.getInt("Level", 1);
                        if (level > 4) {
                            //пусто
                        } else {
                            SharedPreferences.Editor editor = save.edit();
                            editor.putInt("Level", 5);
                            editor.commit();
                        }
                        //Сохранение конец

                        dialogEnd.show();
                    } else {

                        numLeft = random.nextInt(20); //Генерируем случайное число от 1 до 20
                        img_left.setImageResource(array.images4[numLeft]);  //Достаем из масива картинку
                        textLeft.setText(array.texts4[numLeft]); //Достаем из масива текст

                        numRight = random.nextInt(20); //Генерируем случайное число от 0 до 20
                        //Цикл с предусловием проверяющий равенство чисел начало
                        while (array.strong[numLeft]==array.strong[numRight]){
                            numRight = random.nextInt(20);
                        }
                        //Цикл с предусловием проверяющий равенство чисел конец

                        img_right.setImageResource(array.images4[numRight]); //Достаем из масива картинку
                        textRight.setText(array.texts4[numRight]); //Достаем из масива текст

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
                    if (array.strong[numRight]>array.strong[numLeft]) {
                        img_right.setImageResource(R.drawable.img_true);
                    } else {
                        img_right.setImageResource(R.drawable.img_false);
                    }

                } else if  (event.getAction()==MotionEvent.ACTION_UP){
                    //Если отпустили палец начало

                    if (array.strong[numRight]>array.strong[numLeft]){ //Если правая картинка больше
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

                        //Сохранение начало
                        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
                        final int level = save.getInt("Level", 1);
                        if (level > 4) {
                            //пусто
                        } else {
                            SharedPreferences.Editor editor = save.edit();
                            editor.putInt("Level", 5);
                            editor.commit();
                        }
                        //Сохранение конец

                        dialogEnd.show();
                    } else {

                        numLeft = random.nextInt(20); //Генерируем случайное число от 1 до 20
                        img_left.setImageResource(array.images4[numLeft]);  //Достаем из масива картинку
                        textLeft.setText(array.texts4[numLeft]); //Достаем из масива текст

                        numRight = random.nextInt(20); //Генерируем случайное число от 0 до 20
                        //Цикл с предусловием проверяющий равенство чисел начало
                        while (array.strong[numLeft]==array.strong[numRight]){
                            numRight = random.nextInt(20);
                        }
                        //Цикл с предусловием проверяющий равенство чисел конец

                        img_right.setImageResource(array.images4[numRight]); //Достаем из масива картинку
                        textRight.setText(array.texts4[numRight]); //Достаем из масива текст

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
            Intent intent = new Intent(Level4.this, GameLevels.class);
            startActivity(intent);
            finish();
        } catch (Exception e){
        }
    }
    //Системная кнопка Назад конец
}
