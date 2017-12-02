
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jnaneshbt
 */
public class mqttSubscriber implements MqttCallback {

    String brokerAddress = "tcp://localhost:1883";
    MqttClient client;

    public mqttSubscriber() {
        System.out.println("MQTT SUBSCRIBER STARTED ");
        try {
            client = new MqttClient(brokerAddress, "IoT Subscriber");
            client.connect();
            client.setCallback((MqttCallback) this);
            this.subscribe("IoT");

        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void connectionLost(Throwable cause) {
        System.out.println("IoT Broker " + brokerAddress + " disconnected");

    }

    @Override
    public void messageArrived(String topic, MqttMessage message)
            throws Exception {
        System.out.println("Message arrived for " + topic + " : " + message);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
    }

    public static void main(String[] args) {
        mqttSubscriber ms = new mqttSubscriber();
        ms.subscribe("Humidity");
        ms.subscribe("Temperature");
        ms.subscribe("Gravity");
        ms.subscribe("WeighScale");
        
    }

    private void subscribe(String topic) {
        try {
            client.subscribe(topic);
            System.out.println("Subscribed " + topic);

        } catch (MqttException ex) {
            Logger.getLogger(mqttSubscriber.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
