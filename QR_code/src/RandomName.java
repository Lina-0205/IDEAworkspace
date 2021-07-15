import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
/**
 * @Auther: Lina Wen
 * @Date: 2021/7/6 - 07 - 06 - 21:43
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class RandomName {
    public String getRandomFileName() {

        SimpleDateFormat simpleDateFormat;

        simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

        Date date = new Date();

        String str = simpleDateFormat.format(date);

        Random random = new Random();

        int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数

        return  str+"_"+ rannum;// 当前时间
    }

}
