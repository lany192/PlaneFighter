package com.github.lany192.planefighter;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements OnGameOverListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApp.setActivity(this);
        restart();
    }

    private void restart() {
        BGSurfaceView view = new BGSurfaceView(this);
        view.setOnGameOverListener(this);
        setContentView(view);
    }

    @Override
    public void onGameOver(final int score) {
        runOnUiThread(() -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("游戏结束");
            builder.setMessage("分数：" + score);
            builder.setPositiveButton(android.R.string.ok, (dialog, id) -> finish());
            builder.setNegativeButton("重新开始", (dialog, id) -> restart());
            builder.create().show();
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
