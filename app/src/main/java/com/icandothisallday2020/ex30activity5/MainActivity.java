package com.icandothisallday2020.ex30activity5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    //p.s Android System Intent -> 구글링
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //Android System App 실행 ex)전화걸기앱, 사진앱 등등..
    //  └※지정된 intent action 값을 가지고 있음
    // ∴ 묵시적 intent 를 통해  지정된 action 의 앱을 실행
    public void clickDial(View view) {
        //전화-다이얼화면 앱 실행
        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        //다이얼앱의 약속된 action 문자열 값↑

        //다이얼 화면에 이미 전화번호가 입력되어 있도록 설정
        Uri uri=Uri.parse("tel:01012345678");//parse(주소):주소를 분석하다
        //└Url- 상위개념 모든 주소값/tel:전화번호로 분석
        intent.setData(uri);
        startActivity(intent);
    }
    public void clickSMS(View view) {//Short Message Service
        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_SENDTO);
        Uri uri=Uri.parse("smsto:01012345678,01087654321");
        intent.setData(uri);
        //문자내용 미리 작성(추가적 Data)
        intent.putExtra("sms_body","hi");
        //                      └약속된 식별자(변경 X)
        startActivity(intent);
    }
    public void clickWeb(View view) {//show web page
        //파라미터로 액션값,데이터값 생성자에서 지정 가능
        startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.naver.com")));
    }
    public void clickGallery(View view) {
        //사진선택 앱
        Intent intent=new Intent(Intent.ACTION_PICK);
        //반드시 추가해야할 설정(미디어파일-이미지,오디오,비디오 중 택 1)
        intent.setType("image/png");//image/* ->모든 확장자 이미지파일
        startActivity(intent);
    }
    public void clickCamera(View view) {
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);
    }
}
