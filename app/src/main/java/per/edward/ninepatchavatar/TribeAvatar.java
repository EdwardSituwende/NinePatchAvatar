package per.edward.ninepatchavatar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * 群聊九宫格头像
 * Created by Edward on 2017/1/15.
 */

public class TribeAvatar extends ViewGroup {

    public TribeAvatar(Context context, AttributeSet attrs) throws Exception {
        this(context, attrs, 0);
    }

    public TribeAvatar(Context context, AttributeSet attrs, int defStyleAttr) throws Exception {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //强制容器宽度和高度一致
        setMeasuredDimension(widthMeasureSpec, widthMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        //五张图片之后（包含5张），每行的最大列数是3
        if (childCount >= 5) {
            putImg(childCount, 3);
        } else {
            putImg(childCount, 2);
        }
    }

    /**
     * 设置垂直
     *
     * @param childCount
     * @param imgWidth
     * @return
     */
    private int setVertical(int childCount, int imgWidth) {
        //只有5张或者6张图的情况才需要垂直居中
        if (childCount == 5 || childCount == 6) {
            return imgWidth / 2;
        } else {
            return 0;
        }
    }

    /**
     * 摆放图片
     *
     * @param childCount 子控件总数
     * @param columnMax  头像每列的最大数
     */
    private void putImg(int childCount, int columnMax) {
        int imgWidth = getWidth() / columnMax;
        int imgHeight = getHeight() / columnMax;
        //每行增量
        int row = 0;
        //每列增量
        int column = 0;
        for (int i = 1; i <= childCount; i++) {
            View view = getChildAt(i - 1);

            //设置垂直居中
            int centerVertical = setVertical(childCount, imgWidth);

            int left = imgWidth * column;
            int top = ((imgWidth) * row) + centerVertical;
            int right = imgWidth + (imgWidth * column);
            int bottom = (imgWidth + (imgWidth * row)) + centerVertical;

            switch (childCount) {
                case 3:
                    //对第一张图片进行特殊处理
                    if (i == 1) {
                        view.layout(imgWidth / 2, 0, imgWidth + (imgWidth / 2), imgHeight);
                        //换行
                        row++;
                        column = 0;
                    } else {
                        view.layout(left, top, right, bottom);
                        column++;
                    }
                    break;
                case 5:
                    //头两张图片进行特殊处理
                    if (i == 1 || i == 2) {
                        //设置水平居中
                        int centerHorizontal = imgWidth / 2;
                        view.layout(left + centerHorizontal, top, right + centerHorizontal, bottom);
                        column++;
                        if (i == 2) {
                            row++;
                            column = 0;
                        }
                    } else {
                        view.layout(left, top, right, bottom);
                        column++;
                    }
                    break;
                default:
                    view.layout(left, top, right, bottom);
                    column++;
                    //换行
                    if (i % columnMax == 0) {
                        row++;
                        //将列增量初始化
                        column = 0;
                    }
                    //当只有7张图片，则对第7张图片进行特殊处理
                    if (childCount == 7 && i == 7) {
                        //对最后一格的图片进行特殊处理
                        view.layout(imgWidth, imgWidth * 2, 2 * imgWidth, imgWidth + (imgWidth * 2));
                    }
                    break;
            }
        }
    }
}
