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

#### @Model, @OnClick Annotation and Form 

###### PersonFormModel.java

```java
    public class PersonFormModel {

        @ModelBind
        private String name;

        @ModelBind
        private int age;

        /* ... */

    }
```

###### activity_main.xml

```xml
    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:paddingBottom="@dimen/activity_vertical_margin"
        android:paddingLeft="@dimen/activity_horizontal_margin"
        android:paddingRight="@dimen/activity_horizontal_margin"
        android:paddingTop="@dimen/activity_vertical_margin"
        android:orientation="vertical"
        tools:context="com.codnect.test_app.MainActivity">

        <com.codnect.go.view.Form
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical"
            app:modelName="personModel"
            app:submit="@id/buttonClick"
            >

            <EditText
                android:id="@+id/editTextPersonName"
                android:layout_width="250dp"
                android:layout_height="wrap_content"
                android:text="Hello World!"
                android:tag="name"/>

            <EditText
                android:id="@+id/editTextPersonAge"
                android:layout_width="250dp"
                android:layout_height="wrap_content"
                android:text="Hello World!"/>

            <Button
                android:id="@+id/buttonClick"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Click!"/>

        </com.codnect.go.view.Form>

    </LinearLayout>
```

###### MainActivity.java
```java
    @LayoutBind(R.layout.activity_main)
    public class MainActivity extends AppCompatActivity {

        @ViewBind(R.id.buttonClick)
        private Button buttonClick;

        @Model("personModel")
        private PersonFormModel personFormModel;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            GoBinder.getInstance().initialize(this);

        }

        @OnClick(value = R.id.buttonClick)
        public void submitPersonForm(){
            /* ... */
        }

    }
```

