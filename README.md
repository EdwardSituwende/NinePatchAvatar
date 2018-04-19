## Android自定义控件---仿微信群聊(九宫格)头像
</br>
### 博客http://blog.csdn.net/u012814441

### Demo效果图如下</br>
![image](https://github.com/EdwardSituwende/NinePatchAvatar/blob/master/img/abc123.jpg?raw=true)</br>
### 使用方法
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/activity_main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#ffffff"
    android:orientation="vertical">

        <per.edward.ninepatchavatar.TribeAvatar
            android:layout_width="100dp"
            android:layout_height="100dp"
            android:layout_margin="10dp"
            android:background="#F5F5F5">

            <com.facebook.drawee.view.SimpleDraweeView
                android:id="@+id/img_one"
                android:layout_width="30dp"
                android:layout_height="30dp"
                app:placeholderImage="@mipmap/ic_launcher" />

            <com.facebook.drawee.view.SimpleDraweeView
                android:id="@+id/img_two"
                android:layout_width="30dp"
                android:layout_height="30dp"
                app:placeholderImage="@mipmap/ic_launcher" />

            <com.facebook.drawee.view.SimpleDraweeView
                android:id="@+id/img_three"
                android:layout_width="30dp"
                android:layout_height="30dp"
                app:placeholderImage="@mipmap/ic_launcher" />

        </per.edward.ninepatchavatar.TribeAvatar>
</LinearLayout>

```
关于TribeAvatar的注意事项</br>
1、在设置TribeAvatar宽度(layout_width)的时候必须给一个精确值例如
match_parent或者xxxdp，绝对不能设置
wrap_content。高度的话可以随便设置。因为最终的高度会和宽度一致。</br>
2、子控件不能少于3个并且不能多于9个。否则图片会显示不出来。</br>
3、子控件的宽度和高度可以随便设置，因为其宽度和高度最终都会由父控件TribeAvatar来决定。</br>
```
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SimpleDraweeView simpleDraweeViewOne = (SimpleDraweeView) findViewById(R.id.img_one);
        SimpleDraweeView simpleDraweeViewTwo = (SimpleDraweeView) findViewById(R.id.img_two);
        SimpleDraweeView simpleDraweeViewThree = (SimpleDraweeView) findViewById(R.id.img_three);

        simpleDraweeViewOne.setImageURI("https://github.com/EdwardSituwende/NinePatchAvatar/blob/master/img/111.jpg?raw=true");
        simpleDraweeViewTwo.setImageURI("https://github.com/EdwardSituwende/NinePatchAvatar/blob/master/img/222.jpg?raw=true");
        simpleDraweeViewThree.setImageURI("https://github.com/EdwardSituwende/NinePatchAvatar/blob/master/img/333.jpg?raw=true");
    }
}
```