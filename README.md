# RxJava2Example
 
- Source
  - [Part 1](https://medium.com/nusanet/pengenalan-rxjava-untuk-pemula-bagian-1-2c9895a73c70)
  - [Part 2](https://medium.com/nusanet/pengenalan-rxjava-untuk-pemula-bagian-2-29b843853cd6)

- Implementation
```gradle
implementation 'io.reactivex.rxjava2:rxandroid:2.1.1'
implementation 'io.reactivex.rxjava2:rxjava:2.2.9'
```

- Example 1
```java
StringBuilder str = new StringBuilder();

Observable<String> observaBLE = Observable.create(new ObservableOnSubscribe<String>() {
    @Override
    public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Exception {
        str.append("2. Value Default").append("\n");
        setView();

        emitter.onNext("Hello Zein");
//      emitter.onNext(null); // contoh error
        emitter.onComplete();
    }
});
Observer<String> obserVER = new Observer<String>() {
    @Override
    public void onSubscribe(@NonNull Disposable d) {
        str.append("1. Loading onSubscribe").append("\n");
        setView();
    }

    @Override
    public void onNext(@NonNull String s) {
        str.append("3. onNext ").append(s).append("\n");
        setView();
    }

    @Override
    public void onError(@NonNull Throwable e) {
        str.append("3. onError ").append(e.getMessage()).append("\n");
        setView();
    }

    @Override
    public void onComplete() {
        str.append("4. Loading onComplete").append("\n");
        setView();
    }
};
observaBLE.subscribe(obserVER);
```

- Example 2
```java
StringBuilder str = new StringBuilder();

Observable.create(new ObservableOnSubscribe<String>() {
    @Override
    public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Exception {
        str.append("2. Value Default").append("\n");
        setView();

        emitter.onNext("Hello Zein");
//      emitter.onNext(null); // contoh error
        emitter.onComplete();
    }
}).subscribe(new Observer<String>() {
    @Override
    public void onSubscribe(@NonNull Disposable d) {
        str.append("1. Loading onSubscribe").append("\n");
        setView();
    }

    @Override
    public void onNext(@NonNull String s) {
        str.append("3. onNext ").append(s).append("\n");
        setView();
    }

    @Override
    public void onError(@NonNull Throwable e) {
        str.append("3. onError ").append(e.getMessage()).append("\n");
        setView();
    }

    @Override
    public void onComplete() {
        str.append("4. Loading onComplete").append("\n");
        setView();
    }
});
```

- `setview();`
```java
private void setView(){
    TextView tv= findViewById(R.id.tv);
    tv.setText(str.toString());
}
```

- Preview

<p align="center">
  <img src="https://github.com/gzeinnumer/RxJava2Example/blob/master/preview/example1.jpg" width="400"/>
</p>

---

**FullCode [MainActivity](https://github.com/gzeinnumer/RxJava2Example/blob/master/app/src/main/java/com/gzeinnumer/rxjava2example/MainActivity.java)**

---

```
Copyright 2020 M. Fadli Zein
```