package com.example.edcansummer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.Toast;

import com.example.edcansummer.databinding.ActivityNewMemoBinding;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class NewMemoActivity extends AppCompatActivity {

    private FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    private ActivityNewMemoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_new_memo);
        binding.setMemo(getIntent().getStringExtra("memo_text"));
        binding.setIsEdit(getIntent().getBooleanExtra("is_edit", false));

        binding.toolbarNewMemo.setNavigationOnClickListener(view -> finish());
        binding.btnNewMemoUpload.setOnClickListener(view -> {
            if (binding.getMemo().isEmpty()) {
                Toast.makeText(this, "메모를 입력해주세요", Toast.LENGTH_SHORT).show();
                return;
            }
            MemoModel model = new MemoModel();
            model.setEamil(UserCache.getUser(this).getEmail());
            model.setText(binding.getMemo());
            model.setTime(getTime());

            if (!getIntent().getBooleanExtra("is_edit", false)) {
                firebaseFirestore
                        .collection("memo")
                        .document()
                        .set(model)
                        .addOnSuccessListener(runnable -> {
                            Toast.makeText(this, "메모가 정상적으로 등록되었습니다", Toast.LENGTH_SHORT).show();
                            finish();
                        })
                        .addOnFailureListener(e -> Toast.makeText(this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show());
            } else {
                Toast.makeText(this, "잉 수정은 안돼용...", Toast.LENGTH_SHORT).show();
            }

        });
    }

    private String getTime() {
        return new SimpleDateFormat("yyyy/MM/dd hh:mm aa", Locale.ENGLISH).format(new Date());
    }
}