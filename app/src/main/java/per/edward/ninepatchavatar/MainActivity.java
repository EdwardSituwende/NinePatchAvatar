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

        simpleDraweeViewOne.setImageURI("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3083693965,3642567609&fm=116&gp=0.jpg");
        simpleDraweeViewTwo.setImageURI("http://img3.imgtn.bdimg.com/it/u=438871314,2276270985&fm=23&gp=0.jpg");
        simpleDraweeViewThree.setImageURI("http://img5.imgtn.bdimg.com/it/u=1122938447,2979833550&fm=23&gp=0.jpg");
    }
}
