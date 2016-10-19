package nico.custommvp.login;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import nico.custommvp.BasePresenter;
import nico.custommvp.Entity.User;
import nico.custommvp.R;

public class CLoginActivity extends AppCompatActivity implements LoginDetailContact.View {

    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;

    private LoginDetailContact.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        new LoginPresenter(this, this);
    }

    @Override
    public void showProgress() {
        mProgressView.setVisibility(View.VISIBLE);

    }

    @Override
    public void showError() {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mProgressView.setVisibility(View.GONE);
                Toast.makeText(CLoginActivity.this, "failed", Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    public void showSuccess() {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mProgressView.setVisibility(View.GONE);
                Toast.makeText(CLoginActivity.this, "success", Toast.LENGTH_LONG).show();
            }
        });

    }

//    @Override
//    public void setPresenter(LoginDetailContact.Presenter tp) {
//        mPresenter = tp;
//    }

    private void initView() {
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);

        mPasswordView = (EditText) findViewById(R.id.password);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    return true;
                }
                return false;
            }
        });

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.start();
            }
        });

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
    }



    @Override
    public void setPresenter(LoginDetailContact.Presenter tp) {
        mPresenter = tp;
    }

}
