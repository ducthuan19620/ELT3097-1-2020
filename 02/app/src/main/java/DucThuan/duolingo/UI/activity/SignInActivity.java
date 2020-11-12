package DucThuan.duolingo.UI.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

import DucThuan.duolingo.R;
import DucThuan.duolingo.Utils.ActivityNavigation;
import DucThuan.duolingo.Utils.Injection;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SignInActivity extends AppCompatActivity {

    @BindView(R.id.email)
    EditText tvEmail;

    @BindView(R.id.password)
    EditText etPassword;

    @BindView(R.id.sign_in_button)
    Button signInButton;

    @BindView(R.id.forgot_password)
    TextView forgotPassword;

    @BindView(R.id.google_signin)
    SignInButton googleSignIn;

    @BindView(R.id.back_button)
    ImageView backButton;

    Context context = SignInActivity.this;

    FirebaseAuth mAuth;
    private GoogleSignInClient mGoogleSignInClient;
    private static final int RC_SIGN_IN = 9001;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        ButterKnife.bind(this);

        initData();
    }

    private void initData() {

        mAuth = Injection.providesAuthHelper().getAuthInstance();

        authUser();
//        instantiateGoogle();
        googleSignInListener();

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SignInActivity.this, WelcomeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void authUser() {

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = tvEmail.getText().toString();
                String password = etPassword.getText().toString();

                if (!isStringNull(email) || !isStringNull(password)) {

                    if (checkEmail(email) && checkPassword(password)) {

                        mAuth.signInWithEmailAndPassword(email, password)
                                .addOnCompleteListener(SignInActivity.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {

                                        if (!task.isSuccessful()) {

                                            Toast.makeText(context, getString(R.string.auth_failed),
                                                    Toast.LENGTH_SHORT).show();

                                        } else {

                                            Intent intent = new Intent(SignInActivity.this, LessonListActivity.class);
                                            startActivity(intent);
                                        }
                                    }
                                });

                    } else if (!checkEmail(email)) {

                        Toast.makeText(context, getString(R.string.invalid_email), Toast.LENGTH_SHORT).show();

                    } else if (!checkPassword(password)) {

                        Toast.makeText(context, getString(R.string.invalid_password), Toast.LENGTH_SHORT).show();
                    }

                } else {

                    Toast.makeText(context, getString(R.string.blankEditText), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isStringNull(String string) {

        if (string.equals("") || string.length() == 0) {

            return true;
        } else {

            return false;
        }
    }

    //     Firebase provides basic security verification when authenticating however if you want to improve
//     it you might have to do this manually within your app
    private boolean checkEmail(String email) {

        if (!email.contains("@") || !email.contains(".com")) {
            return false;
        }

        return true;
    }

    private boolean checkPassword(String password) {

        if (password.length() < 6) {
            return false;
        }

        return true;
    }

    private void instantiateGoogle() {

//        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestIdToken(getString(R.string.default_web_client_id))
//                .requestEmail()
//                .build();
//
//        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
    }

    private void googleSignInListener() {

        googleSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, RC_SIGN_IN);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {

                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);

            } catch (ApiException e) {

                Toast.makeText(context, getString(R.string.auth_failed), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            //take me to main page
                            Toast.makeText(context, "itworked", Toast.LENGTH_SHORT).show();

                            ActivityNavigation.getInstance(SignInActivity.this).takeToRandomTask();

                        } else {

                            Toast.makeText(context, getString(R.string.auth_failed), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
