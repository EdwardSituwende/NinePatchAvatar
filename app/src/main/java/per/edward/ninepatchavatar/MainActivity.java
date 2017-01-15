package per.edward.ninepatchavatar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;

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
