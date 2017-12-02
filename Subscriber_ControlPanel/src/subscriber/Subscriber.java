/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subscriber;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jnaneshbt
 */
public class Subscriber implements MqttCallback {

    String clientId = "IOT Subscriber";
    String brokerAddress = "tcp://localhost:1883";
    private static MqttClient client=null;
    public Subscriber() {
        connect(brokerAddress);
    }

    public Subscriber(String broker) {
        brokerAddress = broker;
        connect(brokerAddress);
    }

    public void connect(String brokerIP) {
        try {
            if(client == null)
            {
            client = new MqttClient(brokerIP, clientId);
            client.connect();
            client.setCallback((MqttCallback) this);
            System.out.println("MQTT SUBSCRIBER STARTED ");
            }

        } catch (MqttException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void connectionLost(Throwable cause) {
        System.out.println(clientId+ " " + brokerAddress + " disconnected");

    }

    
    @Override
    public void messageArrived(String topic, MqttMessage message)
            throws Exception {
        String m = topic + " : " + message;
        System.out.println(m);
        ui.getInstance().topicMsg(topic,message);
        

    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        try {
            ui.getInstance().logMsg("DELIVERY COMP : " + token.getMessage().toString());
        } catch (MqttException ex) {
            Logger.getLogger(Subscriber.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void subscribe(String topic) {
        if(topic == null || topic.isEmpty())
            return ;
        try {
            String m = "Subscribed " + topic;
            
            client.subscribe(topic);
            System.out.println(m);
            ui.getInstance().logMsg(m);
        } catch (MqttException ex) {
            Logger.getLogger(Subscriber.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static Subscriber instance = null;
    public static Subscriber getInstance_depr()
    {
        if(instance == null)
        {
             instance = new Subscriber();            
        }
        
        return instance;
    }

    static private ui u ;
    public void setup()
    {
        u.topic_subscribe("Gravity");
        u.topic_subscribe("Temperature");
        u.topic_subscribe("WeighScale");
        u.topic_subscribe("Humidity");
        
    }
    public static void main(String[] args) {


        System.out.println(" Starting Susbscriber");
        u = new ui();
        u.startui();

    }

}
