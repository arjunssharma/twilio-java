import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class TwilioSmsSample {
	public static final String ACCOUNT_SID = "ACaf1cf0000bab2129b223d7a280e41ffc";
	public static final String AUTH_TOKEN = "df21d6d650e36cc83eb2f5be9a2e8207";

	public static final String TWILIO_NUMBER = "+14084189318";

	public static void main(String[] args) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		Message message = Message.creator(new PhoneNumber("+917738654834"), new PhoneNumber(TWILIO_NUMBER),
				"Sample SMS using Twilio API sent by Arjun").create();
		System.out.println(message.getStatus());
	}
}