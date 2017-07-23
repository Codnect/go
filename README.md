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

#### @Form, @FormField and @OnClick Annotation

```java
@LayoutBind(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewBind(R.id.buttonClick)
    private Button buttonClick;

    @ViewBind(R.id.editTextMessage)
    private EditText editTextMessage;

    @ViewBind(R.id.checkBox)
    private CheckBox checkBox;

    @Form(
            name = "form",
            fields = {
                    @FormField(name = "message", id = R.id.editTextMessage),
                    @FormField(name = "check", id = R.id.checkBox)
            }
    )
    private ModelForm modelForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GoBinder.getInstance().initilaze(this);
    }

    @OnClick(value = R.id.buttonClick, formName = "form")
    public void clickButton(){
        /* ... */
    }

}
```
