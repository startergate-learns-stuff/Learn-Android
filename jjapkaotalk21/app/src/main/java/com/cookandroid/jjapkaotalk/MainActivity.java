package com.cookandroid.jjapkaotalk;

import android.support.v7.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout friend;
    TextView friendName, friendStatus, title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        friend = findViewById(R.id.friend);
        friendName = findViewById(R.id.friendName);
        friendStatus = findViewById(R.id.friendStatus);

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
                //friendName.append("★");

                // 커스텀한 대화 상자를 만들어보기 (xml 레이아웃 파일을 팝업으로 띄우기)
                final View statusView = View.inflate(MainActivity.this, R.layout.activity_status, null);
                AlertDialog.Builder changeDialog = new AlertDialog.Builder(MainActivity.this);
                changeDialog.setView(statusView);
                changeDialog.setNegativeButton("취소", null);
                changeDialog.setPositiveButton("변경", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText et = (EditText) statusView.findViewById(R.id.status);
                        friendStatus.setText(et.getText().toString());
                    }
                });
                changeDialog.show();
                break;
            case R.id.deleteOption:
                // 팝업창처럼 사용 가능한 '대화 상자'를 만들어보자
                AlertDialog.Builder delDialog = new AlertDialog.Builder(MainActivity.this);
                delDialog.setTitle("에에");
                delDialog.setMessage("진짜 혼또로 김도영 손절 데스까?");
                delDialog.setNegativeButton("이이에", null);
                delDialog.setPositiveButton("하잇", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        friend.setVisibility(View.GONE);
                        title.setText("친구가 1명도 없는 짭카오톡ㅠㅠ");
                    }
                });
                delDialog.show();
                break;
            default:
                return false;
        }
        return true;
    }
}
