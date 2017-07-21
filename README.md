# GO Project

#### @OnClick and @ViewBind Annotation

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
        setContentView(R.layout.activity_main);
        
        GoBinder.getInstance().initialize(this);
    }

    @OnClick(value = R.id.buttonClick)
    public void clickButton(){
        /* ... */
    }
    
```

#### @LayoutBind Annotation

```java

    public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }
        
    }
    
```

```java

    @LayoutBind(R.layout.activity_main)
    public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            GoBinder.getInstance().initialize(this);
        }
        
    }
    
```
