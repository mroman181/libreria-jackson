package comunicaciones;

public class Comunicaciones {

    public static void main(String[] args){
        final ObjectResponse o = ObjectResponse.Builder.builder("shoot")
                .withColor("black")
                .withHeight(50)
                .withIP("192.168.1.1")
                .withLife(100)
                .withPosicionX(200)
                .withPosicionYInPercent(20)
                .withUserName("Marc")
                .build();
        
        final ConnectionResponse c = ConnectionResponse.Builder.builder()
                .withColor("blue")
                .withRight(true)
                .withShipType("34")
                .build();
        
        final KillerAction action = KillerAction.Builder.builder()
                .withDirection("UP")
                .withSpeedX(10)               
                .build();
        
        final String command = "kill";
        final String senderId = "192.168.1.1";
        
        final Message m = Message.Builder.builder(command, senderId)
                .withRelay(true)
                .withObject(o)
                .withConnection(c)
                .withAction(action)
                .build();
       
        final String jsonStr = Message.convertMessageToJson(m);
        System.out.println(jsonStr);       
                
        final Message messageReceived = Message.readMessage(jsonStr);
        System.out.println(Message.convertMessageToJson(messageReceived));
        System.out.println(messageReceived.getObjectResponse().getObjectType());
        System.out.println(messageReceived.getConnectionResponse().getColor());
        System.out.println(messageReceived.getAction().getDirection());
        
        
    }
    
}
