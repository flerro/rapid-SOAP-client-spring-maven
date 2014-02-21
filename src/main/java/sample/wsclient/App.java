package sample.wsclient;

import com.dataaccess.webservicesserver.NumberConversionSoapType;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigInteger;

/**
 * Sample SOAP webservice invocation
 */
public class App  {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");

        // Get the auto-generated webservice stub
        NumberConversionSoapType service =  (NumberConversionSoapType) ctx.getBean("numberToWordsService");

        // Invoke the service
        String wordsForNumber = service.numberToWords(new BigInteger("1324"));

        System.out.println(wordsForNumber);
    }
}
