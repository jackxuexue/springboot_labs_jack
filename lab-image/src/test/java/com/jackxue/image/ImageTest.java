package com.jackxue.image;

import com.jackxue.ImageIoMain;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.sun.imageio.plugins.png.PNGImageWriter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ImageIoMain.class)
@Slf4j
public class ImageTest {

    @Test
    public void test01(){
        FileOutputStream out = null;
        try {
            BufferedImage bim = ImageIO.read(new File("D:\\test.png"));
            int type = bim.getType();
            int height = bim.getHeight();
            int width = bim.getWidth();
            log.info("图片格式为：{} 宽为：{}px 高为：{}px", type, width, height);

            BufferedImage big = new BufferedImage(width / 2, height / 2, BufferedImage.TYPE_INT_BGR);
            big.getGraphics().drawImage(bim, 0, 0, width/2, height/2, null);
            out = new FileOutputStream("D:\\test.jpg");
            JPEGImageEncoder jie = JPEGCodec.createJPEGEncoder(out);
            jie.encode(big);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
