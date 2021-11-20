package advance;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;

public class FishDrawer{
    void run() throws InterruptedException{
        // 400 x 400 のウィンドウを開く．
        EZ.initialize(400, 400);

        // 画面の更新頻度を 300 ms にする．
        EZ.setFrameRate(300);

        Random random = new Random();
        Point point = new Point();
        point.x = 100;
        point.y = 200;
        Integer dx = -10;
        Integer dy = 10;

        while(true){
            point.x += dx;
            point.y += dy;
            dy = (10 - random.nextInt(20));

            if(point.x > 400){
                dx = -10;
            }
            if(point.x < 0){
                dx = 10;
            }
            if(point.y < 0){
                point.y += dy;
            }
            if(point.y > 400){
                point.y -= dy;
            }

            // (x, y)を中心に魚を描く．
            if(dx == -10) drawFish(point.x, point.y, 30);
            else if(dx == 10) drawFishR(point.x, point.y , 30);

            Thread.sleep(300);
            EZ.removeAllEZElements();
        }
    }
    void drawFish(Integer x, Integer y, Integer size){
        Color color = Color.RED;
        Color background = Color.WHITE;
        // 顔の描画
        EZ.addCircle(x, y, size * 2, size * 2, color, true);

        // 口の描画
        Integer divx = Double.valueOf(size * Math.cos(Math.PI / 4)).intValue();
        Integer divy = Double.valueOf(size * Math.sin(Math.PI / 4)).intValue();
        Integer[] xp = { x, x - divx, x - divx * 2, x - divx, };
        Integer[] yp = { y, y - divy, y,            y + divy, };
        EZ.addPolygon(xp, yp, background, true);

        // 目の描画
        EZ.addCircle(x + (size / 2), y - (size / 3), size / 2, size / 2, background, true);

        // 胴体の描画
        EZ.addLine(x, y, x + (size * 3), y, color, 1);
        Integer distance = size * 2 / 6;
        for(Integer i = 0; i < 5; i++){
            Integer xx = x + size + distance * (i + 1);
            EZ.addLine(xx, y - size / 2, xx, y + size / 2, color, 1);
        }

        // 尻尾の描画
        EZ.addLine(x + (size * 3), y, x + (size * 4), y + size, color, 1);
        EZ.addLine(x + (size * 3), y, x + (size * 4), y - size, color, 1);
    }
    void drawFishR(Integer x, Integer y, Integer size){
        Color color = Color.BLUE;
        Color background = Color.WHITE;
        // 顔の描画
        EZ.addCircle(x, y, size * 2, size * 2, color, true);

        // 口の描画
        Integer divx = Double.valueOf(size * Math.cos(Math.PI / 4)).intValue();
        Integer divy = Double.valueOf(size * Math.sin(Math.PI / 4)).intValue();
        Integer[] xp = { x, x + divx, x + divx * 2, x + divx, };
        Integer[] yp = { y, y - divy, y,            y + divy, };
        EZ.addPolygon(xp, yp, background, true);

        // 目の描画
        EZ.addCircle(x - (size / 2), y - (size / 3), size / 2, size / 2, background, true);

        // 胴体の描画
        EZ.addLine(x, y, x - (size * 3), y, color, 1);
        Integer distance = size * 2 / 6;
        for(Integer i = 0; i < 5; i++){
            Integer xx = x - size - distance * (i + 1);
            EZ.addLine(xx, y - size / 2, xx, y + size / 2, color, 1);
        }

        // 尻尾の描画
        EZ.addLine(x - (size * 3), y, x - (size * 4), y + size, color, 1);
        EZ.addLine(x - (size * 3), y, x - (size * 4), y - size, color, 1);
    }
    public static void main(String[] args) throws InterruptedException{
        FishDrawer drawer = new FishDrawer();
        drawer.run();
    }
}
