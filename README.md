# GO Project

#### @OnClick Annotation

```java

    private Button buttonClick;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        buttonClick = (Button) findViewById(R.id.buttonClick);
        buttonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* ... */
            }
        });
    }
    
```

```java

    @ViewBind(R.id.buttonClick)
    private Button buttonClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GoBinder.getInstance().initilaze(this);
    }

    @OnClick(value = R.id.buttonClick)
    public void clickButton(){
        /* ... */
    }
    
```
