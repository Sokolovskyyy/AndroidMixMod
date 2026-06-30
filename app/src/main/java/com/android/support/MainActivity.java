package com.android.support;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    // Активность Hearthstone — сюда мод переключается после старта
    public String GameActivity = "com.blizzard.wtcg.hearthstone.HearthstoneApplication";
    public boolean hasLaunched = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Запуск игры и мод-меню
        if (!hasLaunched) {
            try {
                hasLaunched = true;
                // Стартуем Hearthstone
                MainActivity.this.startActivity(new Intent(MainActivity.this, Class.forName(MainActivity.this.GameActivity)));
                Main.Start(this);
                return;
            } catch (ClassNotFoundException e) {
                Log.e("Mod_menu", "Hearthstone activity не найдена");
            }
        }

        Main.Start(this);
    }
}
