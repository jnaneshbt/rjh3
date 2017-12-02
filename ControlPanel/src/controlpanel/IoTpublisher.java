/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlpanel;

/**
 *
 * @author jnaneshbt
 */


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jnaneshbt
 */
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class IoTpublisher {

    private final String brokerAddress;
    private final String clientId;
    
    private IoTpublisher instance;
    
    public IoTpublisher(String brokerAddr, String cid)
    {
        brokerAddress = brokerAddr;
        clientId = cid;
    }
    
     public void publish(String topic, String content) {

         
        int qos = 2;
        MemoryPersistence persistence = new MemoryPersistence();

        try {
            MqttClient mqttClient = new MqttClient(brokerAddress, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: " + brokerAddress);
            mqttClient.connect(connOpts);
            System.out.println("Connected");
            System.out.println("Publishing message: " + content);
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(qos);
            mqttClient.publish(topic, message);
            System.out.println("Message published");
            mqttClient.disconnect();
            System.out.println("Disconnected");

        } catch (MqttException me) {
            System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("excep " + me);
            me.printStackTrace();
        }
    }
    

    public static void main(String[] args) throws InterruptedException {
        IoTpublisher mpub = new IoTpublisher("tcp:/localhost:1883","IoT Control Panel");
        String topic = "MQTT";
        String content = "Message from MQTT PUBLISHER";
        mpub.publish(topic, content);
        mpub.publish(topic+"/TEMP", "TEMPERATURE");
        System.out.println("Exiting ");
    }
}

  