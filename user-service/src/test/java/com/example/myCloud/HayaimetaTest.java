package com.example.myCloud;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Yan Jiale
 * @since 2023/07/04 11:02
 */
public class HayaimetaTest {

    @Test
    public void test(){
        try {
            FileInputStream fis = new FileInputStream("/Users/xmly/myCloud/user-service/src/test/java/com/example/myCloud/test.hayaimeta");

            int byteRead;
            while ((byteRead = fis.read()) != -1) {

                System.out.print((char) byteRead+ " ");
                if ((char)byteRead == '\n'){
                    break;
                }
            }

            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
