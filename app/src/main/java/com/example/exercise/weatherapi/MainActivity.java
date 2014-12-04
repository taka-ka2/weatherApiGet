package com.example.exercise.weatherapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends Activity implements View.OnClickListener {

    // HTTP通信（GET, POST）
    // 結果データ（JSON）解析
    // 画面描画などの処理

    public static final String CODE_FK = "400010"; // 福岡
    public static final String CODE_SG = "410010"; // 佐賀
    public static final String CODE_NG = "420010"; // 長崎
    public static final String CODE_OT = "440010"; // 大分
    public static final String CODE_KM = "430010"; // 熊本
    public static final String CODE_MZ = "450010"; // 宮崎
    public static final String CODE_KG = "460010"; // 鹿児島
    public static final String CODE_OW = "471010"; // 沖縄(那覇)
    public static final String EXTRA_MYNAME = "com.example.exercise.weatherapi.MYNAME";


    public TextView[] textprefecture;
    public String areacode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TextView読み込み
        textprefecture = new TextView[] {
                (TextView) findViewById(R.id.textViewFukuoka),
                (TextView) findViewById(R.id.textViewSaga),
                (TextView) findViewById(R.id.textViewNagasaki),
                (TextView) findViewById(R.id.textViewOoita),
                (TextView) findViewById(R.id.textViewKumamoto),
                (TextView) findViewById(R.id.textViewMiyazaki),
                (TextView) findViewById(R.id.textViewKagoshima),
                (TextView) findViewById(R.id.textViewOkinawa)
        };

        // 各テキストにOnClickListenerをセット
        for (int i = 0; i < textprefecture.length; i++) {
            textprefecture[i].setOnClickListener(MainActivity.this);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textViewFukuoka:
                areacode = CODE_FK;
                break;
            case R.id.textViewSaga:
                areacode = CODE_SG;
                break;
            case R.id.textViewNagasaki:
                areacode = CODE_NG;
                break;
            case R.id.textViewOoita:
                areacode = CODE_OT;
                break;
            case R.id.textViewKumamoto:
                areacode = CODE_KM;
                break;
            case R.id.textViewMiyazaki:
                areacode = CODE_MZ;
                break;
            case R.id.textViewKagoshima:
                areacode = CODE_KG;
                break;
            case R.id.textViewOkinawa:
                areacode = CODE_OW;
                break;
        }
        Intent intent = new Intent(this, WeatherDisplayActivity.class);
        intent.putExtra(EXTRA_MYNAME, areacode);
        startActivity(intent);

    }
}
