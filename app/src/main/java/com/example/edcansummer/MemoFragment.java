package com.example.edcansummer;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.edcansummer.databinding.FragmentMemoBinding;

public class MemoFragment extends Fragment {

    public static MemoFragment newInstance(){
        return new MemoFragment();
    }

    private ObservableArrayList<MemoModel> items = new ObservableArrayList<>();

    private Context mContext;
    private FragmentMemoBinding binding;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_memo, container, false);

        binding.recyclerMemo.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));

        MemoAdapter adapter = new MemoAdapter();
        binding.recyclerMemo.setAdapter(adapter);

        binding.setItems(items);

        MemoModel model1 = new MemoModel();
        model1.setEamil("");
        model1.setText("텍스트 내용1");
        model1.setTime("대충 시간임1");

        MemoModel model2 = new MemoModel();
        model2.setEamil("");
        model2.setText("텍스트 내용2");
        model2.setTime("대충 시간임2");

        items.add(model1);
        items.add(model2);

        return binding.getRoot();
    }

}
