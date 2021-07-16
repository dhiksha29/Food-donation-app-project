package com.example.bot.activity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import androidx.recyclerview.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bot.R;
import com.example.bot.adapter.MessageAdapter;
import com.example.bot.model.ResponseMessage;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText userInput;
    RecyclerView recyclerView;
    MessageAdapter messageAdapter;
    List<ResponseMessage> responseMessageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        userInput = findViewById(R.id.userInput);
        recyclerView = findViewById(R.id.conversation);
        responseMessageList = new ArrayList<>();
        messageAdapter = new MessageAdapter(responseMessageList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
       recyclerView.setAdapter(messageAdapter);
        ResponseMessage responseMessage4 = new ResponseMessage("Thank you for filling up the information and being a helpful hand.".toString(), false);
        responseMessageList.add(responseMessage4);
        ResponseMessage responseMessage3 = new ResponseMessage("I am Foodie your virtual assistant here to guide you with food divilery process.".toString(), false);
        responseMessageList.add(responseMessage3);


        userInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override

            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_SEND) {

                    if(userInput.getText().toString().toLowerCase().contains("hi"))
                    {ResponseMessage responseMessage = new ResponseMessage(userInput.getText().toString(), true);
                        responseMessageList.add(responseMessage);
                        ResponseMessage responseMessage5 = new ResponseMessage("Hello".toString(), false);
                        responseMessageList.add(responseMessage5);
                        userInput.setText("");
                    }
                    else if(userInput.getText().toString().toLowerCase().contains("time")){
                        Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy   HH:mm");
                        String date = sdf.format((Date)(new java.sql.Date(timeStamp.getTime())));
                        ResponseMessage responseMessage = new ResponseMessage(userInput.getText().toString(), true);
                        responseMessageList.add(responseMessage);
                        ResponseMessage responseMessage7 = new ResponseMessage(date.toString(), false);
                        responseMessageList.add(responseMessage7);
                        userInput.setText("");
                    }
                    else if(userInput.getText().toString().toLowerCase().contains("how are you"))
                    {ResponseMessage responseMessage = new ResponseMessage(userInput.getText().toString(), true);
                        responseMessageList.add(responseMessage);
                        ResponseMessage responseMessage6 = new ResponseMessage("Pretty good! How about you?".toString(), false);
                        responseMessageList.add(responseMessage6);
                        userInput.setText("");
                    }
                    else if(userInput.getText().toString().toLowerCase().contains("open" ) && userInput.getText().toString().toLowerCase().contains("google" )){

                          Intent  site = new Intent("android.intent.action.VIEW");
                            site.setData(Uri.parse("https://www.google.com/"));
                            MainActivity.this.startActivity(site);

                        ResponseMessage responseMessage = new ResponseMessage(userInput.getText().toString(), true);
                        responseMessageList.add(responseMessage);
                        ResponseMessage responseMessage8= new ResponseMessage("Opening Google...", false);
                        responseMessageList.add(responseMessage8);
                        userInput.setText("");
                    }
                    else
                    {ResponseMessage responseMessage = new ResponseMessage(userInput.getText().toString(), true);
                    responseMessageList.add(responseMessage);
                    ResponseMessage responseMessage2 = new ResponseMessage("Im still learning".toString(), false);
                        userInput.setText("");
                    responseMessageList.add(responseMessage2);
                    messageAdapter.notifyDataSetChanged();
                    if (!isLastVisible())
                        recyclerView.smoothScrollToPosition(messageAdapter.getItemCount() - 1);}
                }
                return false;
            }
        });
    }
    boolean isLastVisible() {
        LinearLayoutManager layoutManager = ((LinearLayoutManager) recyclerView.getLayoutManager());
        int pos = layoutManager.findLastCompletelyVisibleItemPosition();
        int numItems = recyclerView.getAdapter().getItemCount();
        return (pos >= numItems);
    }
}