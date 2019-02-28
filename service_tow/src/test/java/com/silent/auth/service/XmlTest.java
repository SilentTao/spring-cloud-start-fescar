package com.silent.auth.service;

import com.dmap.base.units.HttpClientBase;
import junit.framework.TestCase;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
//import org.dom4j.Attribute;
//import org.dom4j.Document;
//import org.dom4j.DocumentHelper;
//import org.dom4j.Element;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.MessageFormat;

/**
 * \* User: silent
 * \* Date: 26/02/18 Time: 16:32
 * \* Description:
 * \
 */
public class XmlTest extends TestCase {
    private static final String appPakage = "com.pmpd.dmap.lenovo";
    private static String getAccountUrl = "http://passport.lenovo.com/interserver/authen/1.2/getaccountid?lpsust={0}&realm={1}";
    private static String getAccountUrl_test = "http://192.168.1.10:9999/interserver/authen/1.2/getaccountid?lpsust={0}&realm={1}";


    private static void Test(String lenovoToken) {
        String url = MessageFormat.format(getAccountUrl_test, lenovoToken, appPakage);
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("Content-Type", "*/*");
        httpGet.setHeader("Pragma", "no-cache");
        httpGet.setHeader("Cache-Control", "no-cache");
        HttpResponse response = HttpClientBase.getHtml(httpGet);
        String responseString = null;
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_NOT_ACCEPTABLE) {
            HttpEntity entity = response.getEntity();
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent(), "UTF-8"));
                StringBuilder stringBuffer = new StringBuilder();
                stringBuffer.append("<");
                String str = "";
                while ((str = br.readLine()) != null) {
                    stringBuffer.append(str);
                }
                responseString = stringBuffer.toString();

            } catch (Exception e) {
                System.out.println(e);
            }

        }
//        Document document = null;
//        try {
//            document = DocumentHelper.parseText(responseString);
//            Element element = document.getRootElement();
//            List<Attribute> attributes = element.attributes();
//            for (Attribute attr : attributes) {
//                System.out.println(attr.getText() + "------" + attr.getName() + "-------" + attr.getValue());
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
    }

    public static void main(String[] args) {
        Test("ZAgAAAAAAAGE9MTAwMDM1NTA4MDMmYj0yJmM9NCZkPTExJmU9RTZGM0EzMTY5RjAwQTM2QzE4MzNERDM4QzhCQkU0QzkxJmg9MTM3MjkxMDg2NDI3NSZpPTQzMjAwJm89MDAwMDAwMDAwMDAwMDAwJnA9aW1laSZxPTExMTExMSZ1c2VybmFtZT0xMzgxMDUzNTg4N6z979s5fL06DibrT5d7D6s=");
    }

    public void testApp()
    {
        assertTrue( true );
    }
}
