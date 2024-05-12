package android.org.firebasetest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class
MainActivity extends AppCompatActivity {
    private Button signOutButton;
    private TextView Name;
    private FirebaseAuth mAuth;  // Firebase Auth 객체 선언
    private static final String TAG = "MainActivity";
    private FirebaseDataUploader uploader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Firebase 초기화
        FirebaseApp.initializeApp(this);

        // 인텐트에서 사용자 ID 가져오기
        String userId = getIntent().getStringExtra("userId");
        if (userId != null) {
            Log.d("MainActivity", "User ID: " + userId);
            // 여기에서 사용자 ID를 사용하여 추가 작업 수행
        }
        UserManager userManager = new UserManager();
        userManager.fetchUserById(userId, new UserManager.UserCallback() {
            @Override
            public void onUserRetrieved(User user) {
                String userName = user.getName();
                if (userName != null && !userName.isEmpty()) {
                    Name = findViewById(R.id.userName);
                    Name.setText(userName);
                }
            }

            @Override
            public void onError(Exception exception) {
                // 오류 처리
                Toast.makeText(MainActivity.this, "Error loading user information.", Toast.LENGTH_SHORT).show();
            }
        });


        signOutButton = findViewById(R.id.sign_out_button);
        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });

        // FirebaseDataUploader 인스턴스 초기화
        uploader = new FirebaseDataUploader();

        // XML 레이아웃에 정의된 버튼을 찾습니다.
        Button uploadButton = findViewById(R.id.uploadButton);
        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 데이터 업로드 메소드 호출
                uploader.uploadData();
            }
        });

    }
    private void signOut() {
        mAuth.signOut();  // Firebase에서 로그아웃
        Intent intent = new Intent(MainActivity.this, EmailLoginActivity.class);
        startActivity(intent);  // 로그인 화면으로 이동
        finish();  // 현재 액티비티 종료
    }
}