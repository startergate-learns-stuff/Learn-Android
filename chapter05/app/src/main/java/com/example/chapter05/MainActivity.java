package com.example.chapter05;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText url;
    Button move, prev;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        url = findViewById(R.id.urlarea);
        move = findViewById(R.id.move);
        prev = findViewById(R.id.back);

        webView = findViewById(R.id.webview);

        webView.setWebViewClient(new WebViewTestClass());

        // (부가기능)
        // WebSettings 클래스에 웹슈의 설정 값을 가져오고
        // 여러 기능을 추가할 수 있다. (돋보기 - 확대 축소 기능 - 만 적용)
        WebSettings webSet = webView.getSettings();
        webSet.setBuiltInZoomControls(true);

        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.loadUrl(url.getText().toString());
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.goBack();
            }
        });
    }

    // 1. WebViewClient를 상속받는 클래스 생성
    class WebViewTestClass extends WebViewClient {
        // WebViewClient 클래스를 상속받았는데, 이 클래스에서 필요한 메소드를 오버라이딩해서 사용


        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }
}

// TabView
/*package com.example.chapter05;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

// TabHost - 탭 기능이 구현되어 있는 클래스 포함 extends TabActivity
// 약한 경고를 무시하기 위해서 아래의 내용을 추가
@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabhost);

        // 1. XML,에서 생성한 탭 호스트
        // (@android:id/tabhost 로 id를 지정한 탭 호스트)
        // 를 가져옴
        TabHost tab = getTabHost();

        // 2. 탭 위젯에 필요한 내용들을 등혹한다.
        // 아래의 세 줄을 반복하여서 필요한 만큼 등록 (예제에서는 3개)
        TabHost.TabSpec redTab = tab.newTabSpec("red").setIndicator("빨강색 탭");
        redTab.setContent(R.id.tab1);
        tab.addTab(redTab);

        TabHost.TabSpec blueTab = tab.newTabSpec("blue").setIndicator("파랑색 탭");
        blueTab.setContent(R.id.tab2);
        tab.addTab(blueTab);

        TabHost.TabSpec greenTab = tab.newTabSpec("red").setIndicator("초록색 탭");
        greenTab.setContent(R.id.tab3);
        tab.addTab(greenTab);

        tab.setCurrentTab(0);
    }
}*/

// ViewFlipper
/*package com.example.chapter05;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    Button prevBtn, nextBtn;
    ViewFlipper vf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewflipper);

        prevBtn = findViewById(R.id.prevBtn);
        nextBtn = findViewById(R.id.nextBtn);

        vf = findViewById(R.id.viewFlipper);

        // '<' 버튼 클릭에 대한 기능 정의
        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // vf.showPrevious();
                vf.setFlipInterval(500);
                vf.startFlipping();
            }
        });

        // '>' 버튼 클릭에 대한 기능 정의
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vf.showNext();
            }
        });
    }
}*/



/*
package com.example.chapter05;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slidingdrawer);
    }
}
*/