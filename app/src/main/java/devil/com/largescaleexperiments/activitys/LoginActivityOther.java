package devil.com.largescaleexperiments.activitys;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;

import devil.com.largescaleexperiments.R;

import static android.Manifest.permission.READ_CONTACTS;

public class LoginActivityOther extends AppCompatActivity implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener {

    private VideoView mVideoView;
    private AutoCompleteTextView mEmailView;
    private static final int REQUEST_READ_CONTACTS = 0;
    private EditText mPasswordView;
    private String url = "http://192.168.137.1:8080/index";
    private LinearLayout registLL ;
    private LinearLayout loginLL ;
    private TextView mLoginToRegist;
    private TextView mRegistToLogin;
    private Button mLoginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        //取消状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login_other);
        mVideoView = (VideoView) findViewById(R.id.videoView);
        initView();
        onclickInit();
    }

    private void initView() {
        mLoginButton=findViewById(R.id.email_login_button);
        registLL = findViewById(R.id.regist_LL);
        loginLL = findViewById(R.id.login_LL);
        mLoginToRegist = findViewById(R.id.login_to_regist);
        mRegistToLogin = findViewById(R.id.regist_to_login);


        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);

        mPasswordView = (EditText) findViewById(R.id.password);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {

                    return true;
                }
                return false;
            }
        });


        //设置屏幕常亮
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        mVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.wetest));
        //设置相关的监听
        mVideoView.setOnPreparedListener(this);
        mVideoView.setOnCompletionListener(this);
    }
    private void onclickInit(){
        mLoginToRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginLL.setVisibility(View.GONE);
                registLL.setVisibility(View.VISIBLE);
            }
        });
        mRegistToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginLL.setVisibility(View.VISIBLE);
                registLL.setVisibility(View.GONE);

            }
        });
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(LoginActivityOther.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    //播放准备
    @Override
    public void onPrepared(MediaPlayer mp) {
        //开始播放
        mVideoView.start();
    }

    //播放结束
    @Override
    public void onCompletion(MediaPlayer mp) {
        //开始播放
        mVideoView.start();
    }


}
