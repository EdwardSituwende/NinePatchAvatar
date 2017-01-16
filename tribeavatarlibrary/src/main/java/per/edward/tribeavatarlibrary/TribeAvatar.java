package per.edward.tribeavatarlibrary;

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
     * 设置只有三张图片的位置
     *
     * @param i
     * @param imgWidth
     * @param left
     * @param top
     * @param right
     * @param bottom
     */
    private void setThreePicPosition(int i, int imgWidth, int left, int top, int right, int bottom) {
        View view = getChildAt(i - 1);
        //对第一张图片进行特殊处理
        if (i == 1) {
            view.layout(imgWidth / 2, 0, imgWidth + (imgWidth / 2), imgWidth);
            //换行
            row++;
            column = 0;
        } else {
            view.layout(left, top, right, bottom);
            column++;
        }
    }

    /**
     * 设置只有五张图片的位置
     *
     * @param i
     * @param imgWidth
     * @param childCount
     * @param left
     * @param top
     * @param right
     * @param bottom
     */
    private void setFivePicPosition(int i, int imgWidth, int childCount, int left, int top, int right, int bottom) {
        View view = getChildAt(i - 1);
        //设置垂直居中
        int centerVertical = setVertical(childCount, imgWidth);
        //头两张图片进行特殊处理
        if (i == 1 || i == 2) {
            //设置水平居中
            int centerHorizontal = imgWidth / 2;
            view.layout(left + centerHorizontal, top + centerVertical, right + centerHorizontal, bottom + centerVertical);
            column++;
            if (i == 2) {
                row++;
                column = 0;
            }
        } else {
            view.layout(left, top + centerVertical, right, bottom + centerVertical);
            column++;
        }
    }

    private void setOthersPicPosition(int i, int imgWidth, int columnMax, int childCount, int left, int top, int right, int bottom) {
        View view = getChildAt(i - 1);
        //设置垂直居中，返回0表示不需要垂直居中
        int centerVertical = setVertical(childCount, imgWidth);
        view.layout(left, top + centerVertical, right, bottom + centerVertical);
        column++;
        //换行
        if (i % columnMax == 0) {
            row++;
            //将列增量初始化
            column = 0;
        }
    }

    int row, column;

    /**
     * 摆放图片
     *
     * @param childCount 子控件总数
     * @param columnMax  头像每列的最大数
     */
    private void putImg(int childCount, int columnMax) {
        //注意头像的宽度和高度是相等的，下面的imgHeight被我注释了
        int imgWidth = getWidth() / columnMax;
//        int imgHeight = getHeight() / columnMax;

        //每行增量
        row = 0;
        //每列增量
        column = 0;
        for (int i = 1; i <= childCount; i++) {
            //计算左上角坐标
            int left = imgWidth * column;
            int top = imgWidth * row;
            //计算右下角坐标
            int right = imgWidth + left;
            int bottom = imgWidth + top;

            switch (childCount) {
                //针对只有三张图片的情况进行特殊处理
                case 3:
                    setThreePicPosition(i, imgWidth, left, top, right, bottom);
                    break;
                //针对只有五张图片的情况进行特殊处理
                case 5:
                    setFivePicPosition(i, imgWidth, childCount, left, top, right, bottom);
                    break;
                //其余情况走下面
                default:
                    setOthersPicPosition(i, imgWidth, columnMax, childCount, left, top, right, bottom);

                    //当只有7张图片，则对第7张图片进行特殊处理
                    if (childCount == 7 && i == 7) {
                        View view = getChildAt(i - 1);
                        //对最后一格的图片进行特殊处理
                        view.layout(imgWidth, imgWidth * 2, 2 * imgWidth, imgWidth + (imgWidth * 2));
                    }
                    break;
            }
        }
    }
}
