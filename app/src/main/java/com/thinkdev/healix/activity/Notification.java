package com.thinkdev.healix.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.thinkdev.healix.R;
import com.thinkdev.healix.adapter.NotificationsAdapter;
import com.thinkdev.healix.databinding.ActivityNotificationBinding;
import com.thinkdev.healix.model.NotificationChildModel;
import com.thinkdev.healix.model.NotificationParentModel;

import java.util.ArrayList;
import java.util.List;

public class Notification extends AppCompatActivity {

    private ActivityNotificationBinding binding;
    private NotificationsAdapter notificationsAdapter;
    RecyclerView notificationRecycler;
    RadioGroup notificationRadioGroupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNotificationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        notificationRecycler = findViewById(R.id.notificationRecycler);

        notificationRadioGroupBtn =findViewById(R.id.notificationsRadioGroupBtn);

        final int checkedColor = ContextCompat.getColor(getApplicationContext() ,R.color.white);
        final int uncheckedColor = ContextCompat.getColor(getApplicationContext(), R.color.blue);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        notificationsAdapter = new NotificationsAdapter(NotificationItemList());
        notificationRecycler.setAdapter(notificationsAdapter);
        notificationRecycler.setLayoutManager(linearLayoutManager);
        notificationRadioGroupBtn.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int count = group.getChildCount();
                for (int i = 0; i < count; i++){
                    RadioButton radioButton = (RadioButton) group.getChildAt(i);
                    if (radioButton.getId() == checkedId){
                        Toast.makeText(getApplicationContext(), radioButton.getText() + " clicked", Toast.LENGTH_SHORT).show();
                        radioButton.setTextColor(checkedColor);
                    } else {
                        radioButton.setTextColor(uncheckedColor);
                    }
                }
            }
        });
    }

    private List<NotificationParentModel> NotificationItemList() {
        List<NotificationParentModel> parentModels = new ArrayList<>();

        NotificationParentModel notificationParentModel = new NotificationParentModel("29", "Thursday", "June", NotificationChildList());
        parentModels.add(notificationParentModel);

        return parentModels;
    }

    private List<NotificationChildModel> NotificationChildList() {
        List<NotificationChildModel> childModels = new ArrayList<>();

        childModels.add(new NotificationChildModel("AAR", "#INV633473849 status updated to approved.", "01:25 PM", R.drawable.aar));
        childModels.add(new NotificationChildModel("#S746839", "New service added to #INV665773849.", "01:25 PM", R.drawable.service_icon));
        childModels.add(new NotificationChildModel("MADISON", "#INV633534849 status updated to approved.", "01:25 PM", R.drawable.aar));
        childModels.add(new NotificationChildModel("SANLAM", "#INV633473849 status updated to approved.", "01:25 PM", R.drawable.sanlam));
        childModels.add(new NotificationChildModel("#S746864", "New service added to  #INV633473849.", "01:25 PM", R.drawable.service_icon));
        childModels.add(new NotificationChildModel("AAR", "#INV633473849 status updated to approved.", "01:25 PM", R.drawable.aar));

        return childModels;
    }

    public void onBackIconClicked(View view) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}