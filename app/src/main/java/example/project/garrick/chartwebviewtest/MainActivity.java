package example.project.garrick.chartwebviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private Button btn_firstchart, btn_secondchart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }


    private void initView() {
        webView = (WebView) findViewById(R.id.webView);
        WebSettings websettings = webView.getSettings();
        websettings.setUseWideViewPort(true);
        websettings.setJavaScriptEnabled(true);
        webView.loadUrl("http://blog.scottlogic.com/2014/09/26/an-interactive-stock-comparison-chart-with-d3.html");
        webView.getSettings().setAppCacheEnabled(true); //設置啟動緩存
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.setWebViewClient(new WebViewClient() { //設定在WebView裡顯示，而非開啟瀏覽器顯示

            public void onPageFinished(WebView view, String url) {
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }

        });


        btn_firstchart = (Button) findViewById(R.id.btn_firstchart);
        btn_firstchart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("http://blog.scottlogic.com/2014/09/26/an-interactive-stock-comparison-chart-with-d3.html");
            }
        });

        btn_secondchart = (Button) findViewById(R.id.btn_secondchart);
        btn_secondchart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("http://arnauddri.github.io/d3-stock/");
            }
        });
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
}
