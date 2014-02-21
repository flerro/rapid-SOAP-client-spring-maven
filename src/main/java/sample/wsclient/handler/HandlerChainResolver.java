package sample.wsclient.handler;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.PortInfo;
import java.util.List;

/**
 * A list based implementation for handlers to be invoked
 * before each service request and after each service response
 *
 * eg. Dump SOAP XML payload
 */
public class HandlerChainResolver implements
                        javax.xml.ws.handler.HandlerResolver {

    private List<Handler> handlerList;

    public List<Handler> getHandlerChain(PortInfo portInfo) {
        return handlerList;
    }

    public void setHandlerList(List<Handler> handlerList) {
        this.handlerList = handlerList;
    }
}
