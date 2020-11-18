package com.gzeinnumer.rxjava2example;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    TextView tv;

    StringBuilder str = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);

        initRX();
    }

    private void initRX() {
        Observable<String> observaBLE = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Exception {
                str.append("2. Value Default").append("\n");
                setValue();

                emitter.onNext("Hello Zein");
//                emitter.onNext(null); // contoh error
                emitter.onComplete();
            }
        });
        Observer<String> obserVER = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                str.append("1. Loading onSubscribe").append("\n");
                setValue();
            }

            @Override
            public void onNext(@NonNull String s) {
                str.append("3. onNext ").append(s).append("\n");
                setValue();
            }

            @Override
            public void onError(@NonNull Throwable e) {
                str.append("3. onError ").append(e.getMessage()).append("\n");
                setValue();
            }

            @Override
            public void onComplete() {
                str.append("4. Loading onComplete").append("\n");
                setValue();
            }
        };
        observaBLE.subscribe(obserVER);
    }

    private void setValue(){
        tv.setText(str.toString());
    }
}