package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingExtendedController {

        private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

        @RequestMapping("/greetingExtended")
        public GreetingExtended greeting(@RequestParam(value="name", defaultValue="World") String name) {
            if (name != null && name.equalsIgnoreCase("LOOP")) {

            }
            return new GreetingExtended(counter.incrementAndGet(), String.format(template, name), getCurrentTimeUsingCalendar(), getCurrentIp());
        }




    private static String getCurrentTimeUsingCalendar() {
        Calendar cal = Calendar.getInstance();
        Date date=cal.getTime();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String formattedDate=dateFormat.format(date);
        return formattedDate;
        //System.out.println("Current time of the day using Calendar - 24 hour format: "+ formattedDate);
    }

    private static String getCurrentIp() {
        InetAddress ip;
        try {

            ip = InetAddress.getLocalHost();
            String host = ip.getHostAddress();
            return  host;
            // System.out.println("Current IP address : " + ip.getHostAddress());

        } catch (UnknownHostException e) {
            e.printStackTrace();
            return  "oh oh... something is wrong!";
        }
    }


}
