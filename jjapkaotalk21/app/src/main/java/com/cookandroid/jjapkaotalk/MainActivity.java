package com.cookandroid.jjapkaotalk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout friend;
    TextView friendName, title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        friend = findViewById(R.id.friend);
        friendName = findViewById(R.id.friendName);

        title = findViewById(R.id.title);

        registerForContextMenu(friend);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater mInf = getMenuInflater();

        mInf.inflate(R.menu.main_configure_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater contextMInf = getMenuInflater();
        if (v == friend) contextMInf.inflate(R.menu.user_configure_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        super.onContextItemSelected(item);

        switch (item.getItemId()) {
            case R.id.favoriteOption:
                friendName.append("★");
                break;
            case R.id.deleteOption:
                friend.setVisibility(View.GONE);
                title.setText("친구가 1명도 없는 짭카오톡ㅠㅠ");
                break;
            default:
                return false;
        }
        return true;
    }
}
