package Services;

import Exceptions.ApplicationException;
import Helpers.Constants;
import Helpers.Runner;

import java.io.IOException;
import java.util.Map;

public class EditTime extends Service {

    public EditTime(Runner r) {
        super(r);
        service_id = Constants.EDIT_TIME_ID;
    }

    /** Perform the service
     * This basic method (shared by Write, Trim, and Clear) can be overridden for more involved services (Monitor, Write)
     * @throws IOException send/receive message
     */
    @Override
    public void act() throws IOException {
        //ask for user input
        String[] request_values = get_user_request_values();
        try{
            Map<String, Object> reply = send_and_receive(request_values);
            System.out.println((int) reply.get("time"));
            System.out.println("Done.");
        }
        catch(ApplicationException ae) {
            System.out.println("Error: " + ae.getMessage() + ".");
        }
    }
}