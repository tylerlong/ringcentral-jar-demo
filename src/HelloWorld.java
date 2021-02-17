import com.ringcentral.RestClient;
import com.ringcentral.RestException;

import java.io.IOException;


// https://bintray.com/tylerlong/maven/ringcentral/1.6.1#files
// https://bintray.com/bintray/jcenter/org.jetbrains.kotlin%3Akotlin-stdlib/1.3.50#files
// https://bintray.com/bintray/jcenter/com.google.code.gson%3Agson/2.8.6#files
// https://bintray.com/bintray/jcenter/com.squareup.okhttp3%3Aokhttp/3.14.2#files
// https://bintray.com/bintray/jcenter/com.squareup.okio%3Aokio/1.17.2#files


public class HelloWorld {
    public static void main(String[] args) throws IOException, RestException {
        System.out.println("Hello world");

        RestClient rc = new RestClient(
                System.getenv("RINGCENTRAL_CLIENT_ID"),
                System.getenv("RINGCENTRAL_CLIENT_SECRET"),
                System.getenv("RINGCENTRAL_SERVER_URL")
        );

        rc.authorize(
                System.getenv("RINGCENTRAL_USERNAME"),
                System.getenv("RINGCENTRAL_EXTENSION"),
                System.getenv("RINGCENTRAL_PASSWORD")
        );

        var extInfo = rc.restapi().account().extension().get();
        System.out.println(extInfo.extensionNumber);

        rc.revoke();
    }
}
