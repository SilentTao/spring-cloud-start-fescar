import com.silent.auth.core.util.KmpMatchingUtil;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * \* User: silent
 * \* Date: 15/12/18 Time: 16:00
 * \* Description:
 * \
 */
public class StrigMatchingTest extends TestCase {

    private static List<String> patternUrlList = new ArrayList<>();

    static {

        patternUrlList.add("/api/dmap-plan-server/v4/");
        patternUrlList.add("/api/dmap-senor-server/v4/");
        patternUrlList.add("/api/dmap-run-server/v4");
    }

    /**
     * 过滤需要进行token验证的接口
     * 采用kmp算法来是否需要token验证
     * kmp 在高并发下的效率高于正则匹配
     *
     * @return
     */
    private static boolean isTokenCheck(String url) {

        for (String child : patternUrlList) {
            Pattern p = Pattern.compile(child);
            Matcher m = p.matcher(url);
            if (m.find()) {
                return true;
            }
        }

        return false;
    }
    private static boolean isKmpTokenCheck(String url) {
        for (String child : patternUrlList) {
            int is = KmpMatchingUtil.kmp(url, child);
            if (is >= 0) {
                return true;
            }
        }
        return false;

    }

    @Test
    public static void main(String args[]) {
        long patternStartTime = System.currentTimeMillis();
        for (int i = 0; i < 2000; i++) {
            isTokenCheck("/api/dmap-plan-server/v4/adfasfsadfasdfsdasdfasdfasdfasdfasd");
        }

        long patternEndTime = System.currentTimeMillis();
        System.out.println("正则表达式耗时:" + (patternEndTime - patternStartTime));

        long kmpStartTime = System.currentTimeMillis();
        for (int i = 0; i < 12000; i++) {
            isKmpTokenCheck("/api/dmap-plan-server/v4/adfasfsadfasdfsdasdfasdfasdfasdfasd");
        }

        long kmpEndTime = System.currentTimeMillis();
        System.out.println("KMP耗时:" + (kmpEndTime - kmpStartTime));
    }

}
