package Twilo;

import com.FloodDetection.Dao.ResidentDao;
import com.FloodDetection.bean.ResidentBean;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.util.ArrayList;

/**
 *
 * @author sujan boudel
 */
public class SendBroadcast {

    public static final String ACCOUNT_SID = "ACf71033e590929c73c4a9e5140d68bb54";
    public static final String AUTH_TOKEN = "049365d63da4b79902eaa6a74feb45cb";

    public static void main(String[] args) {

        ResidentDao rd = new ResidentDao();
        ArrayList<ResidentBean> rb = rd.getAllRecords();
        String level1message = "\n Water level at 1 ! \n Stay Alert!";
        String level2message = "\n Water level at 2! \n Be prepared to leave!";
        String level3message = "\n Water level at 3! \n Danger Evacuate to safer place!";
        String fromPhonenumber = "+1 844 991 2021";
//        String toPhonenumber = "+61426963667";
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        for (ResidentBean b : rb) {
            Message message;
            message = Message.creator(
                    new com.twilio.type.PhoneNumber(b.getPhone()),
                    new com.twilio.type.PhoneNumber(fromPhonenumber),
                    level1message)
                    .create();
        }

        // System.out.println(message.getSid());
    }
}
