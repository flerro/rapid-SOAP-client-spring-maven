package sample.wsclient.handler;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.io.ByteArrayOutputStream;
import java.util.Collections;
import java.util.Set;

/**
 * A simple handler to dump SOAP payload to System.out
 */
public class SoapPayloadDumper implements SOAPHandler<SOAPMessageContext> {

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        dump(context);
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        dump(context);
        return true;
    }

    @Override
    public void close(MessageContext context) {
        // NOOP
    }

    @Override
    public Set<QName> getHeaders() {
        return Collections.emptySet();
    }


    private void dump(SOAPMessageContext smc) {
        Boolean outboundProperty = (Boolean) smc.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        if (outboundProperty.booleanValue()) {
            System.out.println("\nOutbound message:");
        } else {
            System.out.println("\nInbound message:");
        }

        SOAPMessage message = smc.getMessage();
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            message.writeTo(baos);
            System.out.println(baos.toString());
        } catch (Exception e) {
            System.out.println("Exception in handler: " + e);
        }
    }
}
