package ua.opu.preferencesdemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Установка значений по умолчанию
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);

        TextView message = (TextView) findViewById(R.id.message);

        SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(this);


        String name = prefs.getString("name_preference", "Unknown");
        Boolean mature = prefs.getBoolean("mature_preference", true);
        String city = prefs.getString("list_preference_1", "Unknown");

        StringBuilder builder = new StringBuilder();
        builder.append("Привет, ");
        builder.append(name + " .");
        builder.append(" Тебе " + (mature ? "Больше" : "Меньше") + " 18 лет.");
        builder.append(" Ты живешь в городе " + city);

        message.setText(builder.toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
