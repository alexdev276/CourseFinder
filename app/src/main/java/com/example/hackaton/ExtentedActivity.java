package com.example.hackaton;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ExtentedActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.extented_layout);
        Button back = (Button) findViewById(R.id.back);

        String nameTable = getIntent().getStringExtra("bdName");

        Toast t = Toast.makeText(getApplicationContext(), nameTable, Toast.LENGTH_SHORT);
        t.show();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ExtentedActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        create_db(nameTable);

        /*

        TextView textView = new TextView(this);
        textView.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry...like Aldus PageMaker including versions of Lorem Ipsum.");
        textView.setLayoutParams(new ViewGroup.LayoutParams
                (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        textView.setTextSize(26);
        scrollView.addView(textView);
        setContentView(scrollView);*/
    }

    @SuppressLint("SetTextI18n")
    public void create_db(String name1) {
        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);

        try {
            db.execSQL("CREATE TABLE JavaScript (_id INTEGER, Name TEXT, Price INTEGER, Rating REAL, Link TEXT)");
            db.execSQL("insert into JavaScript VALUES (1, 'Профессия: Frontend-разработчик', 112950, 4.5, 'https://productstar.ru/dev-frontend-prof?source_type=partners&utm_source=rating&utm_medium=cpa&utm_campaign=dev-prof&utm_term=sravni&utm_content=october&click_id=102a1349c30b62c8fb8ad419abf1de');");
            db.execSQL("insert into JavaScript VALUES (2, 'JavaScript-разработчик', 38703, 4.2, 'https://brunoyam.com/online-kursy/programmirovanie-javascript?utm_source=sravni_ru&utm_medium=cpa&utm_campaign=ref&click_id=102e987504591ca9b3a8925d9088ec');");
            db.execSQL("insert into JavaScript VALUES (3, 'Веб-разработчик с нуля', 144990, 3.8, 'https://netology.ru/programs/web-developer?utm_source=advcake&utm_medium=cpa&utm_campaign=affiliate&utm_content=e180b2d0&advcake_params=51215e94d49c118e45fc6db794e8eeab&utm_term=51215e94d49c118e45fc6db794e8eeab&sub1=ga_1486448580.1679839457|ym_1679839444216807637&sub2=/kursy/programmirovanie-javascript/&sub4=%D0%9D%D0%B5%D1%82%D0%BE%D0%BB%D0%BE%D0%B3%D0%B8%D1%8F|%D0%92%D0%B5%D0%B1-%D1%80%D0%B0%D0%B7%D1%80%D0%B0%D0%B1%D0%BE%D1%82%D1%87%D0%B8%D0%BA%20%D1%81%20%D0%BD%D1%83%D0%BB%D1%8F&sub5=%D0%9A%D1%83%D1%80%D1%81%D1%8B&keyword=search|position_3');");
            db.execSQL("insert into JavaScript VALUES (4, 'JavaScript', 26950, 4.2, 'https://loftschool.com/course/javascript/?pr=sravni8&utm_source=sravni&utm_medium=discount');");
            db.execSQL("insert into JavaScript VALUES (5, 'JavaScript. Профессиональная разработка веб-интерфейсов', 25900, 4.0, 'https://htmlacademy.ru/intensive/javascript?admitad_uid=99f9188581f7f6d8d9c14dd376fff1ad&utm_source=admitad');");
            db.execSQL("insert into JavaScript VALUES (6, 'JavaScript Developer. Basic', 79000, 4.0, 'https://otus.ru/lessons/javascript-basic/?utm_source=advcake&utm_medium=cpa&utm_campaign=otus&utm_content=affiliate_e180b2d0&advcake_params=c6898c1c5555e75119e2b70e966f2075&utm_term=c6898c1c5555e75119e2b70e966f2075&sub1=ga_1486448580.1679839457|ym_1679839444216807637&sub2=/kursy/programmirovanie-javascript/&sub4=OTUS|JavaScript%20Developer.%20Basic&sub5=%D0%9A%D1%83%D1%80%D1%81%D1%8B&keyword=search|position_23');");
            db.execSQL("insert into JavaScript VALUES (7, 'Первые шаги в JavaScript: создаём сайт', 0, 3.8, 'https://netology.ru/programs/jsfree-async?utm_source=advcake&utm_medium=cpa&utm_campaign=affiliate&utm_content=e180b2d0&advcake_params=bc1494f081c91276d04798e95c2017d6&utm_term=bc1494f081c91276d04798e95c2017d6&sub1=ga_1486448580.1679839457|ym_1679839444216807637&sub2=/kursy/programmirovanie-javascript/&sub4=%D0%9D%D0%B5%D1%82%D0%BE%D0%BB%D0%BE%D0%B3%D0%B8%D1%8F|%D0%9F%D0%B5%D1%80%D0%B2%D1%8B%D0%B5%20%D1%88%D0%B0%D0%B3%D0%B8%20%D0%B2%20JavaScript:%20%D1%81%D0%BE%D0%B7%D0%B4%D0%B0%D1%91%D0%BC%20%D1%81%D0%B0%D0%B9%D1%82&sub5=%D0%9A%D1%83%D1%80%D1%81%D1%8B&keyword=search|position_30');");
            db.execSQL("insert into JavaScript VALUES (8, 'Профессия Frontend-разработчик PRO', 127575, 4.2, 'https://skillbox.ru/course/frontend-pro-expert/?utm_source=advcake&utm_medium=cpa&utm_campaign=affiliate&utm_content=e180b2d0&utm_term=22063a3b3c50755bd7c635bdc9567db4&advcake_params=22063a3b3c50755bd7c635bdc9567db4&sub1=ga_1486448580.1679839457|ym_1679839444216807637&sub2=/kursy/programmirovanie-javascript/&sub4=Skillbox|Frontend-%D1%80%D0%B0%D0%B7%D1%80%D0%B0%D0%B1%D0%BE%D1%82%D1%87%D0%B8%D0%BA%20PRO&sub5=%D0%9A%D1%83%D1%80%D1%81%D1%8B&keyword=search|position_31');");
            db.execSQL("insert into JavaScript VALUES (9, 'Инженер-программист JavaScript', 107406, 3.5, 'https://gb.ru/geek_university/developer/programmer/javascript?utm_source=aff&utm_medium=cpa&utm_campaign=aff_cpa_affiliate&utm_content=e180b2d0&utm_term=d151f229cdc6ccce6b814d630ea030bb&sub1=ga_1486448580.1679839457|ym_1679839444216807637&sub2=/kursy/programmirovanie-javascript/&sub4=Geekbrains|%D0%98%D0%BD%D0%B6%D0%B5%D0%BD%D0%B5%D1%80-%D0%BF%D1%80%D0%BE%D0%B3%D1%80%D0%B0%D0%BC%D0%BC%D0%B8%D1%81%D1%82%20JavaScript&sub5=%D0%9A%D1%83%D1%80%D1%81%D1%8B&keyword=search|position_33');");
            db.execSQL("insert into JavaScript VALUES (10, 'Асинхронное программирование на JavaScript', 3900, 4.2, 'https://ru.hexlet.io/programs/js-async?utm_source=advcake&utm_medium=cpa&utm_campaign=affiliate&utm_content=e180b2d0&advcake_params=14e5a0ed14172639e98aed654bfab2a1&utm_term=14e5a0ed14172639e98aed654bfab2a1&sub1=ga_1486448580.1679839457|ym_1679839444216807637&sub2=/kursy/programmirovanie-javascript/&sub4=%D0%A5%D0%B5%D0%BA%D1%81%D0%BB%D0%B5%D1%82|%D0%90%D1%81%D0%B8%D0%BD%D1%85%D1%80%D0%BE%D0%BD%D0%BD%D0%BE%D0%B5%20%D0%BF%D1%80%D0%BE%D0%B3%D1%80%D0%B0%D0%BC%D0%BC%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5%20%D0%BD%D0%B0%20JS&sub5=%D0%9A%D1%83%D1%80%D1%81%D1%8B&keyword=search|position_42');");

        } catch (Exception ignored) {
        }

        try {

            db.execSQL("CREATE TABLE DataScientist (_id INTEGER, Name TEXT, Price INTEGER, Rating REAL, Link TEXT)");
            db.execSQL("insert into DataScientist VALUES (1, 'Курс: Data Scientist', 84600, 4.5, 'https://productstar.ru/analytics-datascience-course?source_type=partners&utm_source=rating&utm_medium=cpa&utm_campaign=analytics-6M&utm_term=sravni&utm_content=july&click_id=102a1349c30b62c8fb8ad419abf1de');");
            db.execSQL("insert into DataScientist VALUES (2, 'Профессия Data Scientist', 108640, 4.2, 'https://brunoyam.com/online-kursy/data-scientist?utm_source=sravni_ru&utm_medium=cpa&utm_campaign=ref&click_id=102e987504591ca9b3a8925d9088ec');");
            db.execSQL("insert into DataScientist VALUES (3, 'Симулятор аналитика', 35000, 4.3, 'https://karpov.courses/simulator?utm_source=infopartners&utm_medium=cpa&utm_campaign=sravni_da');");
            db.execSQL("insert into DataScientist VALUES (4, 'Основы математики для Data Science', 24322, 4.2, 'https://skillbox.ru/course/math-for-data-science-upsale/?utm_source=advcake&utm_medium=cpa&utm_campaign=affiliate&utm_content=e180b2d0&utm_term=68e349bbf57199aae34d9d9beadba3cb&advcake_params=68e349bbf57199aae34d9d9beadba3cb&sub1=ga_1486448580.1679839457|ym_1679839444216807637&sub2=/kursy/analitika-data-science/&sub4=Skillbox|%D0%9E%D1%81%D0%BD%D0%BE%D0%B2%D1%8B%20%D0%BC%D0%B0%D1%82%D0%B5%D0%BC%D0%B0%D1%82%D0%B8%D0%BA%D0%B8%20%D0%B4%D0%BB%D1%8F%20Data%20Science&sub5=%D0%9A%D1%83%D1%80%D1%81%D1%8B&keyword=search|position_3');");
            db.execSQL("insert into DataScientist VALUES (5, 'Data Science', 131670, 4.1, 'https://skillfactory.ru/data-science-specialization?utm_source=infopartners&utm_medium=cpa&utm_campaign=sravni&utm_content=dst&utm_term=1028f079c0486a907af161d768dd97');");
            db.execSQL("insert into DataScientist VALUES (6, 'Data Scientist', 118800, 3.8, 'https://netology.ru/programs/data-scientist?utm_source=advcake&utm_medium=cpa&utm_campaign=affiliate&utm_content=e180b2d0&advcake_params=c8735cadd749868664545ee1318e36da&utm_term=c8735cadd749868664545ee1318e36da&sub1=ga_1486448580.1679839457|ym_1679839444216807637&sub2=/kursy/analitika-data-science/&sub4=%D0%9D%D0%B5%D1%82%D0%BE%D0%BB%D0%BE%D0%B3%D0%B8%D1%8F|Data%20Scientist&sub5=%D0%9A%D1%83%D1%80%D1%81%D1%8B&keyword=search|position_5');");
            db.execSQL("insert into DataScientist VALUES (7, 'Data Science в медицине', 123991, 3.5, 'https://gb.ru/geek_university/developer/analyst/data-science-medicine?utm_source=aff&utm_medium=cpa&utm_campaign=aff_cpa_affiliate&utm_content=e180b2d0&utm_term=38353b2759257eebe2e0b4dcac0e80f5&sub1=ga_1486448580.1679839457|ym_1679839444216807637&sub2=/kursy/analitika-data-science/&sub4=Geekbrains|%D0%94%D0%B0%D1%82%D0%B0-%D1%81%D0%B0%D0%B9%D0%B5%D0%BD%D1%82%D0%B8%D1%81%D1%82%20%D0%B2%20%D0%BC%D0%B5%D0%B4%D0%B8%D1%86%D0%B8%D0%BD%D0%B5&sub5=%D0%9A%D1%83%D1%80%D1%81%D1%8B&keyword=search|position_6');");
            db.execSQL("insert into DataScientist VALUES (7, 'Data Science в медицине', 123991, 3.5, 'https://gb.ru/geek_university/developer/analyst/data-science-medicine?utm_source=aff&utm_medium=cpa&utm_campaign=aff_cpa_affiliate&utm_content=e180b2d0&utm_term=38353b2759257eebe2e0b4dcac0e80f5&sub1=ga_1486448580.1679839457|ym_1679839444216807637&sub2=/kursy/analitika-data-science/&sub4=Geekbrains|%D0%94%D0%B0%D1%82%D0%B0-%D1%81%D0%B0%D0%B9%D0%B5%D0%BD%D1%82%D0%B8%D1%81%D1%82%20%D0%B2%20%D0%BC%D0%B5%D0%B4%D0%B8%D1%86%D0%B8%D0%BD%D0%B5&sub5=%D0%9A%D1%83%D1%80%D1%81%D1%8B&keyword=search|position_6');");
            db.execSQL("insert into DataScientist VALUES (8, 'Основы Data Science', 33413, 3.9, 'https://sf.education/ds?utm_source=partner&utm_medium=cpa&utm_campaign=sravniru');");
            db.execSQL("insert into DataScientist VALUES (9, 'Специалист по Data Science', 112000, 3.4, 'https://practicum.yandex.ru/data-scientist/?utm_source=partners&utm_medium=sravni&utm_campaign=partners_sravni_data-scientist');");
            db.execSQL("insert into DataScientist VALUES (10, 'Data Scientist с нуля до Junior', 109687, 4.2, 'https://skillbox.ru/course/paket-data-scientist-0-junior-price/?utm_source=advcake&utm_medium=cpa&utm_campaign=affiliate&utm_content=e180b2d0&utm_term=b2aae2d897cef710543fb79bd8152918&advcake_params=b2aae2d897cef710543fb79bd8152918&sub1=ga_1486448580.1679839457|ym_1679839444216807637&sub2=/kursy/analitika-data-science/&sub4=Skillbox|Data%20Scientist%20%D1%81%20%D0%BD%D1%83%D0%BB%D1%8F%20%D0%B4%D0%BE%20Junior&sub5=%D0%9A%D1%83%D1%80%D1%81%D1%8B&keyword=search|position_10');");

        } catch (Exception ignored) {
        }

        try {
            db.execSQL("CREATE TABLE Python (_id INTEGER, Name TEXT, Price INTEGER, Rating REAL, Link TEXT)");
            db.execSQL("insert into Python VALUES (1, 'Python-разработчик', 64750, 4.1, 'https://eduson.academy/python-new?utm_source=cpa&utm_medium=sravni_ru&utm_campaign=cpa&click_id=1026b57fb013035295d4df75d3713d');");
            db.execSQL("insert into Python VALUES (2, 'Профессия: Python-разработчик', 148932, 4.5, 'https://new.productstar.ru/prof_start_python_advancetariff?utm_source=rating&utm_medium=cpa&utm_campaign=dev-prof-python-tariff&utm_term=sravni&utm_content=02-2023&click_id=102a1349c30b62c8fb8ad419abf1de');");
            db.execSQL("insert into Python VALUES (3, 'Python-разработчик (Стандартный)', 103461, 4.3, 'https://sky.pro/courses/programming/python-web-course?utm_source=advcake&utm_medium=cpa&utm_campaign=n_|mas_e180b2d0|ptn_affiliate|ma_Berezhnoy|own_b2c|chg_affiliate&utm_advcake_params=2090e7c3832d247b7a383eee13917ec3&utm_term=2090e7c3832d247b7a383eee13917ec3&sub1=ga_1486448580.1679839457|ym_1679839444216807637&sub2=/kursy/programmirovanie-python/&sub4=Skypro|Python-%D1%80%D0%B0%D0%B7%D1%80%D0%B0%D0%B1%D0%BE%D1%82%D1%87%D0%B8%D0%BA%20(%D0%A1%D1%82%D0%B0%D0%BD%D0%B4%D0%B0%D1%80%D1%82%D0%BD%D1%8B%D0%B9)&sub5=%D0%9A%D1%83%D1%80%D1%81%D1%8B&keyword=search|position_2');");
            db.execSQL("insert into Python VALUES (4, 'Python-разработчик', 72653, 4.2, 'https://brunoyam.com/online-kursy/python-s-nulya?utm_source=sravni_ru&utm_medium=cpa&utm_campaign=ref&click_id=102e987504591ca9b3a8925d9088ec');");
            db.execSQL("insert into Python VALUES (5, 'Python-разработка для начинающих', 0, 3.8, 'https://netology.ru/programs/pyfree-async?utm_source=advcake&utm_medium=cpa&utm_campaign=affiliate&utm_content=e180b2d0&advcake_params=9a44618cf93f75d63ba83e558b4bacbd&utm_term=9a44618cf93f75d63ba83e558b4bacbd&sub1=ga_1486448580.1679839457|ym_1679839444216807637&sub2=/kursy/programmirovanie-python/&sub4=%D0%9D%D0%B5%D1%82%D0%BE%D0%BB%D0%BE%D0%B3%D0%B8%D1%8F|%D0%9E%D1%81%D0%BD%D0%BE%D0%B2%D1%8B%20%D0%BF%D1%80%D0%BE%D0%B3%D1%80%D0%B0%D0%BC%D0%BC%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D1%8F%20%D0%BD%D0%B0%20Python&sub5=%D0%9A%D1%83%D1%80%D1%81%D1%8B&keyword=search|position_4');");
            db.execSQL("insert into Python VALUES (6, 'Python Developer', 174000, 4.0, 'https://otus.ru/lessons/python-specialization/?utm_source=advcake&utm_medium=cpa&utm_campaign=otus&utm_content=affiliate_e180b2d0&advcake_params=28e77a171cf9cfd8b229512e65d00799&utm_term=28e77a171cf9cfd8b229512e65d00799&sub1=ga_1486448580.1679839457|ym_1679839444216807637&sub2=/kursy/programmirovanie-python/&sub4=OTUS|Python%20Developer&sub5=%D0%9A%D1%83%D1%80%D1%81%D1%8B&keyword=search|position_11');");
            db.execSQL("insert into Python VALUES (7, 'Fullstack-разработчик на Python', 97628, 4.6, 'https://study.logomachine.ru/python-fullstack-web-developer?utm_source=sravni.ru&utm_medium=cpa&utm_campaign=sravni-python-fullstack&click_id=102d031384e0dd0c4ec6177894d18f');");
            db.execSQL("insert into Python VALUES (8, 'Тестирование веб-приложений на Python', 40000, 3.4, 'https://practicum.yandex.ru/qa-automation-web-python/?utm_source=partners&utm_medium=sravni&utm_campaign=partners_sravni_qa-automation-web-python');");
            db.execSQL("insert into Python VALUES (9, 'Профессия Python-разработчик (Базовый)', 128250, 4.2, 'https://skillbox.ru/course/profession-python-tariff/?utm_source=advcake&utm_medium=cpa&utm_campaign=affiliate&utm_content=e180b2d0&utm_term=de26d8553155928e41b6901d3a74c95a&advcake_params=de26d8553155928e41b6901d3a74c95a&sub1=ga_1486448580.1679839457|ym_1679839444216807637&sub2=/kursy/programmirovanie-python/&sub4=Skillbox|Python-%D1%80%D0%B0%D0%B7%D1%80%D0%B0%D0%B1%D0%BE%D1%82%D1%87%D0%B8%D0%BA%20(%D0%91%D0%B0%D0%B7%D0%BE%D0%B2%D1%8B%D0%B9)&sub5=%D0%9A%D1%83%D1%80%D1%81%D1%8B&keyword=search|position_5');");
            db.execSQL("insert into Python VALUES (10, 'Бэкэнд-разработчик на Python', 51750, 3.9, 'https://sf.education/bkpython?utm_source=partner&utm_medium=cpa&utm_campaign=sravniru');");


        } catch (Exception ignored) {
        }

        LinearLayout layout = findViewById(R.id.line1);
        Cursor query = db.rawQuery("SELECT * FROM " + name1 + ";", null);
        ScrollView scrollView = findViewById(R.id.scroll);
        Button[] buttons = new Button[10];
        for (int i = 0; i < 10; i++) {
            query.moveToNext();

            buttons[i] = new Button(this);
            buttons[i].setId(i);

            String name = query.getString(1);
            int price = query.getInt(2);
            String rating = query.getString(3);
            String link = query.getString(4);

            buttons[i].setText(name + "\n" + "Цена:           Рейтинг:" + "\n" + price + "р                   " + rating + "*");
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri adress = Uri.parse(link);
                    Intent browser = new Intent(Intent.ACTION_VIEW, adress);
                    startActivity(browser);
                }

            });
            layout.addView(buttons[i]);
        }
    }
}



